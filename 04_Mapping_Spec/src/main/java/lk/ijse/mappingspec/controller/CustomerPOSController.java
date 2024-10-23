package main.java.lk.ijse.mappingspec.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerPOSController {
    @PostMapping
    public void saveCustomer() {
        System.out.println("Goda goda goda");
    }
}
