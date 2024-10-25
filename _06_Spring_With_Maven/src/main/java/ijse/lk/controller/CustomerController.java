package ijse.lk.controller;

import ijse.lk.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
    @PostMapping
    public void getCustomer(@RequestBody CustomerDTO customerDTO) {
        System.out.println(customerDTO.toString());
    }
}
