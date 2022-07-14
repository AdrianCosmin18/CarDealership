package repositories;

import models.Car;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class CarRepositoryTest {

    @Test
    public void testInsert(){

        CarRepository carRepository = new CarRepository();
//        carRepository.insert(new Car(5434345, LocalDate.parse("2021-12-23"), "BMW 320d", "grey", 2021, false));
        carRepository.insert(new Car(432421, LocalDate.parse("25-11-2020", DateTimeFormatter.ofPattern("dd-MM-yyyy")), "Dacia Logan 3", "red", 2020, true));
    }


}