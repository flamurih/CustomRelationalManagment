package service.impl;

import model.Customer;
import repository.TelecomRepository;
import repository.impl.CustomerFileRepository;
import service.TelecomService;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements TelecomService<Customer> {
    private TelecomRepository customerRepository;

    public CustomerServiceImpl(){
        this.customerRepository = new CustomerFileRepository();
    }
    @Override
    public void create(Customer entity) {
        customerRepository.create(entity);
    }

    @Override
    public void update(Customer entity) {
        customerRepository.update(entity);
    }

    @Override
    public boolean deleteById(int id) {

        return customerRepository.deleteById(id);
    }

    @Override
    public Customer findById(int id) {
        return (Customer) customerRepository.findById(id);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
