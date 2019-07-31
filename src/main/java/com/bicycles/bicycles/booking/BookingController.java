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

    @RequestMapping(value = "/bookingList", method = RequestMethod.GET)
    public String getAllBookings(Model model) {
        dayAccesoryBicycleServiceAndBooking(model);
        model.addAttribute("bookingsList", bookingService.getAllBookings());
        return "bookingList";
    }

    private void dayAccesoryBicycleServiceAndBooking(Model model) {
        model.addAttribute("days", this.dayService.getAllDays());
        model.addAttribute("accessories", this.accessoryService.getAllAccessories());
        model.addAttribute("bicycles", this.bicycleService.getAllBicycles());
        model.addAttribute("booking", new Booking());
    }

    @RequestMapping(value = "/sortBookingsByData_asc", method = RequestMethod.GET)
    public String getAllAccessoriesAsc(Model model) {
        dayAccesoryBicycleServiceAndBooking(model);
        model.addAttribute("bookingsList", this.bookingService.sortBookingsByDataASC());
        return "bookingList";
    }

    @RequestMapping(value = "sortBookingsByData_desc", method = RequestMethod.GET)
    public String getAllAccessoriesDesc(Model model) {
        dayAccesoryBicycleServiceAndBooking(model);
        model.addAttribute("bookingsList", this.bookingService.sortBookingsByDataDESC());
        return "bookingList";
    }

    @RequestMapping(value = "/sortBookingsByUsers_asc", method = RequestMethod.GET)
    public String getAllUsersAsc(Model model) {
        dayAccesoryBicycleServiceAndBooking(model);
        model.addAttribute("bookingsList", this.bookingService.sortBookingsByUsersASC());
        return "bookingList";
    }

    @RequestMapping(value = "sortBookingsByUsers_desc", method = RequestMethod.GET)
    public String getAllUsersDesc(Model model) {
        dayAccesoryBicycleServiceAndBooking(model);
        model.addAttribute("bookingsList", this.bookingService.sortBookingsByUsersDESC());
        return "bookingList";
    }

    @RequestMapping(value = "/sortBookingsByBicycle_asc", method = RequestMethod.GET)
    public String getAllBicycleAsc(Model model) {
        dayAccesoryBicycleServiceAndBooking(model);
        model.addAttribute("bookingsList", this.bookingService.sortBookingsByBicycleASC());
        return "bookingList";
    }

    @RequestMapping(value = "sortBookingsByBicycle_desc", method = RequestMethod.GET)
    public String getAllBicycleDesc(Model model) {
        dayAccesoryBicycleServiceAndBooking(model);
        model.addAttribute("bookingsList", this.bookingService.sortBookingsByBicycleDESC());
        return "bookingList";
    }

    @RequestMapping(value = "/bookingList", method = RequestMethod.POST)
    public String addBooking(@ModelAttribute Booking booking, BindingResult bindingResult, Model model) {
        boolean isSaved = bookingService.addBooking(booking);
        if (!isSaved) {
            model.addAttribute("error", "Kļūda saglabājot rezervāciju!" +
                    " Lūdzu pārbaudīt, vai norādītajā datumā velosipēds jau nav aizņemts!");
        }
        dayAccesoryBicycleServiceAndBooking(model);
        model.addAttribute("bookingsList", bookingService.getAllBookings());
        return "bookingList";
    }

    @RequestMapping(value = "/deleteBookingRecord/{id}", method = RequestMethod.GET)
    public String deleteBooking(@PathVariable int id) {
        this.bookingService.deleteBooking(id);
        return "redirect:/bookingList";
    }
}