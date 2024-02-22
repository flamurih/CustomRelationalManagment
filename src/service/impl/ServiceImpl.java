package service.impl;

import model.Service;
import repository.ServiceRepository;
import service.ServiceService;

import java.util.List;

public class ServiceImpl implements ServiceService {
    private ServiceRepository serviceRepository;
    private final String path = "C:\\Users\\Flamur\\Desktop\\JAVA-WORKSPACE\\JavaProject\\src";

    @Override
    public void create(Service service) {
        serviceRepository.create(service);
    }

    @Override
    public void findById(int id) {
    }

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        return serviceRepository.deleteById(id);
    }

    @Override
    public void update(Service service) {
        serviceRepository.update(service);
    }

    @Override
    public int count() {
        return 0;
    }
}
