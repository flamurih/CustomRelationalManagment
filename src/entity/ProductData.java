package entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.IdType;
import model.Service;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Products")
@NamedQueries({
        @NamedQuery(name = "ProductData.findById", query = "SELECT c FROM ProductData c WHERE c.id = :id"),
        @NamedQuery(name = "ProductData.findAll", query = "SELECT c FROM ProductData c")
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductData {
    @Id
    private int id;

    @Enumerated(EnumType.STRING)
    private IdType idType;

    @Column
    private String name;

    @Column
    private Double price;

    @Column
    private LocalDate fromDateTime;

    @Column
    private LocalDate toDateTime;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Service> services;

}