package service;

import model.Service;

import java.util.List;

public interface ServiceService {
    void create(Service service);

    Service findById(int id);

    List<Service> findAll();

    boolean deleteById(int id);

    void update(Service service);

}
