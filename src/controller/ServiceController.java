package controller;

import model.Service;
import service.ServiceService;
import service.impl.ServiceImpl;

import java.util.List;

public class ServiceController {
    private ServiceService service;

    public ServiceController(){
        this.service = new ServiceImpl();
    }

    public void add(Service s){
        service.create(s);
        System.out.printf("%s added. %n",service);
    }

    public void delete(int id){
        boolean deleted = service.deleteById(id);
        System.out.printf("Consumer deleted. %b%n",deleted);
    }

    public void listContacts(){
        List<Service> serviceList = service.findAll();
        serviceList.stream().forEach(System.out::println);
    }

    public void count(){
        System.out.printf("There are %d services.%n",service.count());
    }
}
