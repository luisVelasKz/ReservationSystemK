package com.hotel.reservation.customer;

// Clase CustomerManager
public class CustomerManager {
    private final ICustomerRepository customerRepository;

    public CustomerManager(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addCustomer(Customer customer) {
        customerRepository.addCustomer(customer);
        System.out.println("Cliente " + customer.getName() + " agregado.");
    }

    public void removeCustomer(Customer customer) {
        customerRepository.removeCustomer(customer);
        System.out.println("Cliente " + customer.getName() + " eliminado.");
    }

    public Customer findCustomer(String customerId) {
        return customerRepository.findCustomer(customerId);
    }
}
