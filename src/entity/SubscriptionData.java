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
        @NamedQuery(name = "SubscriptionData.findById", query = "SELECT s FROM SubscriptionData s WHERE s.id = :id"),
        @NamedQuery(name = "SubscriptionData.findAll", query = "SELECT s FROM SubscriptionData s")
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @Enumerated(EnumType.STRING)
    private State state;

    @OneToMany(mappedBy = "subscription", cascade = CascadeType.ALL)
    private List<Service> services;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private Contact contact;
}
