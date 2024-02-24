package model;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Service {
    private int id;
    private LocalDate createdDate;
    private State state;
    private List<ServiceTypes> serviceTypes;

    public Service(int id, LocalDate createdDate, State state, List<ServiceTypes> serviceTypes) {
        this.id = id;
        this.createdDate = createdDate;
        this.state = state;
        this.serviceTypes = serviceTypes;
    }

    public int getId(){
        return id;
    }

    public LocalDate getCreatedDate(){
        return createdDate;
    }
    public State getState(){
        return state;
    }
    public void setState(State state){
        this.state = state;
    }

    public List<ServiceTypes> getServiceTypes(){
        return serviceTypes;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("=============").append("SERVICES").append("=============").append("\n");
        sb.append("ID : ").append(id).append("\n");
        sb.append("Created Date: ").append(createdDate).append("\n");
        sb.append("State: ").append(state).append("\n");
        sb.append("=======================================").append("\n");
        return sb.toString();
    }

}
