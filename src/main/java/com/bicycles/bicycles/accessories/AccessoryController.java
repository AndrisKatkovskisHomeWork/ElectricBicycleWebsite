package com.bicycles.bicycles.accessories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AccessoryController {

    @Autowired
    AccessoryService accessoryService;
    @RequestMapping(value ={ "/", "accessories"}, method = RequestMethod.GET)
    public String getAllAccessories(Model model) {
        model.addAttribute("accessories", this.accessoryService.getAllAccessories());
        return "accessoryList";
    }

    @RequestMapping(value = "accessories_asc", method = RequestMethod.GET)
    public String getAllAccessoriesAsc(Model model) {
        model.addAttribute("accessories", this.accessoryService.sortAccessoriesASC());
        return "accessoryList";
    }

    @RequestMapping(value = "accessories_desc", method = RequestMethod.GET)
    public String getAllAccessoriesDesc(Model model) {
        model.addAttribute("accessories", this.accessoryService.sortAccessoriesDESC());
        return "accessoryList";
    }

    @RequestMapping(value = "/accessories/{id}", method = RequestMethod.GET)
    public Accessory getAccessory(@PathVariable int id) {
        return this.accessoryService.getAccessory(id);
    }

    @RequestMapping(value = "/accessories", method = RequestMethod.POST)
    public String addAccessory(@ModelAttribute Accessory accessory, Model model) {
        this.accessoryService.addAccessory(accessory);
        model.addAttribute("accessories", this.accessoryService.getAllAccessories());
        return "accessoryList";
    }

    @RequestMapping(value = "/deleteRecord/{id}", method = RequestMethod.GET)
    public String deleteAccessory(@PathVariable int id) {
        this.accessoryService.deleteAccessory(id);
        return "redirect:/accessories";
    }


    @RequestMapping(value = "/accessories/{id}", method = RequestMethod.PUT)
    public void updateAccessory(@PathVariable int id,
                                @RequestBody Accessory accessory) {
        this.accessoryService.updateAccessory(accessory);
    }


}
