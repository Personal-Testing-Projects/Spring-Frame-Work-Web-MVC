package main.java.lk.ijse.mappingspec.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerPOSController {
    @PostMapping
    public void saveCustomer(@RequestParam("id") String id, @RequestParam("name") String name,@RequestParam("address") String address, @RequestParam("phone") String phone) {
        System.out.println("id: " + id + " name: " + name + " address: " + address + " phone: " + phone);
    }
}
