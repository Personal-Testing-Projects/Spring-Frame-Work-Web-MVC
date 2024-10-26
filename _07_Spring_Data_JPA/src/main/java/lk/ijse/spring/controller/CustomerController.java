package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ModelMapper modelMapper;
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveCustomer(@RequestBody CustomerDTO customerDTO) {
        //System.out.println(customerDTO.toString());
/*
        if (customerDTO.getId().equals("C001")) {
            throw new RuntimeException("Customer Already Exists");
        }
*/
        if (customerRepo.existsById(customerDTO.getId())) {
            throw new RuntimeException("Customer Already Exists");
        }
        customerRepo.save(modelMapper.map(customerDTO, Customer.class));
        return new ResponseUtil("OK", "Successfully Added", null);
    }

    @DeleteMapping(params = "id")
    public ResponseUtil deleteCustomer(@RequestParam("id") String id) {
        if (!customerRepo.existsById(id)) {
            throw new RuntimeException("Wrong ID");
        }
        customerRepo.deleteById(id);
        return new ResponseUtil("OK", "Successfully Deleted : " + id, null);
    }

    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO customerDTO) {
        //System.out.println(customerDTO.toString());
        /*if (customerDTO.getId().equals("C001")) {
            throw new RuntimeException("Wrong ID");
        }*/
        if (!customerRepo.existsById(customerDTO.getId())) {
            throw new RuntimeException("Customer Already Exists");
        }
        customerRepo.save(modelMapper.map(customerDTO, Customer.class));
        return new ResponseUtil("OK", "Successfully Updated : " + customerDTO.getId(), null);
    }

    @GetMapping
    public ResponseUtil getAllCustomers() {
        List<Customer> customers = customerRepo.findAll();
        ArrayList<CustomerDTO> customerDTOS = modelMapper.map(customers, new TypeToken<ArrayList<CustomerDTO>>(){}.getType());
        return new ResponseUtil("OK", "All Customers", customerDTOS);
    }
}
