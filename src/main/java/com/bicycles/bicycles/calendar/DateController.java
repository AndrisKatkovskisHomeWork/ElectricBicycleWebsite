//package com.bicycles.bicycles.calendar;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//
//@Controller
//public class DateController {
//
//    @Autowired
//    DateService dateService;
//
//    @RequestMapping(value = "createdData", method = RequestMethod.GET)
//    public String getAllDates(Model model){
//        model.addAttribute("createdData", this.dateService.getAllDates());
//        return "startBooking";
//    }
//
//    @RequestMapping(value = "/createdData", method = RequestMethod.POST)
//    public String addDate(@ModelAttribute DateCreating dateCreating, Model model){
//        this.dateService.addDate(dateCreating);
//        model.addAttribute("createdData", this.dateService.getAllDates());
//        return "startBooking";
//    }
//
//}