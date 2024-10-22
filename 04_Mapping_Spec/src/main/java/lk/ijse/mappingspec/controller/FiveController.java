package main.java.lk.ijse.mappingspec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/five")
public class FiveController {
    @GetMapping(path = "/path/*/A/B")
    public String testOne() {
        return "Method Invoked 1";
    }

    @GetMapping(path = "/*/myPath/A/C")
    public String testTwo() {
        return "Method Invoked 2";
    }
}
