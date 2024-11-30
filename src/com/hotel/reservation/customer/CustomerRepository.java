package com.hotel.reservation.customer;

import java.util.*;
// Implementación concreta de ICustomerRepository
public class CustomerRepository implements ICustomerRepository {
    private final List<Customer> customers = new ArrayList<>();

    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    @Override
    public Customer findCustomer(String customerId) {
        for (Customer customer : customers) {
            if (Objects.equals(customer.getId(), customerId)) {
                return customer;
            }
        }
        return null;
    }
}
