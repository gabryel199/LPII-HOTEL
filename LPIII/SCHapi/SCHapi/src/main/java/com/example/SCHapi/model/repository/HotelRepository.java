package com.example.SCHapi.model.repository;
import com.example.SCHapi.model.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
