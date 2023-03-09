package com.example.demo.Service;

import com.example.demo.Model.Hotel;
import com.example.demo.Repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository){
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> getHotels(){
        return hotelRepository.findAll();
    }

    public Hotel saveHotel(Hotel hotel){
        return hotelRepository.save(hotel);
    }

    public void deleteHotel(long id){
        hotelRepository.deleteById(id);
    }

    public List<Hotel> getHotelsByType (String type){
       return hotelRepository.getHotelsByType(type);
    }

    public Hotel getHotelById(long id){
        return hotelRepository.getHotelById(id);
    }

    public void updateNoFreeRooms(long id){
        Hotel hotel = getHotelById(id);
        int noFreeRooms = hotel.getNoFreeRooms();
        if(noFreeRooms>0){
            hotel.setNoFreeRooms(noFreeRooms-1);
        }
        hotelRepository.save(hotel);
    }



}

