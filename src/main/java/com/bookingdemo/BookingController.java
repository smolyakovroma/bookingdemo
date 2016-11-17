package com.bookingdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

//    private List<HotelBooking> bookingList;

    @Autowired
    BookingRepository bookingRepository;

    public BookingController() {
//        bookingList = new ArrayList<>();


    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<HotelBooking> getAll(){
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "/affordable/{price}",method = RequestMethod.GET)
//    @GetMapping(value = "/affordable/{price}")
    public List<HotelBooking> getAffordable(@PathVariable double price){
        return bookingRepository.findByPricePerNightLessThanEqual(price);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<HotelBooking> create(@RequestBody HotelBooking hotelBooking){
        bookingRepository.save(hotelBooking);
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public List<HotelBooking> delete(@PathVariable long id){
        bookingRepository.delete(id);
        return bookingRepository.findAll();
    }
}
