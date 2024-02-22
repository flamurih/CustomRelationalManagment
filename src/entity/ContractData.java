package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.ContractType;
import model.State;
import model.Contact;
import model.Subscription;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "Contracts")
@NamedQueries({
        @NamedQuery(name = "ContractData.findById", query = "SELECT c FROM ContractData c WHERE c.id = :id"),
        @NamedQuery(name = "ContractData.findAll", query = "SELECT c FROM ContractData c")
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractData {
    @Id
    private int id;

    @Column
    private LocalDate createdDate;

    @Enumerated(EnumType.STRING)
    private ContractType contractType;

    @Enumerated(EnumType.STRING)
    private State state;

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    private List<Subscription> subscriptions;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private Contact contact;

}