package ro.unibuc.fmi.service;

import ro.unibuc.fmi.Customer;
import ro.unibuc.fmi.repository.CustomerRepository;

public class CustomerService {

    private static CustomerService instance;

    private final CustomerRepository customerRepository = CustomerRepository.getInstance();

    private CustomerService() {
    }

    public static CustomerService getInstance() {
        if (instance == null) {
            instance = new CustomerService();
        }

        return instance;
    }

    public Customer saveCustomer(String nume, int spend) {
        Customer customer = new Customer();
        customer.setSpend(spend);
        customer.setName(nume);

        return customerRepository.saveCustomer(customer);
    }

    public Customer findCustomer(String nume) {
        return customerRepository.findCustomer(nume);
    }

    public Customer updateCustomer(Customer customer) {
        return customerRepository.updateCustomer(customer);
    }

    public boolean deleteCustomer(String nume) {
        return customerRepository.deleteCustomer(nume);
    }

}