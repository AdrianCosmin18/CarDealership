package repositories;

import exceptions.IDNotFoundException;
import models.Car;
import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarRepositoryTest {

    private CarRepository carRepository = new CarRepository();

    @Test
    public void testInsert(){

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Car c = new Car(92003, LocalDate.parse("07-12-2021", dtf), "Lamborghini Urus", "yellow", 2022, true);
        carRepository.insert(c);
        assertEquals(true, carRepository.existsID(8));
    }

    @Test
    public void testDeleteWithCustomException(){

        assertThrows(IDNotFoundException.class, ()->{
            CarRepository carRepository = new CarRepository();
            carRepository.delete(1);
        });
    }

    @Test
    public void testDelete(){
        try{
            carRepository.delete(6);
        }catch (IDNotFoundException e){
            System.err.println("eroare la sterger, nu E acest id in lista");
            e.getMessage();
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectAll(){
        List<Car> cars = carRepository.selectAll();
        System.out.println(cars);
        assertEquals(2, cars.size());
    }

    @Test
    public void testExistsID(){
        assertEquals(true, carRepository.existsID(2));
        assertEquals(false, carRepository.existsID(1));
    }

    @Test
    public void testUpdate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Car car = new Car(2, 5434345, LocalDate.parse("23-11-2021", dtf), "BMW 320d", "grey-black", 2022, true);
        try{
            carRepository.update(car);
        }catch (IDNotFoundException e){
            e.getMessage();
            e.printStackTrace();
        }
    }

    @Test
    public void testContainsCar(){

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Car car = new Car(2, 5434345, LocalDate.parse("23-11-2021", dtf), "BMW 320d", "grey-black", 2022, true);

        try{
            assertEquals(true, carRepository.contains(car));
        }catch (IDNotFoundException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testGetByName(){

        List<Car> cars = carRepository.getByName("Lamborghini");
        assertEquals(2, cars.size());
    }


}