package controller;

import model.Contact;
import model.Subscription;
import service.TelecomService;
import service.impl.SubscriptionServiceImpl;

import java.util.List;

public class SubscriptionController {
    private TelecomService<Subscription> subscriptionService;

    public SubscriptionController(){
        this.subscriptionService = new SubscriptionServiceImpl();
    }

    public void add(Subscription subscription){
        subscriptionService.create(subscription);
        System.out.printf("%s added. %n",subscription);
    }

    public List<Subscription> getAll(){
        return subscriptionService.findAll();
    }
    public void update(Subscription subscription) {
        subscriptionService.update(subscription);
    }

    public Subscription getById(int id) {
        return subscriptionService.findById(id);
    }

    public void delete(int id){
        boolean deleted = subscriptionService.deleteById(id);
        System.out.printf("Subscription deleted. %b%n",deleted);
    }

    public void list(){
        List<Subscription> subscriptionList = subscriptionService.findAll();
        subscriptionList.stream().forEach(System.out::println);
    }

}
