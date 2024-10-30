package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class CustomerServiceImplTest {
    @Autowired
    CustomerService customerService;

    @Test
    public void test() {
        ArrayList<CustomerDTO> allCustomers = customerService.getAllCustomers();

        for (CustomerDTO customerDTO : allCustomers) {
            System.out.println(customerDTO.toString());
        }
    }
}