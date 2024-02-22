import controller.CustomerController;
import model.*;
import service.impl.CustomerServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Service> serviceList = new ArrayList<>();
        List<Subscription> subscriptionList = new ArrayList<>();
        List<Contract> contractList = new ArrayList<>();
        

//        Service service1 = new Service(State.ACTIVE);
//        serviceList.add(service1);
//
//        Contact contact1 = new Contact(IdType.SU,State.ACTIVE);
//        Subscription subscription1 = new Subscription("+38346512345",State.ACTIVE,  serviceList, contact1);
//        subscriptionList.add(subscription1);
//
//        Contact contact2 = new Contact(IdType.CO,State.ACTIVE);
//        Contract contract1 = new Contract(ContractType.PREPAID,State.ACTIVE,subscriptionList,contact2);
//        Contract contract2 = new Contract(ContractType.PREPAID,State.ACTIVE,subscriptionList,contact2);
//        Contract contract3 = new Contract(ContractType.PREPAID,State.ACTIVE,subscriptionList,contact2);
//
//        contractList.add(contract1);
//        contractList.add(contract2);
//        contractList.add(contract3);
//
//
//        Customer customer1 = new Customer( CustomerType.INDIVIDUAL, State.ACTIVE,contractList, contact1);
//        Customer customer2 = new Customer( CustomerType.INDIVIDUAL, State.INACTIVE,contractList, contact1);
//        Customer customer3 = new Customer( CustomerType.BUSINESS, State.DEACTIVE,contractList, contact1);
//
//        CustomerServiceImpl customerService = new CustomerServiceImpl();
//        CustomerController customers = new CustomerController(customerService);
//        customerService.create(customer1);
//        customerService.create(customer1);
//        customerService.create(customer1);
//
//        customers.add(customer1);
//        customers.add(customer2);
//        customers.add(customer3);
//
//        Product product1 = new Product("product",15.2,LocalDate.now(),LocalDate.of(2025,05,12),serviceList);
//
//        System.out.println(serviceList);
//        System.out.println(contractList);
//        System.out.println(contact1);
//        System.out.println(customer1);
//        System.out.println(subscriptionList);
//        System.out.println(product1);

    }
}