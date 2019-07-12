package com.bicycles.bicycles.bicycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BicycleController {

    @Autowired
    BicycleService bicycleService;

    @RequestMapping(value = "bicycles", method = RequestMethod.GET)
    public String getAllBicycles(Model model) {
        model.addAttribute("bicycles", this.bicycleService.getAllBicycles());
        return "bicycleList";
    }

    @RequestMapping(value = "/bicycles/{id}", method = RequestMethod.GET)
    public Bicycle getBicycle(@PathVariable String id) {
        return this.bicycleService.getBicycle(id);
    }

    @RequestMapping(value = "/bicycles", method = RequestMethod.POST)
    public String addBicycle(@ModelAttribute Bicycle bicycle, Model model) {
        this.bicycleService.addBicycle(bicycle);
        model.addAttribute("bicycles", this.bicycleService.getAllBicycles());
        return "bicycleList";
    }

    @RequestMapping(value = "/deleteBicycleRecord")
    public String deleteBicycle(HttpServletRequest request) {
        String id = request.getParameter("id");
        this.bicycleService.deleteBicycle(id);
        return "deleteRecord";
    }

    @RequestMapping(value = "/bicycles/{id}", method = RequestMethod.PUT)
    public void updateBicycle(@PathVariable String id,
                              @RequestBody Bicycle bicycle) {
        this.bicycleService.updateBicycle(bicycle);
    }


}