package main.java.lk.ijse.mappingspec.controller;

import main.java.lk.ijse.mappingspec.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerPOSController {
    /*@PostMapping
    public void saveCustomer(@RequestParam("id") String id, @RequestParam("name") String name,@RequestParam("address") String address, @RequestParam("phone") String phone) {
        System.out.println("id: " + id + " name: " + name + " address: " + address + " phone: " + phone);
    }*/

    @PostMapping
    public void saveCustomer(CustomerDTO customerDTO) {
        System.out.println(customerDTO.getId() + " " + customerDTO.getName() + " " +
                        customerDTO.getAddress() + " " + customerDTO.getPhone());
    }

    @GetMapping
    public void saveCustomer2(CustomerDTO customerDTO) {
        System.out.println(customerDTO.getId() + " " + customerDTO.getName() + " " +
                        customerDTO.getAddress() + " " + customerDTO.getPhone());
    }
}
