package com.example.SCHapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.SCHapi.model.entity.Hotel;

public interface HotelRepository extends JpaRepository<com.example.SCHapi.model.entity.Hotel, Long> {
}
