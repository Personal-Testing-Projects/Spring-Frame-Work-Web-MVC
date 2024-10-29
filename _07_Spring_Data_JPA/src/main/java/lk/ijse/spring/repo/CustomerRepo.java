package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, String> {
    Customer findCustomerByName(String name);
    Customer readCustomerByName(String name);
    Customer getCustomerByName(String name);
    Customer queryCustomerByName(String name);
    Customer searchCustomerByName(String name);
    Customer streamCustomerByName(String name);

    Long countCustomerByName(String name);
    Boolean existsCustomerByName(String name);
    Integer deleteCustomerByName(String name);
    Integer removeCustomerByName(String name);
}
