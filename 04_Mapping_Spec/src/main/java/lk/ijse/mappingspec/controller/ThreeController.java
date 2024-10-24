package main.java.lk.ijse.mappingspec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/three")
public class ThreeController {
   /* @GetMapping(path = "/id/{cusId}/{cusName}")
    public String testOne(@PathVariable("cusId") String id, @PathVariable("cusName") String name) {
        System.out.println(id+" "+name);
        return "Get method invoked 1";
    }
*/
    @GetMapping(path = "/id/{cusId:[C]{1}[0-9]{3}}/{cusName:[A-Z]{4}}")
    public String testTwo(@PathVariable("cusId") String id, @PathVariable("cusName") String name) {
        System.out.println(id+" "+name);
        return "Get method invoked 2";
    }

    @GetMapping(path = "/id/{cusId:[C]{1}[0-9]{3}}/{cusName:[A-Z]{5}}")
    public String testThree(@PathVariable("cusId") String id, @PathVariable("cusName") String name) {
        System.out.println(id+" "+name);
        return "Get method invoked 3";
    }
}
