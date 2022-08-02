package repositories;

import exceptions.IDNotFoundException;
import models.Car;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CarRepository extends Repository<Car> {

    public CarRepository(){super();}

    // good
    @Override
    public void insert(Car car) {

        String text = "insert into cars(serialNumber, make, model, color, year, carForSale) value (";
        text += String.format("%d, '%s', '%s', '%s', %d, %b);", car.getSerialNumber(), car.getMake(), car.getModel(), car.getColor(), car.getYear(), car.isCarForSale());
        executeStatement(text);
    }

    // good
    @Override
    protected void delete(int id) throws IDNotFoundException{

        String text = String.format("delete from cars where id = %d", id);

        if(existsID(id))
            executeStatement(text);
        else
            throw new IDNotFoundException(id);
    }

    // good
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

    //good
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
    protected void update(Car car) throws IDNotFoundException{

        if(existsID(car.getId())){
            String text = String.format("update cars set serialNumber = %d, make = '%s', model = '%s', color = '%s', year = %d, carForSale = %b where id = %d;", car.getSerialNumber(), car.getMake(), car.getModel(), car.getColor(), car.getYear(), car.isCarForSale(), car.getId());
            executeStatement(text);
        }
        else
            throw new IDNotFoundException(car.getId());
    }

    @Override
    protected boolean contains(Car car) throws IDNotFoundException{

        if (existsID(car.getId())){
            String text = String.format("select * from cars where id = %d and serialNumber = %d and make = '%s' and model = '%s' and color = '%s' and year = %d and carForSale = %b", car.getId(), car.getSerialNumber(), car.getMake(), car.getModel(), car.getColor(), car.getYear(), car.isCarForSale());
            executeStatement(text);
        }else
            throw new IDNotFoundException(car.getId());

        try{
            ResultSet set = statement.getResultSet();
            if (set.next())
                return true;
            return false;
        }catch (SQLException e){
            e.getMessage();
            e.printStackTrace();
        }
        return false;
    }

    protected List<Car> getByName(String model){

        System.out.println(model.toLowerCase());
        String text = String.format("select * from cars where lower(model) like %'%s'%;", model.toLowerCase());
        executeStatement(text);

        try{
            ResultSet resultSet = statement.getResultSet();
            List<Car> cars = new ArrayList<>();
            while(resultSet.next()){

                String date = resultSet.getString(3);
                LocalDate localDate = LocalDate.parse(date);
                Car car = new Car(resultSet.getInt(1), resultSet.getInt(2), localDate, resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6), resultSet.getBoolean(7));
                cars.add(car);
            }
            return cars;
        }catch (SQLException e){
            e.printStackTrace();
            e.getMessage();
            System.out.println("eroare la : " + text);
        }
        return null;
    }
}
