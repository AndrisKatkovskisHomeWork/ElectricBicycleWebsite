package com.bicycles.bicycles.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

// The @Controller is a common annotation which is used to mark a class as Spring MVC Controller while the
// @RestController is a special controller used in RESTFul web services and the equivalent of @Controller + @ResponseBody.
@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "employees", method = RequestMethod.GET)
    public String getAllEmployees(Model model) {
        model.addAttribute("employees", this.employeeService.getAllEmployees());
        return "employeeList";
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
    public Employee getEmployee(@PathVariable String id) {
        return this.employeeService.getEmployee(id);
    }

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute Employee employee, Model model) {
        this.employeeService.addEmployee(employee);
        model.addAttribute("employees", this.employeeService.getAllEmployees());
        return "employeeList";
    }

    @RequestMapping(value = "/deleteEmployeeRecord")
    public String deleteEmployee(HttpServletRequest request) {
        String id = request.getParameter("id");
        this.employeeService.deleteEmployee(id);
        return "deleteRecord";
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
    public void updateEmployee(@PathVariable String id,
                               @RequestBody Employee employee) {
        this.employeeService.updateEmployee(employee);
    }

}
