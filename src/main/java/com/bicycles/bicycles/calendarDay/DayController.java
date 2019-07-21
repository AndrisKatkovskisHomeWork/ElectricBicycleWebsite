package com.bicycles.bicycles.calendarDay;

import com.bicycles.bicycles.accessories.AccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DayController {

    @Autowired
    DayService dayService;

    @Autowired
    AccessoryService accessoryService;

    @RequestMapping(value = "days", method = RequestMethod.GET)
    public String getAllDays(Model model) {
        model.addAttribute("days", this.dayService.getAllDays());
        model.addAttribute("accessories", this.accessoryService.getAllAccessories());
        return "dayList";
    }

    @RequestMapping(value = "/days/{id}", method = RequestMethod.GET)
    public Day getDay(@PathVariable int id) {
        return this.dayService.getDay(id);
    }

    @RequestMapping(value = "/days", method = RequestMethod.POST)
    public String addDay(@ModelAttribute Day day, Model model) {
        boolean isSaved = dayService.addDay(day);
        if (!isSaved) {
            model.addAttribute("error", "Kļūda saglabājot datumu!" +
                    " Lūdzu pārbaudīt, vai datums jau nav reģistrēts!");
        }
        model.addAttribute("days", this.dayService.getAllDays());
        return "dayList";
    }

    @RequestMapping(value = "/deleteDayRecord/{id}", method = RequestMethod.GET)
    public String deleteDay(@PathVariable int id) {
        this.dayService.deleteDay(id);
        return "redirect:/days";
    }

    @RequestMapping(value = "/days/{id}", method = RequestMethod.PUT)
    public void updateDay(@PathVariable String id,
                          @RequestBody Day day) {
        this.dayService.updateDay(day);
    }


}
