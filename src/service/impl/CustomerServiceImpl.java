package service.impl;

import model.Customer;
import repository.TelecomRepository;
import repository.impl.CustomerFileRepository;
import service.TelecomService;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements TelecomService<Customer> {
    private TelecomRepository customerRepository;
    private List<Customer> customers = new ArrayList<>();

    public CustomerServiceImpl(){
       // this.customerRepository = new CustomerFileRepository(path);
    }
    @Override
    public void create(Customer entity) {
        customers.add(entity);
    }

    @Override
    public void update(Customer entity) {
        // Implement update logic
    }

    @Override
    public boolean deleteById(int id) {

        return true;
    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }
}
