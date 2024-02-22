package mapper;

import entity.ContractData;
import exception.ContractException;
import model.Contract;

import java.util.List;
import java.util.stream.Collectors;

public class ContractMapper {
    public Contract fromContractData(ContractData contractData){
        return new Contract(contractData.getId(),contractData.getCreatedDate(),contractData.getContractType(),contractData.getState(),contractData.getSubscriptions(),contractData.getContact());
    }

    public ContractData toContractData(Contract contract){
        return new ContractData(contract.getId(),contract.getCreatedDate(),contract.getContractType(),contract.getState(),contract.getSubscriptions(),contract.getContact());
    }

    public List<Contract> fromContractData(List<ContractData> contracts) throws ContractException {
        return contracts.stream().map(this::fromContractData).collect(Collectors.toList());
    }
}
