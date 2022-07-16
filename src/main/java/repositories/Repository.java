package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class Repository<T> {

    private String JdbcURL = "jdbc:mysql://localhost:3306/cardealership";
    private String username = "root";
    private String password = "1234";
    protected Connection connection = null;
    protected Statement statement = null;

    public Repository(){

        try{
            connection = DriverManager.getConnection(JdbcURL, username, password);
            statement =  connection.createStatement();
        }catch (SQLException e){
            System.out.println("eroare la conectare la baza de date");
        }
    }

    public void executeStatement(String execute){

        try{

            statement.execute(execute);
        }catch (SQLException e){

            System.out.println("eroare la " + execute);
        }
    }

    protected abstract void insert(T t);
    protected abstract void delete(int id);
    protected abstract List<T> selectAll();
    protected abstract void update(T t);
    protected abstract boolean contains(T t);
}
