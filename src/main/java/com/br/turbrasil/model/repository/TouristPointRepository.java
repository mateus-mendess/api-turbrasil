package com.br.turbrasil.model.repository;

import com.br.turbrasil.model.entity.TouristPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TouristPointRepository extends JpaRepository<TouristPoint, UUID> {
}
