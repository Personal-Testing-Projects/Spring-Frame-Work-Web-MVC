package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

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

    Customer findCustomerByNameAndAddress(String name, String address);

    //Query
    //Native SQL
    @Query(value = "SELECT * FROM customer", nativeQuery = true)
    List<Customer> methodOne();
}
