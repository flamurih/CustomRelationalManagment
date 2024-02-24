package controller;

import exception.CustomerException;
import model.Contact;
import model.Customer;
import service.TelecomService;
import service.impl.CustomerServiceImpl;

import java.util.List;

public class CustomerController {
    private TelecomService<Customer> customerService;

    public CustomerController(){
        this.customerService = new CustomerServiceImpl() ;
    }
    public void add(Customer customer) throws CustomerException {
        try{
            customerService.create(customer);
        } catch(CustomerException ce){
            System.out.println(ce.getMessage());
        }
    }

    public void update(Customer customer){
        customerService.update(customer);
    }
    public void delete(int id) throws CustomerException{
        try{
            boolean deleted = customerService.deleteById(id);
            System.out.printf("Consumer deleted. %b%n",deleted);
        }catch(CustomerException ce){
            System.out.println(ce.getMessage());
        }
    }

    public Customer getById(int id) {
        return customerService.findById(id);
    }
    public void list(){
        List<Customer> customerList = customerService.findAll();
        customerList.stream().forEach(System.out::println);
    }

}