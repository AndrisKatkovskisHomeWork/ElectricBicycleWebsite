package com.bicycles.bicycles.booking;

import com.bicycles.bicycles.bicycle.Bicycle;
import com.bicycles.bicycles.bicycle.BicycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        bookingRepository.findAll().forEach(bookings::add);
        return bookings;
    }

//    public Booking getBooking(int id) {
//        return bookingRepository.findById(id).get();
//    }
//
    public void addBooking(Booking booking) {
        bookingRepository.save(booking);
    }

    public void deleteBooking(int id) {
        bookingRepository.deleteById(id);
    }

//    public void updateBooking(Booking booking) {
//        bookingRepository.save(booking);
//    }

}