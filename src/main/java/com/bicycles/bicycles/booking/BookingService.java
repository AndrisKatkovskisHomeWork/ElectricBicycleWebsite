package com.bicycles.bicycles.booking;


import com.bicycles.bicycles.loginPart.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    UserRepository userRepository;

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
    public boolean addBooking(Booking booking) {
        List<Booking> byDayAndBicycle = bookingRepository.findByDayAndBicycle(booking.getDay(), booking.getBicycle());
        try {
            if (byDayAndBicycle.size() > 0) {
                return false;
            } else {
                booking.setEmail(SecurityContextHolder.getContext().getAuthentication().getName());
                bookingRepository.save(booking);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void deleteBooking(int id) {
        bookingRepository.deleteById(id);
    }

//    public void updateBooking(Booking booking) {
//        bookingRepository.save(booking);
//    }

    public List<Booking> sortBookingsByDataASC() {
        List<Booking> bookings = new ArrayList<>();
        bookingRepository.findAll(Sort.by("day")).forEach(bookings::add);
        return bookings;
    }

    public List<Booking> sortBookingsByDataDESC() {
        List<Booking> bookings = new ArrayList<>();
        bookingRepository.findAll(Sort.by("day").descending()).forEach(bookings::add);
        return bookings;
    }

    public List<Booking> sortBookingsByUsersASC() {
        List<Booking> bookings = new ArrayList<>();
        bookingRepository.findAll(Sort.by("email")).forEach(bookings::add);
        return bookings;
    }

    public List<Booking> sortBookingsByUsersDESC() {
        List<Booking> bookings = new ArrayList<>();
        bookingRepository.findAll(Sort.by("email").descending()).forEach(bookings::add);
        return bookings;
    }

    public List<Booking> sortBookingsByBicycleASC() {
        List<Booking> bookings = new ArrayList<>();
        bookingRepository.findAll(Sort.by("bicycle")).forEach(bookings::add);
        return bookings;
    }

    public List<Booking> sortBookingsByBicycleDESC() {
        List<Booking> bookings = new ArrayList<>();
        bookingRepository.findAll(Sort.by("bicycle").descending()).forEach(bookings::add);
        return bookings;
    }

}
