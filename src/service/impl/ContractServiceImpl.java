package service.impl;

import model.Contract;
import repository.TelecomRepository;
import repository.impl.ContractFileRepository;
import service.TelecomService;

import java.util.ArrayList;
import java.util.List;

public class ContractServiceImpl implements TelecomService<Contract> {

    TelecomRepository contractRepository;
    public ContractServiceImpl(){
        contractRepository = new  ContractFileRepository();
    }
    @Override
    public void create(Contract contract) {
        contractRepository.create(contract);
    }
    @Override
    public boolean deleteById(int id){
        contractRepository.deleteById(id);
        return true;
    }

    @Override
    public Contract findById(int id) {
        return contractRepository.findById(id);
    }

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }
    @Override
    public void update(Contract contract) {
        contractRepository.update(contract);
    }

}
