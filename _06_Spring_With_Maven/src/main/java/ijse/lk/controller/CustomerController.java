package ijse.lk.controller;

import ijse.lk.dto.CustomerDTO;
import ijse.lk.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
    @PostMapping
    public ResponseUtil saveCustomer(@RequestBody CustomerDTO customerDTO) {
        System.out.println(customerDTO.toString());
        return new ResponseUtil("OK", "Successfully Added", null);
    }

    @DeleteMapping(params = "id")
    public ResponseUtil deleteCustomer(@RequestParam("id") String id) {
        return new ResponseUtil("OK", "Successfully Deleted : " + id, null);
    }

    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO customerDTO) {
        System.out.println(customerDTO.toString());
        return new ResponseUtil("OK", "Successfully Updated : " + customerDTO.getId(), null);
    }

    @GetMapping
    public ResponseUtil getAllCustomers() {
        ArrayList<CustomerDTO> customerDTOS = new ArrayList<>();
        customerDTOS.add(new CustomerDTO("C001", "Sam", "Dhaka", "01711111111"));
        customerDTOS.add(new CustomerDTO("C002", "Sam", "Dhaka", "01711111111"));
        customerDTOS.add(new CustomerDTO("C003", "Sam", "Dhaka", "01711111111"));
        return new ResponseUtil("OK", "All Customers", customerDTOS);
    }
}
