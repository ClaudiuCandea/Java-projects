package com.example.demo.Repository;

import com.example.demo.Model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    public List<Reservation> findByUserID(Long userID);

    public void deleteByUserID(long userID);

}
