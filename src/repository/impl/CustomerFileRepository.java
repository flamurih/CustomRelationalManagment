package repository.impl;

import exception.CustomerException;
import model.Contract;
import model.Customer;
import repository.TelecomRepository;

import java.util.List;

public class CustomerFileRepository implements TelecomRepository<Customer> {
    public CustomerFileRepository() throws CustomerException{

    }
    @Override
    public void create(Customer customer) {

    }

    @Override
    public Contract findById(int id) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public void update(Customer customer) {

    }


}
