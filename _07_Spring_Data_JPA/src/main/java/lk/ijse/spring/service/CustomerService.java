package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);
    void deleteCustomer(String id);
    void updateCustomer(CustomerDTO customerDTO);
    ArrayList<CustomerDTO> getAllCustomers();
    CustomerDTO getCustomerByName(String name);
}
