package mapper;

import entity.ServiceData;
import exception.ServiceException;
import model.Service;

import java.util.List;
import java.util.stream.Collectors;

public class ServiceMapper {
    public Service fromServiceData(ServiceData serviceData){
        return new Service(serviceData.getId(),serviceData.getCreatedDate(),serviceData.getState(),serviceData.getServiceTypes());
    }

    public ServiceData toServiceData(Service service){
        return new ServiceData(service.getId(),service.getCreatedDate(),service.getState(),service.getServiceTypes());
    }

    public List<Service> fromServiceData(List<ServiceData> services) throws ServiceException {
        return services.stream().map(this::fromServiceData).collect(Collectors.toList());
    }
}
