package com.hotel.reservation.customer;

// Interfaz para la gestión de clientes
public interface ICustomerRepository {
    void addCustomer(Customer customer);
    void removeCustomer(Customer customer);
    Customer findCustomer(String customerId);
}
