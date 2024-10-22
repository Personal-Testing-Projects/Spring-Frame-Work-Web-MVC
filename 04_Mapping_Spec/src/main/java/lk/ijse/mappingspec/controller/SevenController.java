package main.java.lk.ijse.mappingspec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seven")
public class SevenController {
    @GetMapping(params = {"id", "name"})
    public String testOne() {
        return "Method Invoked 1";
    }

    @GetMapping(params = {"address", "salary"})
    public String testTwo(@RequestParam("address") String address, @RequestParam("salary") String salary) {
        return "Method Invoked 2 : " + address + " " + salary;
    }
}
