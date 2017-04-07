package com.p7.mvc.controller;

import com.p7.mvc.model.Employee;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



public class EmployeeController {
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("index", "employee", new Employee());
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee";
    }


    //Для того чтобы атрибуты резолвились на странице
    @RequestMapping(method = RequestMethod.GET)
    public String initForm(ModelMap model){
        //model.addAttribute("employee", new Employee());
        //return form view
        return "index";
    }




    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String submit(@Validated @ModelAttribute("employee")Employee employee,
                         BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("name", employee.getName());
        model.addAttribute("contactNumber", employee.getContactNumber());
        model.addAttribute("id", employee.getId());
        return "employeeView";
    }
}
