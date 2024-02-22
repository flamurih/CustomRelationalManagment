package model;

public interface ServiceType {
    void useSimCard();

    void useVoice();

    default void sendSMS() {
        System.out.println("Sending SMS...");
    }

    default void useData() {
        System.out.println("Using Data...");
    }
}
