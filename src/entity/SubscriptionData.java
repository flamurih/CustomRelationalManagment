package entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Service;
import model.State;
import model.Contact;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "Subscriptions")
@NamedQueries({
        @NamedQuery(name = "SubscriptionData.findById", query = "SELECT c FROM SubscriptionData c WHERE c.id = :id"),
        @NamedQuery(name = "SubscriptionData.findAll", query = "SELECT c FROM SubscriptionData c")
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionData {
    @Id
    private int id;

    @Column
    private String phoneNumber;

    @Column
    private LocalDate createdDate;

    @Enumerated(EnumType.STRING)
    private State state;


    @OneToMany(mappedBy = "subscription", cascade = CascadeType.ALL)
    private List<Service> services;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private Contact contact;

}