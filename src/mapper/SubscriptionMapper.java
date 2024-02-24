package mapper;

import entity.SubscriptionData;
import exception.SubscriptionException;
import model.*;

import java.util.List;
import java.util.stream.Collectors;

public class SubscriptionMapper {
    public Subscription fromSubscriptionData(SubscriptionData subscriptionData){
        return new Subscription(subscriptionData.getId(), subscriptionData.getPhoneNumber(), subscriptionData.getCreatedDate(), subscriptionData.getState(), subscriptionData.getServices(),subscriptionData.getContact());
    }

    public SubscriptionData toSubscriptionData(Subscription subscription){
        return new SubscriptionData(subscription.getId(), subscription.getPhoneNumber(), subscription.getCreatedDate(), subscription.getState(), subscription.getServices(),subscription.getContact());
    }

    public List<Subscription> fromSubscriptionData(List<SubscriptionData> subscriptions) throws SubscriptionException {
        return subscriptions.stream().map(this::fromSubscriptionData).collect(Collectors.toList());
    }
}
