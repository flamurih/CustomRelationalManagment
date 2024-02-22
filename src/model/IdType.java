package model;

public enum IdType {
    CU("Customer"),
    CO("Contract"),
    SU("Subscription");

    private String description;
    IdType(String desc){
        description = desc;
    }
    @Override
    public String toString(){
        return description;
    }
}
