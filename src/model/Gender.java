package model;

public enum Gender {
    M("Mashkull"),
    F("Femer");

    private String description;

    Gender(String desc){
        description = desc;
    }
    @Override
    public String toString(){
        return description;
    }
}
