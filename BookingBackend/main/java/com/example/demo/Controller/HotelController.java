package com.example.demo.Controller;

import com.example.demo.Model.Hotel;
import com.example.demo.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( path = "api/v1/hotel")
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService){
        this.hotelService = hotelService;
    }

    @GetMapping("/getHotels")
    public List<Hotel> getHotels(){
        return hotelService.getHotels();
    }

    @GetMapping("/getHotels/{type}")
    public List<Hotel> getHotelsByType(@PathVariable String type){
        return hotelService.getHotelsByType(type);
    }

    @PostMapping("/addHotel")
    public void addHotel(@RequestBody Hotel hotel){
        hotelService.saveHotel(hotel);
    }

    @DeleteMapping("/deleteHotel/{id}")
    public void deleteHotel(@PathVariable long id){
        hotelService.deleteHotel(id);
    }
}
