package controller;

import model.Contact;
import model.Contract;
import service.TelecomService;
import service.impl.ContractServiceImpl;

import java.util.List;

public class ContractController {
    private TelecomService<Contract> contractService;

    public ContractController(){
        this.contractService = new ContractServiceImpl();
    }

    public void add(Contract contract){
        contractService.create(contract);
        System.out.printf("%s added. %n",contract);
    }
    public void update(Contract contract){
        contractService.update(contract);
    }

    public List<Contract> getAll(){
        return contractService.findAll();
    }

    public void delete(int id){
        boolean deleted = contractService.deleteById(id);
        System.out.printf("Consumer deleted. %b%n",deleted);
    }

    public Contract getById(int id) {
        return contractService.findById(id);
    }

    public void list(){
        List<Contract> contractList = contractService.findAll();
        contractList.stream().forEach(System.out::println);
    }

}
