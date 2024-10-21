package main.java.lk.ijse.springcontroller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/item")
public class ItemController {
    @GetMapping
    public ModelAndView test() {
        return new ModelAndView("/item");
    }
}
