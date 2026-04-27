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
@Table(name = "photos")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String url;

    @Column(name = "display_order")
    private Integer displayOrder;

    @Column(name = "created_at")
    private Instant createdAt = Instant.now();

    @ManyToOne
    @JoinColumn(name = "tourist_point_id")
    private TouristPoint touristPoint;
}
