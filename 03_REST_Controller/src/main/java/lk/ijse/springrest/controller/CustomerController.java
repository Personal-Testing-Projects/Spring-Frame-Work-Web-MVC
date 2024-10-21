package main.java.lk.ijse.springrest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @GetMapping
    public String testOne(){
        return "Hello World";
    }

    //Ambiguous error occurs
    /*@GetMapping
    public String testTwo(){
        return "Hello World";
    }*/
}
