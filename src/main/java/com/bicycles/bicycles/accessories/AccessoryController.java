package com.bicycles.bicycles.accessories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AccessoryController {

    @Autowired
    AccessoryService accessoryService;

    @RequestMapping(value = {"accessories"}, method = RequestMethod.GET)
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

    @RequestMapping(value = "/accessories/{id}", method = RequestMethod.POST)
    public String getAccessory(@ModelAttribute Accessory accessory, @PathVariable int id) {

        this.accessoryService.updateAccessory(accessory);
        return "redirect:/accessories";
    }

    @RequestMapping(value = "/accessories", method = RequestMethod.POST)
    public String addAccessory(@ModelAttribute Accessory accessory, Model model) {
        this.accessoryService.addAccessory(accessory);
        model.addAttribute("accessories", this.accessoryService.getAllAccessories());
        return "accessoryList";
    }

    @RequestMapping(value = "/deleteAccessoryRecord/{id}", method = RequestMethod.GET)
    public String deleteAccessory(@PathVariable int id, Model model) {
        boolean isDeleted = accessoryService.deleteAccessory(id);
        if(!isDeleted) {
            model.addAttribute("errorDeleteAccessory", "Kļūda dzēšot aprīkojumu! Aprīkojumu izdzēst iespējams, " +
                    "ja tas nav izmantots rezervācijā. Lūdzu vispirms dzēst visas rezervācijas ar šo aprīkojumu!");
        }
            this.accessoryService.deleteAccessory(id);
        model.addAttribute("accessories", this.accessoryService.getAllAccessories());
        return "accessoryList";
    }

    @RequestMapping(value = "/accessories/{id}", method = RequestMethod.PUT)
    public void updateAccessory(@PathVariable int id,
                                @RequestBody Accessory accessory) {
        this.accessoryService.updateAccessory(accessory);
    }

}
