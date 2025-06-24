package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.*;
// import java.time.LocalDate;
// import java.time.Period;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(
        name = "Customer",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "customer_email_unique", columnNames = "email"
                )
        }
)


public class Customer {
    @Id
    @SequenceGenerator(
        name = "customer_sequence",
        sequenceName = "customer_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "customer_sequence"
    )
    @Column(
        name = "id",
        updatable = false
    )
    private Long id;

    @Column(
        name = "name",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String name;


    @Column(
        name = "email",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String email;

    @Column(
        name = "password",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String password;


}
