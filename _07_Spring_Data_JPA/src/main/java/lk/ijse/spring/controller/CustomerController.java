package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.saveCustomer(customerDTO);
        return new ResponseUtil("OK", "Successfully Added", null);
    }

    @DeleteMapping(params = "id")
    public ResponseUtil deleteCustomer(@RequestParam("id") String id) {
        customerService.deleteCustomer(id);
        return new ResponseUtil("OK", "Successfully Deleted : " + id, null);
    }

    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.updateCustomer(customerDTO);
        return new ResponseUtil("OK", "Successfully Updated : " + customerDTO.getId(), null);
    }

    @GetMapping
    public ResponseUtil getAllCustomers() {
       customerService.getAllCustomers();
       return new ResponseUtil("OK", "All Customers", customerService.getAllCustomers());
    }
}
