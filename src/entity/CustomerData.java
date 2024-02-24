package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.CustomerType;
import model.State;
import model.Contract;
import model.Contact;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "Customers")
@NamedQueries({
        @NamedQuery(name = "CustomerData.findById", query = "SELECT c FROM CustomerData c WHERE c.id = :id"),
        @NamedQuery(name = "CustomerData.findAll", query = "SELECT c FROM CustomerData c")
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private LocalDate createdDate;

    @Enumerated(EnumType.STRING)
    private CustomerType customerType;

    @Enumerated(EnumType.STRING)
    private State state;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Contract> contracts;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private Contact contact;

}