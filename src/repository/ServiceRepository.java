package repository;

import model.Service;

import java.util.List;

public interface ServiceRepository {
    void create(Service service);
    void findById(int id);
    List<Service> findAll();
    boolean deleteById(int id);
    void update(Service service);

}
