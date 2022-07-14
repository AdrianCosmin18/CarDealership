package models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class Parts {

    private int id;
    private int partNumber;
    private String description;
    private double purchasePrice;
    private double retailPrice;

    public Parts(int partNumber, String description, double purchasePrice, double retailPrice) {
        this.partNumber = partNumber;
        this.description = description;
        this.purchasePrice = purchasePrice;
        this.retailPrice = retailPrice;
    }

    @Override
    public String toString() {
        return "Parts{" +
                "id=" + id +
                ", partNumber=" + partNumber +
                ", description='" + description + '\'' +
                ", purchasePrice=" + purchasePrice +
                ", retailPrice=" + retailPrice +
                '}';
    }
}
