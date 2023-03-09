package com.example.demo.Controller;

import com.example.demo.Model.Hotel;
import com.example.demo.Model.Reservation;
import com.example.demo.Model.User;
import com.example.demo.Service.HotelService;
import com.example.demo.Service.ReservationService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( path = "api/v1/Reservation")
public class ReservationController {

    private final ReservationService reservationService;
    private final UserService userService;
    private final HotelService hotelService;

    @Autowired
    public ReservationController(ReservationService reservationService, UserService userService, HotelService hotelService){
        this.reservationService = reservationService;
        this.userService = userService;
        this.hotelService = hotelService;
    }

    @GetMapping("/getReservations/{userID}")
    public List<Reservation> getReservations(@PathVariable Long userID){
        return reservationService.getReservations(userID);

    }

    @PostMapping("/addReservation")
    public void addReservation(@RequestBody Reservation reservation){
            reservationService.saveReservation(reservation);
    }

    @DeleteMapping("/deleteReservations/{email}")
    public void deleteReservations(@PathVariable String email){
        User user = userService.getUserByEmail(email);
        reservationService.delete(user.getId());
    }

}
