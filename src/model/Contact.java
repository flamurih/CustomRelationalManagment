package model;

import exception.ContactException;
import exception.CustomerException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

public class Contact {
    private int id;
    private IdType idType;
    private String name;
    private String lastName;
    private String customerName;
    private Gender gender;
    private LocalDate dob;
    private LocalDate createdDate;
    private State state;


    public Contact(int id, IdType idType, String name, String lastName, String customerName, Gender gender, LocalDate dob, LocalDate createdDate, State state) {
        this.id = id;
        this.idType = idType;
        this.name = name;
        this.lastName = lastName;
        this.customerName = customerName;
        this.gender = gender;
        this.dob = dob;
        this.createdDate = createdDate;
        this.state = state;
    }

    public int getId(){
        return id;
    }

    public IdType getIdType() {
        return idType;
    }

    public void setIdType(IdType idType) {
        this.idType = idType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Contact ID: ").append(id).append("\n");
        sb.append("ID Type: ").append(idType).append("\n");
        sb.append("Name: ").append(name).append("\n");
        sb.append("Last Name: ").append(lastName).append("\n");
        sb.append("Customer Name: ").append(customerName).append("\n");
        sb.append("Gender: ").append(gender).append("\n");
        if(dob != null){
            sb.append("Date of Birth: ").append(dob.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))).append("\n");
        }else{
            sb.append("N/A").append("\n");
        }
        sb.append("Created Date: ").append(createdDate).append("\n");
        sb.append("State: ").append(state).append("\n");

        return sb.toString();
    }
}
