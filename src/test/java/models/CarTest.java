package models;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    public void testCreate(){

        Car skoda = new Car(234, LocalDate.parse("14,07,2022"), "skoda", "black", 2022,true);
        System.out.println(skoda);
    }

}