package mapper;

import entity.CustomerData;
import exception.CustomerException;
import model.Customer;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerMapper {
    public Customer fromCustomerData(CustomerData customerData){
        return new Customer(customerData.getId(),customerData.getCreatedDate(),customerData.getCustomerType(),customerData.getState(),customerData.getContracts(),customerData.getContact());
    }

    public CustomerData toCustomerData(Customer customer){
        return new CustomerData(customer.getId(),customer.getCreatedDate(),customer.getCustomerType(),customer.getState(),customer.getContracts(),customer.getContact());
    }

    public List<Customer> fromCustomerData(List<CustomerData> customers) throws CustomerException {
        return customers.stream().map(this::fromCustomerData).collect(Collectors.toList());
    }
}
