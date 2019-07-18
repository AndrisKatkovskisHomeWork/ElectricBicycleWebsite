package com.bicycles.bicycles.booking;

import com.bicycles.bicycles.accessories.AccessoryService;
import com.bicycles.bicycles.bicycle.BicycleService;
import com.bicycles.bicycles.calendarDay.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookingController {

    @Autowired
    BookingService bookingService;
    @Autowired
    DayService dayService;
    @Autowired
    AccessoryService accessoryService;
    @Autowired
    BicycleService bicycleService;
//    @Autowired
//    EmployeeService employeeService;

    @RequestMapping(value = "/bookingList", method = RequestMethod.GET)
    public String getAllBookings(Model model) {
        model.addAttribute("days", this.dayService.getAllDays());
        model.addAttribute("accessories", this.accessoryService.getAllAccessories());
        model.addAttribute("bicycles", this.bicycleService.getAllBicycles());
        model.addAttribute("booking", new Booking());
        model.addAttribute("bookingsList", bookingService.getAllBookings());
        return "bookingList";
    }


//        @RequestMapping(value = "/bookingList/{id}", method = RequestMethod.GET)
//    public Booking getBooking(@PathVariable int id){
//        return this.bookingService.getBooking(id);
//    }

    @RequestMapping(value = "/bookingList", method = RequestMethod.POST)
    public String addBooking (@ModelAttribute Booking booking, BindingResult bindingResult, Model model){
        this.bookingService.addBooking(booking);
        return "redirect:/bookingList";
    }

    @RequestMapping(value = "/deleteBookingRecord/{id}", method = RequestMethod.GET)
    public String deleteBooking(@PathVariable int id){
        this.bookingService.deleteBooking(id);
        return "redirect:/bookingList";
    }



//    @RequestMapping(value = "/bookingList/{id}", method = RequestMethod.PUT)
//
//    public void updateBooking(@PathVariable int id,
//                                @RequestBody Booking booking) {
//        this.bookingService.updateBooking(booking);
//    }

}