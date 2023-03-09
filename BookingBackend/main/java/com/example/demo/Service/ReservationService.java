package com.example.demo.Service;

import com.example.demo.Model.Hotel;
import com.example.demo.Model.Reservation;
import com.example.demo.Model.User;
import com.example.demo.Repository.HotelRepository;
import com.example.demo.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService{

    private final ReservationRepository reservationRepository;
    private final HotelService hotelService;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, HotelService hotelService){
        this.reservationRepository = reservationRepository;
        this.hotelService = hotelService;
    }

    public List<Reservation> getReservations(long userID){

        return reservationRepository.findByUserID(userID);
    }

    public Reservation saveReservation(Reservation reservation){
        long hotelID = reservation.getHotelID();
        Hotel hotel = hotelService.getHotelById(hotelID);
        System.out.println(hotel.getPricePerNight());
        reservation.setTotalPrice(reservation.getNoNight()*hotel.getPricePerNight());
        hotelService.updateNoFreeRooms(hotelID);
        return reservationRepository.save(reservation);
    }

    public void delete(long userID){
        reservationRepository.deleteByUserID(userID);
    }


}
