package com.bicycles.bicycles.bicycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BicycleController {

    @Autowired
    BicycleService bicycleService;

    @RequestMapping(value = "bicycles", method = RequestMethod.GET)
    public String getAllBicycles(Model model) {
        model.addAttribute("bicycles", this.bicycleService.getAllBicycles());
        return "bicycleList";
    }

    @RequestMapping(value = "bicyclesWeigh_asc", method = RequestMethod.GET)
    public String getAllBicyclesWeighASC(Model model) {
        model.addAttribute("bicycles", this.bicycleService.sortBicyclesWeightASC());
        return "bicycleList";
    }

    @RequestMapping(value = "bicyclesDistance_asc", method = RequestMethod.GET)
    public String getAllBicyclesDistanceASC(Model model) {
        model.addAttribute("bicycles", this.bicycleService.sortBicyclesDistanceASC());
        return "bicycleList";
    }

    @RequestMapping(value = "bicyclesName_asc", method = RequestMethod.GET)
    public String getAllBicyclesNameASC(Model model) {
        model.addAttribute("bicycles", this.bicycleService.sortBicyclesNameASC());
        return "bicycleList";
    }

    @RequestMapping(value = "/bicycles/{id}", method = RequestMethod.GET)
    public Bicycle getBicycle(@PathVariable int id) {
        return this.bicycleService.getBicycle(id);
    }

    @RequestMapping(value = "/bicycles", method = RequestMethod.POST)
    public String addBicycle(@ModelAttribute Bicycle bicycle, Model model) {
        this.bicycleService.addBicycle(bicycle);
        model.addAttribute("bicycles", this.bicycleService.getAllBicycles());
        return "bicycleList";
    }

    @RequestMapping(value = "/deleteBicycleRecord/{id}", method = RequestMethod.GET)
    public String deleteBicycle(@PathVariable int id, Model model) {
        boolean isDeleted = bicycleService.deleteBicycle(id);
        if (!isDeleted) {
            model.addAttribute("errorDeleteBicycle", "Kļūda dzēšot velosipēdu! Velosipēdu izdzēst iespējams, " +
                    "ja tas nav izmantots rezervācijā. Lūdzu vispirms dzēst visas rezervācijas ar šo velosipēdu!");
        }
        this.bicycleService.deleteBicycle(id);
        model.addAttribute("bicycles", this.bicycleService.getAllBicycles());
        return "bicycleList";
    }

    @RequestMapping(value = "/bicycles/{id}", method = RequestMethod.POST)
    public String updateBicycle(@PathVariable int id,
                                @RequestBody Bicycle bicycle) {
        this.bicycleService.updateBicycle(bicycle);
        return "redirect:/bicycles";
    }

}