package com.bookingdemo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class HotelBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String hotelName;
    private double pricePerNight;
    private int nbOfNights;

    public double totalPrice(){
        return pricePerNight* nbOfNights;
    }


    public HotelBooking(String hotelName, double pricePerNight, int nbOfNights) {
        this.hotelName = hotelName;
        this.pricePerNight = pricePerNight;
        this.nbOfNights = nbOfNights;
    }
}
