package model;

import exception.ContractException;
import exception.CustomerException;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Contract
{
    private int id;
    private LocalDate createdDate;
    private ContractType contractType;
    private State state;
    private List<Subscription> subscriptions;
    private Contact contact;

    public Contract(int id,LocalDate createdDate, ContractType contractType, State state, List<Subscription> subscriptions, Contact contact) throws ContractException {
        if(contact.getIdType() != IdType.CO){
            throw new ContractException("Contact is not Contract allowed");
        }
        this.id = id;
        this.createdDate = LocalDate.now();
        this.contact = contact;
        this.contractType = contractType;
        this.state = state;
        this.subscriptions = subscriptions;
    }
    public int getId(){
        return id;
    }

    public LocalDate getCreatedDate(){
        return createdDate;
    }
    public ContractType getContractType(){
        return contractType;
    }
    public State getState(){
        return state;
    }
    public List<Subscription> getSubscriptions(){
        return subscriptions;
    }
    public void setContractType(ContractType contractType){
        this.contractType = contractType;
    }
    public void setState(State state){
        this.state = state;
    }
    public void setSubscriptions(List<Subscription> subscriptions){
        this.subscriptions = subscriptions;
    }
    public Contact getContact(){
        return contact;
    }
    public void setContact(Contact contact){
        this.contact = contact;
    }

   @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
       sb.append("=============").append("CONTRACTS").append("=============").append("\n");
       sb.append("ID: ").append(id).append("\n");
        sb.append("Created Date: ").append(createdDate).append("\n");
        sb.append("ContractType: ").append(contractType).append("\n");
        sb.append("State: ").append(state).append("\n");
        sb.append("=======================================").append("\n");

       return sb.toString();
   }

}