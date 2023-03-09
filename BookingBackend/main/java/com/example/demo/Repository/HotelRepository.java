package com.example.demo.Repository;

import com.example.demo.Model.Hotel;
import com.example.demo.Model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Long> {

    public List<Hotel> getHotelsByType(String type);

    public Hotel getHotelById(long id);
}
