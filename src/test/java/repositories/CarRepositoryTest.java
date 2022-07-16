package repositories;

import exceptions.IDNotFoundException;
import models.Car;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class CarRepositoryTest {

    @Test
    public void testInsert(){

        CarRepository carRepository = new CarRepository();
        carRepository.insert(new Car(5434345, LocalDate.parse("2021-12-23"), "BMW 320d", "grey", 2021, false));
        //carRepository.insert(new Car(400000, LocalDate.parse("29-12-2021", DateTimeFormatter.ofPattern("dd-MM-yyyy")), "Lamborghini Huracan SV", "green apple", 2022, true));
    }

    @Test
    public void testDelete(){

        assertThrows(IDNotFoundException.class, ()->{
            CarRepository carRepository = new CarRepository();
            carRepository.delete(4);
        });
    }


}