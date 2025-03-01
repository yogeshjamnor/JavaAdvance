package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Hotel;
import com.example.demo.repository.HotelRepo;

@Service
public class HotelService {
    
    @Autowired
    private HotelRepo hotelRepo;

    // Get all hotels for UI display
    public List<Hotel> getAllHotels() {
        return hotelRepo.findAll();
    }

    // Save Hotel with UI-friendly response
    public String saveHotel(Hotel hotel) {
        if (hotelRepo.existsById(hotel.getId())) {
            return "Hotel ID already exists!";
        }
        hotelRepo.save(hotel);
        return "Hotel successfully added!";
    }

    // Update Hotel details
    public String updateHotel(Hotel hotel) {
        if (!hotelRepo.existsById(hotel.getId())) {
            return "Hotel not found!";
        }
        hotelRepo.save(hotel);
        return "Hotel details updated successfully!";
    }

    // Fetch Hotel by ID
    public Hotel getHotelById(Integer id) {
        Optional<Hotel> hotel = hotelRepo.findById(id);
        return hotel.orElse(null);
    }

    // Delete Hotel and return a UI-friendly message
    public String deleteHotelById(Integer id) {
        if (hotelRepo.existsById(id)) {
            hotelRepo.deleteById(id);
            return "Hotel deleted successfully!";
        }
        return "Hotel ID not found!";
    }
}
