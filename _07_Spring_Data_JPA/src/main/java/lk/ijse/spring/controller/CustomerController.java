package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerRepo customerRepo;
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveCustomer(@RequestBody CustomerDTO customerDTO) {
        //System.out.println(customerDTO.toString());
        if (customerDTO.getId().equals("C001")) {
            throw new RuntimeException("Customer Already Exists");
        }
        customerRepo.save(new Customer(customerDTO.getId(), customerDTO.getName(), customerDTO.getAddress(), customerDTO.getPhone()));
        return new ResponseUtil("OK", "Successfully Added", null);
    }

    @DeleteMapping(params = "id")
    public ResponseUtil deleteCustomer(@RequestParam("id") String id) {
        if (id.equals("C001")) {
            throw new RuntimeException("Customer Already Deleted");
        }
        return new ResponseUtil("OK", "Successfully Deleted : " + id, null);
    }

    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO customerDTO) {
        //System.out.println(customerDTO.toString());
        if (customerDTO.getId().equals("C001")) {
            throw new RuntimeException("Wrong ID");
        }
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
