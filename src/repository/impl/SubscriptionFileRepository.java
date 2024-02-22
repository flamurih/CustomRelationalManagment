package repository.impl;

import exception.SubscriptionException;
import model.Contract;
import model.Subscription;
import repository.TelecomRepository;

import java.util.List;

public class SubscriptionFileRepository implements TelecomRepository<Subscription> {
    public SubscriptionFileRepository(String path) throws SubscriptionException{

    }
    @Override
    public void create(Subscription subscription) {

    }

    @Override
    public Contract findById(int id) {
        return null;
    }

    @Override
    public List<Subscription> findAll() {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public void update(Subscription subscription) {

    }

}
