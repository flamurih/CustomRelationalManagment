package model;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Service implements ServiceType{
    private UUID id;
    private LocalDate createdDate;
    private State state;
    private List<String> serviceTypes;

    @Override
    public void useSimCard() {
        System.out.println("Using SimCard...");
        serviceTypes.add("Simcard");
    }
    @Override
    public void useVoice() {
        System.out.println("Using Voice...");
        serviceTypes.add("Voice");
    }
    @Override
    public void sendSMS() {
        System.out.println("Sending SMS...");
        serviceTypes.add("SMS");
    }
    @Override
    public void useData() {
        System.out.println("Using Data...");
        serviceTypes.add("Data");
    }

    public Service(State state){

        this.id = UUID.randomUUID();
        this.createdDate = LocalDate.now();
        this.state = state;
    }

    public UUID getId(){
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
