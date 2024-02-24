package model;

import exception.CustomerException;

import java.time.LocalDate;
import java.util.*;

public class Customer
{
    private int id;
    private LocalDate createdDate;
    private CustomerType customerType;
    private State state;
    private List<Contract> contracts;
    private Contact contact;


    public Customer (int id, LocalDate createdDate, CustomerType customerType, State state, List<Contract> contracts, Contact contact) throws CustomerException {
        this.id = id;
        this.createdDate = LocalDate.now();
        this.customerType = customerType;
        this.state = state;
        this.contracts = contracts;
        this.contact = contact;
    }

    public int getId(){
        return id;
    }
    public LocalDate getCreatedDate(){
        return createdDate;
    }
    public LocalDate getDate(){
        return createdDate;
    }
    public CustomerType getCustomerType(){
        return customerType;
    }
    public State getState(){
        return state;
    }
    public Contact getContact(){
        return contact;
    }
    public List<Contract> getContracts(){
        return contracts;
    }

    public void setCustomerType(CustomerType customerType){
        this.customerType = customerType;
    }

    public void setContracts(List<Contract> contracts){
        this.contracts = contracts;
    }

    public void setContact(Contact contact){
        this.contact = contact;
    }
    public boolean isAllowedToUse(Service service) {
        if (state != State.ACTIVE) {
            return false;
        }
        if(customerType == CustomerType.INDIVIDUAL){

            for (Contract contract : contracts) {
                if (contract.getContractType() == ContractType.PREPAID && contract.getState() == State.ACTIVE) {
                    return true;
                }
            }
        }else{
            for (Contract contract : contracts) {
                if (contract.getState() == State.ACTIVE) {
                    return true;
                }
            }
        }
        return false;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("=============").append("Customers").append("=============").append("\n");
        sb.append("ID : ").append(id).append("\n");
        sb.append("Created Date: ").append(createdDate).append("\n");
        sb.append("Customer Type: ").append(customerType).append("\n");
        sb.append("State: ").append(state).append("\n");
        sb.append("=======================================").append("\n");
        return sb.toString();
   }

}