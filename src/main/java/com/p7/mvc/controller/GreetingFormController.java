package com.p7.mvc.controller;

import com.p7.mvc.model.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GreetingFormController {

    @RequestMapping(value="/greetingForm", method= RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("greetingJSP", new Greeting());
        return "greetingForm";
    }

    @RequestMapping(value="/greetingForm", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
        model.addAttribute("greetingJSP", greeting);
        return "greetingFormResult";
    }

}
