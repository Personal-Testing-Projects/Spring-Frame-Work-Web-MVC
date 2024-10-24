package ijse.lk.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
    @GetMapping
    public String getCustomer() {
        return "Customer";
    }
}
