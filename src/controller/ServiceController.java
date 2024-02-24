package controller;

import model.Contact;
import model.Service;
import service.ServiceService;
import service.impl.ServiceImpl;

import java.util.List;

public class ServiceController {
    private ServiceService service_s;

    public ServiceController(){
        this.service_s = new ServiceImpl();
    }

    public void add(Service s){
        service_s.create(s);
        System.out.printf("%s added. %n",s);
    }

    public void update(Service service) {
        service_s.update(service);
    }
    public void delete(int id){
        boolean deleted = service_s.deleteById(id);
        System.out.printf("Consumer deleted. %b%n",deleted);
    }

    public Service getById(int id) {
        return service_s.findById(id);
    }
    public void list(){
        List<Service> serviceList = service_s.findAll();
        serviceList.stream().forEach(System.out::println);
    }

}
