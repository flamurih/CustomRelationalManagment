package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.*;

import java.time.LocalDate;


@Entity
@Table(name = "Contacts")
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "ContactData.findById", query = "SELECT c FROM ContactData c WHERE c.id = :id"),
        @NamedQuery(name = "ContactData.findAll", query = "SELECT c FROM ContactData c")
})
public class ContactData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private IdType idType;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private String customerName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column
    private LocalDate dob;

    @Column
    private LocalDate createdDate;

    @Enumerated(EnumType.STRING)
    private State state;

}