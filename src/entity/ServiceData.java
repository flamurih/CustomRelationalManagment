package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.ServiceTypes;
import model.State;

import java.util.List;


@Entity
@Table(name = "Services")
@NamedQueries({
        @NamedQuery(name = "ServiceData.findById", query = "SELECT c FROM ServiceData c WHERE c.id = :id"),
        @NamedQuery(name = "ServiceData.findAll", query = "SELECT c FROM ServiceData c")
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceData {
    @Id
    private int id;
    @Column
    private String name;
    @Enumerated(EnumType.STRING)
    private State state;
    @Enumerated(EnumType.STRING)
    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private List<ServiceTypes> serviceTypes;

}