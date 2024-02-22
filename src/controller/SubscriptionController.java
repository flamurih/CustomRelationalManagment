package controller;

import model.Subscription;
import service.TelecomService;
import service.impl.SubscriptionServiceImpl;

import java.util.List;

public class SubscriptionController {
    private TelecomService<Subscription> subscriptionService;

    public SubscriptionController(TelecomService<Subscription> subscriptionService){
        this.subscriptionService = subscriptionService;
    }

    public void add(Subscription subscription){
        subscriptionService.create(subscription);
        System.out.printf("%s added. %n",subscription);
    }

//    public Subscription update(Subscription subscription){
//
//    }

    public void delete(int id){
        boolean deleted = subscriptionService.deleteById(id);
        System.out.printf("Subscription deleted. %b%n",deleted);
    }

    public void list(){
        List<Subscription> subscriptionList = subscriptionService.findAll();
        subscriptionList.stream().forEach(System.out::println);
    }

}
