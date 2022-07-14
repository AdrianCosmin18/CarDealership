package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PartsUsed {

    private int id;
    private int numberUsed;
    private double price;
    private int partId;
    private int serviceTicketId;

    public PartsUsed(int numberUsed, double price, int partId, int serviceTicketId) {
        this.numberUsed = numberUsed;
        this.price = price;
        this.partId = partId;
        this.serviceTicketId = serviceTicketId;
    }

    @Override
    public String toString() {
        return "PartsUsed{" +
                "id=" + id +
                ", numberUsed=" + numberUsed +
                ", price=" + price +
                ", partId=" + partId +
                ", serviceTicketId=" + serviceTicketId +
                '}';
    }
}
