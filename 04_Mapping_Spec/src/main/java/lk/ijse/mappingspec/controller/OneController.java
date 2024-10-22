package main.java.lk.ijse.mappingspec.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/one")
public class OneController {
    @GetMapping
    public String testOne() {
        return "Get method invoked";
    }

    @PostMapping
    public String testTwo() {
        return "Post method invoked";
    }

    @PutMapping
    public String testThree() {
        return "Put method invoked";
    }

    @DeleteMapping
    public String testFour() {
        return "Delete method invoked";
    }
}
