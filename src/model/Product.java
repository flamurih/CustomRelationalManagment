package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Product{
    private int id;
    private String name;
    private double price;
    private LocalDate fromDateTime;
    private LocalDate toDateTime;
    private List<Service> services;

    public Product(int id,String name, double price,
                   LocalDate fromDateTime, LocalDate toDateTime, List<Service> services) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.fromDateTime = fromDateTime;
        this.toDateTime = toDateTime;
        this.services = services;

    }

    public int getId() {
        return id;
    }

    public void addServiceType(Service service) {
        services.add(service);
    }
    public List<Service> getServices() {
        return services;
    }
    public void setServiceTypes(List<Service> services) {
        this.services = services;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getFromDateTime() {
        return fromDateTime;
    }

    public void setFromDateTime(LocalDate fromDateTime) {
        this.fromDateTime = fromDateTime;
    }

    public LocalDate getToDateTime() {
        return toDateTime;
    }

    public void setToDateTime(LocalDate toDateTime) {
        this.toDateTime = toDateTime;
    }
    public void setServices(List<Service> services){
        this.services = services;
    }

    public boolean isProductAvailable(Product product) {
        LocalDate currentDate = LocalDate.now();
        LocalDate validFromDateTime = product.fromDateTime;
        LocalDate validToDateTime = product.toDateTime;

        return currentDate.isAfter(validFromDateTime) && currentDate.isBefore(validToDateTime);
    }

    public boolean isPurchasable(Customer customer) {
        LocalDateTime currentTime = LocalDateTime.now();
        if (currentTime.isBefore(fromDateTime.atStartOfDay()) || currentTime.isAfter(toDateTime.atStartOfDay())) {
            return false;
        }

        for (Service service : services) {
            if (!customer.isAllowedToUse(service)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("=============================================").append("\n");
        sb.append("ID: ").append(id).append("\n");
        sb.append("Name: ").append(name).append("\n");
        sb.append("Created Date: ").append(fromDateTime).append("\n");
        sb.append("Expiration Date: ").append(toDateTime).append("\n");
        sb.append("Price: ").append(price).append("\n");
        sb.append("=============================================").append("\n");

        return sb.toString();
    }

}
