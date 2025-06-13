package com.notification.notificationsystem.controller;

import com.notification.notificationsystem.entity.Customer;
import com.notification.notificationsystem.facade.CustomerManagementFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerManagementFacade customerFacade;

    @GetMapping
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerFacade.getAllCustomers());
        return "customers/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customers/form";
    }

    @PostMapping
    public String createCustomer(@Valid @ModelAttribute Customer customer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "customers/form";
        }

        if (customerFacade.emailExists(customer.getEmail())) {
            result.rejectValue("email", "error.customer", "Email already exists");
            return "customers/form";
        }

        customerFacade.saveCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Customer customer = customerFacade.getCustomerById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid customer Id: " + id));
        model.addAttribute("customer", customer);
        return "customers/form";
    }

    @PostMapping("/update/{id}")
    public String updateCustomer(@PathVariable Long id, @Valid @ModelAttribute Customer customer, BindingResult result) {
        if (result.hasErrors()) {
            return "customers/form";
        }

        customer.setId(id); // ensure ID is preserved
        customerFacade.saveCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerFacade.deleteCustomer(id);
        return "redirect:/customers";
    }
}
