
package com.example.demo.controller;

import com.example.demo.entity.Hotel;
import com.example.demo.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/hotel")
@CrossOrigin(origins = "http://localhost:3000") 
public class HotelController {

    @Autowired
    private HotelService hotelService;

    // Show Hotel List (UI)
    @GetMapping
    public String listHotels(Model model) {
        model.addAttribute("hotels", hotelService.getAllHotels());
        return "hotelList";
    }

    // Show Hotel Registration Form (UI)
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("hotel", new Hotel());
        return "register";
    }

    // Save Hotel (UI)
    @PostMapping("/save")
    public String saveHotel(@ModelAttribute("hotel") Hotel hotel) {
        hotelService.saveHotel(hotel);
        return "redirect:/hotel";
    }

    // Show Update Form (UI)
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Integer id, Model model) {
        model.addAttribute("hotel", hotelService.getHotelById(id));
        return "update";
    }

    @PostMapping("/update")
    public String updateHotel(@ModelAttribute("hotel") Hotel hotel) {
        hotelService.updateHotel(hotel);
        return "redirect:/hotel";
    }

    // Delete Hotel (UI)
    @GetMapping("/delete/{id}")
    public String deleteHotel(@PathVariable Integer id) {
        hotelService.deleteHotelById(id);
        return "redirect:/hotel";
    }

    // API: Get All Hotels (JSON)
    @GetMapping("/hotels")
    public ResponseEntity<List<Hotel>> getAllHotelsAPI() {
        return ResponseEntity.ok(hotelService.getAllHotels());
    }

    @GetMapping("/hotels/{id}")
    public ResponseEntity<?> getHotelByIdAPI(@PathVariable Integer id) {
        Hotel hotel = hotelService.getHotelById(id);
        return hotel != null ? ResponseEntity.ok(hotel) : ResponseEntity.status(404).body(Map.of("error", "Hotel not found"));
    }

    // API: Save Hotel
    @PostMapping("/hotels/save")
    public ResponseEntity<Map<String, String>> saveHotelAPI(@RequestBody Hotel hotel) {
        hotelService.saveHotel(hotel);
        return ResponseEntity.ok(Map.of("message", "Hotel saved successfully"));
    }

    // API: Update Hotel
    @PutMapping("/hotels/update")
    public ResponseEntity<Map<String, String>> updateHotelAPI(@RequestBody Hotel hotel) {
        hotelService.updateHotel(hotel);
        return ResponseEntity.ok(Map.of("message", "Hotel updated successfully"));
    }

    // API: Delete Hotel
    @DeleteMapping("/hotels/{id}")
    public ResponseEntity<Map<String, String>> deleteHotelAPI(@PathVariable Integer id) {
        hotelService.deleteHotelById(id);
        return ResponseEntity.ok(Map.of("message", "Hotel deleted successfully"));
    }
}