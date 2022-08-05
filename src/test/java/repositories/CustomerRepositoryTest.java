package repositories;

import exceptions.IDNotFoundException;
import models.Customer;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRepositoryTest {

    private CustomerRepository customerRepository = new CustomerRepository();

    @Test
    public void testInsert(){

        Customer customer = new Customer("Rodri", "Raul", "07564341276", "str Host 5", "Malaga", "Spania");
        customerRepository.insert(customer);
    }

    @Test
    public void testSelectAll(){

        List<Customer> customers = customerRepository.selectAll();
        assertEquals(5, customers.size());
        System.out.println(customers);
    }

    @Test
    public void testExistsId(){

        assertEquals(true, customerRepository.existsID(2));
        assertTrue(customerRepository.existsID(1));
        assertTrue(customerRepository.existsID(4));
        assertTrue(customerRepository.existsID(5));
        assertFalse(customerRepository.existsID(6));
    }

    @Test
    public void testDelete(){

        try{
            customerRepository.delete(5);
            assertEquals(4, customerRepository.selectAll().size());
        }catch (IDNotFoundException e) {
            e.getMessage();
            e.printStackTrace();
        }
    }

    @Test
    public void testException(){

        assertThrows(IDNotFoundException.class, () -> {
            customerRepository.delete(5);
        });
    }
}