package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Service {

    private int id;
    private String name;
    private int hourlyRate;

    public Service(String name, int hourlyRate) {
        this.name = name;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public String toString() {
        return "Service{" +
                "name='" + name + '\'' +
                ", hourlyRate=" + hourlyRate +
                '}';
    }
}
