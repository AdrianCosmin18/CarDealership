package repositories;

import exceptions.IDNotFoundException;
import models.Car;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CarRepository extends Repository<Car> {

    public CarRepository(){super();}

    //nu merge de aici, merge din sql
    @Override
    protected void insert(Car car) {
        String text = "";
        text += "insert into cars(serialNumber, make, model, color, year, carForSale) value (";
        text += String.format("%d, '%s', '%s', '%s', %d, %b", car.getSerialNumber(), car.getMake(), car.getModel(), car.getColor(), car.getYear(), car.isCarForSale());
        text += ");";

        System.out.println(text);
    }

    //merge si de aici si din sql
    @Override
    protected void delete(int id) {

        String text = String.format("delete from cars where id = %d", id);
        executeStatement(text);

        if(existsID(id))
            executeStatement(text);
        else
            throw new IDNotFoundException(id);
    }

    @Override
    protected List<Car> selectAll() {

        executeStatement("select * from cars;");
        try{
            ResultSet resultSet = statement.getResultSet();
            List<Car> cars = new ArrayList<>();

            while(resultSet.next()){

                LocalDate localDate = LocalDate.parse(resultSet.getString(3));

                Car car = new Car(resultSet.getInt(1), resultSet.getInt(2), localDate, resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6), resultSet.getBoolean(7));
                cars.add(car);
            }
            return cars;

        }catch (SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    protected boolean existsID(int id){

        String text = String.format("select id from cars where id = %d;", id);
        try{
            executeStatement(text);
            ResultSet set = statement.getResultSet();
            if(set.next()){

                int ID = set.getInt(1);
                if(id == ID)
                    return true;
            }
        }catch (Exception e){

            System.out.println("eroare la : " + text);
        }

        return false;
    }

    @Override
    protected void update(Car car) {

    }

    @Override
    protected boolean contains(Car car) {
        return false;
    }
}
