package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Car {


    private int id;
    private int serialNumber;
    private LocalDate make;
    private String model;
    private String color;
    private int year;
    private boolean carForSale;

    public Car(int serialNumber, LocalDate make, String model, String color, int year, boolean carForSale) {
        this.serialNumber = serialNumber;
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.carForSale = carForSale;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", serialNumber=" + serialNumber +
                ", make=" + make +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", year='" + year + '\'' +
                ", carForSale=" + carForSale +
                '}';
    }
}
