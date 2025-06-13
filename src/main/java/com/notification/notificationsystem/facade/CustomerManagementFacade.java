package com.notification.notificationsystem.facade;

import com.notification.notificationsystem.entity.Customer;
import com.notification.notificationsystem.entity.NotificationPreference;
import com.notification.notificationsystem.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerManagementFacade {

    private final CustomerRepository customerRepository;

    // Create or update customer (address will be handled by JPA cascade)
    @Transactional
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Find all customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Find customer by ID
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    // Delete customer
    @Transactional
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
    public boolean emailExists(String email) {
        return customerRepository.existsByEmail(email);
    }
    @Transactional
    public Customer saveCustomerWithPreferences(Customer customer, NotificationPreference preference) {
        customer.setNotificationPreference(preference);
        return customerRepository.save(customer);
    }

}
