package main.java.lk.ijse.mappingspec.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eight")
public class EightController {
    @GetMapping(consumes = {"application/json"})
    //@GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String testOne() {
        return "Method One Invoked 1";
    }

    @GetMapping(consumes = {"text/html"})
    //@GetMapping(MediaType.TEXT_HTML_VALUE)
    public String testTwo() {
        return "Method Two Invoked 2";
    }
}
