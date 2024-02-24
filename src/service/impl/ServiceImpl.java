package service.impl;

import model.Service;
import repository.ServiceRepository;
import repository.impl.ServiceFileRepository;
import service.ServiceService;

import java.util.List;

public class ServiceImpl implements ServiceService {

    private ServiceRepository serviceRepository;
    public ServiceImpl(){
        this.serviceRepository = new ServiceFileRepository();
    }

    @Override
    public void create(Service service) {
        serviceRepository.create(service);
    }

    @Override
    public Service findById(int id) {
        return serviceRepository.findById(id);
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

}
