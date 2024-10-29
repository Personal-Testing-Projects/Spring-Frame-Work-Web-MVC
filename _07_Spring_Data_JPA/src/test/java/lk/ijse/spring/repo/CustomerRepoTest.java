package lk.ijse.spring.repo;

import lk.ijse.spring.config.WebRootConfig;
import lk.ijse.spring.entity.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@WebAppConfiguration//create the testing context
@ContextConfiguration(classes = {WebRootConfig.class})//add configuration for that context
@ExtendWith(SpringExtension.class)// integrate junit with spring
@Transactional//When we add this annotation test cases will not change actual database
class CustomerRepoTest {
    @Autowired
    CustomerRepo customerRepo;
    @Test
    void findCustomerByName() {
        Customer customer = customerRepo.findCustomerByName("Pathum");
        System.out.println(customer.toString());
    }

    @Test
    void testAllMethods1() {
        Customer customerOne = customerRepo.findCustomerByName("Pathum");
        Customer customerTwo = customerRepo.readCustomerByName("Pathum");
        Customer customerThree = customerRepo.getCustomerByName("Pathum");
        Customer customerFour = customerRepo.queryCustomerByName("Pathum");
        Customer customerFive = customerRepo.searchCustomerByName("Pathum");
        Customer customerSix = customerRepo.streamCustomerByName("Pathum");
        System.out.println(customerOne.toString()+"\n"+customerTwo.toString()+"\n"+customerThree.toString()+"\n"+
                customerFour.toString()+"\n"+customerFive.toString()+"\n"+customerSix.toString());
        //when we use above queries we should remember if the results include one row we should set a one entity, more than one
        //row we should set a list
        //Above keywords execute the same query
        //We can use any of them
    }

    @Test
    void testAllMethods2() {
        Long count = customerRepo.countCustomerByName("Pathum");
        System.out.println(count);

        Boolean exists = customerRepo.existsCustomerByName("Pathum");
        System.out.println(exists);

        //customerRepo.deleteCustomerByName("Pathum");
        customerRepo.removeCustomerByName("Pathum");
        //InvalidDataAccessApiUsageException occurs from both methods
        //Because this is testing methods
        //For test this methods we need to add @Transactional
    }

    @Test
    void findCustomerByNameAndAddress() {
        Customer customer = customerRepo.findCustomerByNameAndAddress("Pathum", "Kandy");
        System.out.println(customer.toString());
    }

    @Test
    void methodOne() {
        List<Customer> customer = customerRepo.methodOne();
        for (Customer c : customer) {
            System.out.println(c.toString());
        }
    }
}