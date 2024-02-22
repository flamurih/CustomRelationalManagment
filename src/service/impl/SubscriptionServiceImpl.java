package service.impl;

import model.Subscription;
import service.TelecomService;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionServiceImpl implements TelecomService<Subscription> {
    private List<Subscription> subscriptionList = new ArrayList<>();
    private TelecomService subscriptionRepository;
    private final String path = "C:\\Users\\Flamur\\Desktop\\JAVA-WORKSPACE\\JavaProject\\src";

    public SubscriptionServiceImpl(){
        //this.subscriptionRepository = new SubscriptionFileRepository(path);
    }
    @Override
    public void create(Subscription subscription) {
        subscriptionList.add(subscription);
    }

    @Override
    public Subscription findById(int id) {
        return null;
    }

    @Override
    public List<Subscription> findAll() {
        return subscriptionList;
    }

    public boolean delete(Subscription subscription) {
        subscriptionList.remove(subscription);
        return true;
    }

    @Override
    public void update(Subscription subscription) {
        //Update logic
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

}
