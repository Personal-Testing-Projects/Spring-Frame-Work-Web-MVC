package main.java.lk.ijse.mappingspec.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nine")
public class NineController {
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public String testOne() {
        return "Get method invoked 1";
    }
    @GetMapping(produces = {MediaType.TEXT_HTML_VALUE})
    public String testTwo() {
        return "Get method invoked 2";
    }

    @GetMapping(headers = {"Content-Type=application/json", "Accept=text/html"})
    public String testThree() {
        return "Get method invoked 3";
    }
}
