package main.java.lk.ijse.mappingspec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/six")
public class SixController {
    @GetMapping(path = "/path/A/B/**")
    public String testOne() {
        return "Method One Invoked 1";
    }
}
