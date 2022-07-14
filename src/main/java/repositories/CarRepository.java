package repositories;

import models.Car;

import java.util.List;

public class CarRepository extends Repository<Car> {

    public CarRepository(){super();}

    @Override
    protected void insert(Car car) {
        String text = "";
        text += "insert into cars(serialNumber, make, model, color, year, carForSale) values(";
        text += String.format("%d, '%s', '%s', '%s', %d, %b", car.getSerialNumber(), car.getMake(), car.getModel(), car.getColor(), car.getYear(), car.isCarForSale());
        text += ");";
        executeStatement(text);
    }

    @Override
    protected void delete(int id) {

    }

    @Override
    protected List<Car> selectAll() {
        return null;
    }

    @Override
    protected void update(Car car) {

    }

    @Override
    protected boolean contains(Car car) {
        return false;
    }
}
