package com.bookingdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public void run(String... strings) throws Exception {
        bookingRepository.save(new HotelBooking("Marriot", 200.50, 3));
        bookingRepository.save(new HotelBooking("Ibis", 90, 4));
        bookingRepository.save(new HotelBooking("Novotel", 150, 1));
    }
}
