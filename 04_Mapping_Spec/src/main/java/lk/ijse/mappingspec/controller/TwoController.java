package main.java.lk.ijse.mappingspec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/two")
public class TwoController {
    @GetMapping
    public String testOneDefaultMethod() {
        return "Get method invoked 1";
    }

    @GetMapping(path = "/a")
    public String testOne2() {
        return "Get method invoked 2";
    }

    @GetMapping(path = "/b")
    public String testOne3() {
        return "Get method invoked 3";
    }

    @GetMapping(path = "/c")
    public String testOne4() {
        return "Get method invoked 4";
    }

    @GetMapping(path = "/a/b")
    public String testOne5() {
        return "Get method invoked 5";
    }

    @GetMapping(path = "/a/b/")
    public String testOne6() {
        return "Get method invoked 6";
    }

    @GetMapping(path = "/a/b/c")
    public String testOne7() {
        return "Get method invoked 7";
    }
}
