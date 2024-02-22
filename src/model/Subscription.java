package model;

import exception.SubscriptionException;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Subscription {
    private UUID id;
    private String phoneNumber;
    private LocalDate createdDate;
    private State state;
    private List<Service> services;
    private Contact contact;

    public Subscription(String phoneNumber, State state, List<Service> services, Contact contact) throws SubscriptionException {
        if (!phoneNumber.matches("^\\+3834[4-6][1-9]\\d{5}$")) {
            throw new SubscriptionException("Phone number is not valid.");
        }
        if(contact.getIdType() != IdType.SU){
            throw new SubscriptionException("Contact is not subscription allowed");
        }

        id = UUID.randomUUID();
        this.phoneNumber = phoneNumber;
        this.createdDate = LocalDate.now();
        this.state = state;
        this.services = services;
        this.contact = contact;
    }


    public String getPhoneNumber(){
        return phoneNumber;
    }

    public LocalDate getCreatedDate(){
        return createdDate;
    }

    public State getState(){
        return state;
    }

    public void setPhoneNumber(String number){
        phoneNumber = number;
    }
    public State isActive() {
        return state;
    }
    public void addService(Service service) {
        services.add(service);
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("=============").append("SUBSCRIPTIONS").append("=============").append("\n");
        sb.append("ID : ").append(id).append("\n");
        sb.append("Phone Number : ").append(phoneNumber).append("\n");
        sb.append("Created Date: ").append(createdDate).append("\n");
        sb.append("State: ").append(state).append("\n");
        sb.append("=======================================").append("\n");
        return sb.toString();
    }

}
