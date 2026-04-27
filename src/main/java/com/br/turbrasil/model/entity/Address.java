package com.br.turbrasil.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String street;

    private String number;

    private String complement;

    private String neighborhood;

    private String city;

    private String state;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "created_at")
    private Instant createdAt = Instant.now();

    @OneToOne(mappedBy = "address")
    private TouristPoint touristPoint;
}
