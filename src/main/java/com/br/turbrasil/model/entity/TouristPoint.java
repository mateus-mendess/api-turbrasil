package com.br.turbrasil.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalTime;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tourist_points")
public class TouristPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String description;

    @Column(name = "open_time")
    private LocalTime openTime;

    @Column(name = "close_time")
    private LocalTime closeTime;

    @Column(name = "accessibility_info")
    private String accessibilityInfo;

    @Column(name = "has_accessibility")
    private Boolean hasAccessibility;

    private Double latitude;

    private Double longitude;

    private Boolean active = true;

    @Column(name = "created_at")
    private Instant createdAt = Instant.now();

    @Column(name = "updated_at")
    private Instant updatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(mappedBy = "touristPoints")
    private Set<Category> categories = new HashSet<>();

    @OneToMany(mappedBy = "touristPoint")
    private Set<Photo> photos = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "touristPoint")
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private List<User> users = new ArrayList<>();
}
