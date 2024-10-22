package main.java.lk.ijse.mappingspec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/four")
public class FourController {
    @GetMapping(path = "/C?DEF")
    public String testOne() {
        return "Method Invoked 1";
    }

    @GetMapping(path = "/C??DEF")
    public String testTwo() {
        return "Method Invoked 2";
    }
}
