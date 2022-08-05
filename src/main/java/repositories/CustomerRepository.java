package repositories;

import exceptions.IDNotFoundException;
import models.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository extends Repository<Customer> {

    @Override
    protected void insert(Customer customer) {
        String text = "insert into customers (lastName, firstName, phone, address, city, country) value ";
        text += String.format("('%s', '%s', '%s', '%s', '%s', '%s');", customer.getLastName(), customer.getFirstName(), customer.getPhone(), customer.getAddress(), customer.getCity(), customer.getCountry());
        executeStatement(text);
    }

    public boolean existsID(int id){

        executeStatement(String.format("select * from customers where id = %d;", id));
        try{
            ResultSet set = statement.getResultSet();
            if(set.next()){
                return true;
            }
        }catch (SQLException e){
            e.getMessage();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void delete(int id) throws IDNotFoundException {

        if (existsID(id))
            executeStatement(String.format("delete from customers where id = %d;", id));
        else
            throw new IDNotFoundException(id);

    }
    @Override
    public List<Customer> selectAll(){

        executeStatement("select * from customers");
        try{
            ResultSet resultSet = statement.getResultSet();
            List<Customer> customers = new ArrayList<>();
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                Customer c = new Customer(resultSet.getString(2), resultSet.getString(3),  resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7));
                c.setId(id);
                customers.add(c);
            }
            return customers;
        }catch (SQLException e){
            e.getMessage();
            e.printStackTrace();
        }

        return null;
    }


    @Override
    protected void update(Customer customer) throws IDNotFoundException {

    }

    @Override
    protected boolean contains(Customer customer) throws IDNotFoundException {
        return false;
    }
}
