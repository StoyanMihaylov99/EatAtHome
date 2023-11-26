package com.example.eatathome.web;
import com.example.eatathome.utils.City;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping("")
    public ModelAndView indexPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("CityOptions", City.class);
        modelAndView.setViewName("index.html");
        return modelAndView;
    }




}
