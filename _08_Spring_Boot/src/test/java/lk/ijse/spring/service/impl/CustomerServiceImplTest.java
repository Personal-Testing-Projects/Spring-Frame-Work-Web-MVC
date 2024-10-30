package lk.ijse.spring.service.impl;

import lk.ijse.spring.config.WebRootConfig;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@WebAppConfiguration
@ContextConfiguration(classes = {WebRootConfig.class})
@ExtendWith(SpringExtension.class)
@Transactional
class CustomerServiceImplTest {
    @Autowired
    CustomerService customerService;
    @Test
    void saveCustomer() {
        CustomerDTO customerDTO = new CustomerDTO("C003", "Pathum", "Kandy", "0712345678");
        //customerService.saveCustomer(customerDTO);

        //We need give valid and invalid data to check

        //valid
        assertDoesNotThrow(() -> customerService.saveCustomer(customerDTO));

        //invalid
        assertThrows(RuntimeException.class, () -> customerService.saveCustomer(new CustomerDTO("C001", "Pathum", "Kandy", "0712345678")));
    }

    @Test
    void deleteCustomer() {
        //valid
        assertDoesNotThrow(() -> customerService.deleteCustomer("C001"));

        //invalid
        assertThrows(RuntimeException.class, () -> customerService.deleteCustomer("C0010"));
    }

    @Test
    void updateCustomer() {
        //valid
        assertDoesNotThrow(() -> customerService.updateCustomer(new CustomerDTO("C001", "Pathum", "Kandy", "0712345678")));

        //invalid
        assertThrows(RuntimeException.class, () -> customerService.updateCustomer(new CustomerDTO("C0010", "Pathum", "Kandy", "0712345678")));
    }

    @Test
    void getAllCustomers() {
        //assertTrue(true);
        //assertFalse(false);

        //valid
        assertTrue(customerService.getAllCustomers().size() > 0);

        //invalid
        assertFalse(customerService.getAllCustomers().isEmpty());
    }

    @Test
    void getCustomerByName() {
        //valid
        CustomerDTO customerDTO = customerService.getCustomerByName("Pathum");
        assertNotNull(customerDTO);

        //invalid
        CustomerDTO customerDTO2 = customerService.getCustomerByName("Kasun");
        assertNull(customerDTO2);
    }
}