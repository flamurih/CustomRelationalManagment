import controller.*;
import model.*;
import org.hibernate.HibernateException;
import service.impl.CustomerServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try{
            //ARRAYLISTS
            List<Service> serviceList = new ArrayList<>();
            List<Subscription> subscriptionList = new ArrayList<>();
            List<Contract> contractList = new ArrayList<>();
            List<Contact> contactList = new ArrayList<>();
            List<ServiceTypes> serviceTypes = new ArrayList<>();

            //CONTROLLERS
            ContactController contactController = new ContactController();
            ContractController contractController = new ContractController();
            CustomerController customerController = new CustomerController();
            ProductController productController = new ProductController();
            ServiceController serviceController = new ServiceController();
            SubscriptionController subscriptionController = new SubscriptionController();

            //ServiceTypes
            ServiceTypes srv1 = ServiceTypes.VOICE;
            ServiceTypes srv2 = ServiceTypes.SIMCARD;
            //Adding to serviceTypesList
            serviceTypes.add(srv1);
            serviceTypes.add(srv2);


            //Creating Service
            Service service1 = new Service(1,LocalDate.now(),State.ACTIVE,serviceTypes);

            //service adding to db
            serviceController.add(service1);
            //Adding Service to serviceList
            serviceList.add(service1);

            // Creating Contact
            Contact contact1 = new Contact(1,IdType.CO,"Contact1","LastName","CustomerName", Gender.M,LocalDate.now(),LocalDate.now(),State.ACTIVE);
            Contact contact2 = new Contact(2,IdType.SU,"Contact2","LastName","CustomerName", Gender.M,LocalDate.now(),LocalDate.now(),State.ACTIVE);

            //contact adding to db
            contactController.add(contact1);
            contactController.add(contact2);


            //Creating Subscription
            Subscription subscription1 = new Subscription(1,"+38344567890",LocalDate.now(),State.ACTIVE,serviceList, contact2);

            //subscription adding to db
            subscriptionController.add(subscription1);

            //Adding Subscription to subscriptionList
            subscriptionList.add(subscription1);

            //Creating a Contract
            Contract contract1 = new Contract(1,LocalDate.now(),ContractType.PREPAID,State.ACTIVE,subscriptionList,contact1);
            Contract contract2 = new Contract(1,LocalDate.now(),ContractType.PREPAID,State.ACTIVE,subscriptionList,contact1);
            //contract adding to db
            contractController.add(contract1);
            contractController.add(contract2);

            //Adding Contracts to contractList
            contractList.add(contract1);
            contractList.add(contract2);

            Customer customer1 = new Customer(1,LocalDate.now(),CustomerType.INDIVIDUAL,State.ACTIVE,contractList,contact1);
            Customer customer2 = new Customer(2,LocalDate.now(),CustomerType.INDIVIDUAL,State.ACTIVE,contractList,contact2);
            //customer adding to db
            customerController.add(customer1);
            customerController.add(customer2);


//        CustomerController customers = new CustomerController(customerService);
//        customerService.create(customer1);
//        customerService.create(customer1);
//        customerService.create(customer1);
//
//        customers.add(customer1);
//        customers.add(customer2);
//        customers.add(customer3);

            Product product1 = new Product(1,"Product1",4.5,LocalDate.now(),LocalDate.now().plusMonths(2),serviceList);
            //product adding to db
            productController.add(product1);
//
            System.out.println(service1);
            System.out.println(contract1);
            System.out.println(contact1);
            System.out.println(customer1);
            System.out.println(subscription1);
            System.out.println(product1);

        }catch(HibernateException e){
            e.getMessage();
        }
    }
}