package service.impl;

import model.Subscription;
import repository.TelecomRepository;
import repository.impl.SubscriptionFileRepository;
import service.TelecomService;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionServiceImpl implements TelecomService<Subscription> {
    private TelecomRepository subscriptionRepository;

    public SubscriptionServiceImpl(){
        this.subscriptionRepository = new SubscriptionFileRepository();
    }
    @Override
    public void create(Subscription subscription) {
        subscriptionRepository.create(subscription);
    }

    @Override
    public Subscription findById(int id) {
        return (Subscription) subscriptionRepository.findById(id);
    }

    @Override
    public List<Subscription> findAll() {
        return subscriptionRepository.findAll();
    }

    public boolean delete(int id) {
        subscriptionRepository.deleteById(id);
        return true;
    }

    @Override
    public void update(Subscription subscription) {
        subscriptionRepository.update(subscription);
    }

    @Override
    public boolean deleteById(int id) {
        return subscriptionRepository.deleteById(id);
    }

}
