package com.p7.mvc.controller;

import com.p7.mvc.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sadmin on 07.04.17.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @RequestMapping(method = RequestMethod.GET)
    public String initForm(ModelMap model){
        model.addAttribute("customerJSP", new Customer());
        //return form view
        return "CustomerForm";
    }




}