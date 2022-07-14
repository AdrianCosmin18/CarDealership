package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SalesInvoice {

    private int id;
    private int invoiceNumber;
    private LocalDate date;
    private int carId;
    private int customerId;
    private int salespersonId;

    public SalesInvoice(int invoiceNumber, LocalDate date, int carId, int customerId, int salespersonId) {
        this.invoiceNumber = invoiceNumber;
        this.date = date;
        this.carId = carId;
        this.customerId = customerId;
        this.salespersonId = salespersonId;
    }

    @Override
    public String toString() {
        return "SalesInvoice{" +
                "id=" + id +
                ", invoiceNumber=" + invoiceNumber +
                ", date=" + date +
                ", carId=" + carId +
                ", customerId=" + customerId +
                ", salespersonId=" + salespersonId +
                '}';
    }


}
