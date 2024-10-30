package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    //1.Native SQL
    @Query(value = "SELECT * FROM customer", nativeQuery = true)
    List<Customer> methodOne();

        //Using values
    @Query(value = "SELECT * FROM customer WHERE id = 'C001' AND name = 'Pathum'", nativeQuery = true)
    Customer methodTwo();

        //A.Positional Parameters
    @Query(value = "SELECT * FROM customer WHERE id = ?1 AND name = ?2", nativeQuery = true)
    Customer methodThree(String id, String name);
    //1 = id param value
    //2 = name param value

        //B.Named Parameters
    @Query(value = "SELECT * FROM customer WHERE id = :a AND name = :b", nativeQuery = true)
    Customer methodFour(@Param("a") String id, @Param("b") String name);
    //a = id param value
    //b = name param value

    //2.JPQL
    @Query(value = "SELECT c FROM Customer c")
    List<Customer> methodFive();

    //3.HQL
    @Query(value = "FROM Customer")
    List<Customer> methodSix();
}
