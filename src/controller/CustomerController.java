package controller;

import exception.CustomerException;
import model.Customer;
import service.TelecomService;
import service.impl.CustomerServiceImpl;

import java.util.List;

public class CustomerController {
    private TelecomService<Customer> customerService;

    public CustomerController(TelecomService<Customer> customerService){
        this.customerService = customerService;
    }

//    public Customer update(Customer customer){
//
//    }
    public void add(Customer customer) throws CustomerException {
        try{
            customerService.create(customer);
        } catch(CustomerException ce){
            System.out.println(ce.getMessage());
        }
    }

    public void delete(int id) throws CustomerException{
        try{
            boolean deleted = customerService.deleteById(id);
            System.out.printf("Consumer deleted. %b%n",deleted);
        }catch(CustomerException ce){
            System.out.println(ce.getMessage());
        }
    }

    public void list(){
        List<Customer> customerList = customerService.findAll();
        customerList.stream().forEach(System.out::println);
    }

}