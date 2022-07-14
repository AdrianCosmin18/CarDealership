package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ServiceTicket {

    private int id;
    private int serviceTicketNumber;
    private LocalDate dateReceived;
    private LocalDate dateReturnedToCustomer;
    private String comments;
    private int carId;
    private int customerId;

    public ServiceTicket(int serviceTicketNumber, LocalDate dateReceived, LocalDate dateReturnedToCustomer, String comments, int carId, int customerId) {
        this.serviceTicketNumber = serviceTicketNumber;
        this.dateReceived = dateReceived;
        this.dateReturnedToCustomer = dateReturnedToCustomer;
        this.comments = comments;
        this.carId = carId;
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "ServiceTicket{" +
                "id=" + id +
                ", serviceTicketNumber=" + serviceTicketNumber +
                ", dateReceived=" + dateReceived +
                ", dateReturnedToCustomer=" + dateReturnedToCustomer +
                ", comments='" + comments + '\'' +
                ", carId=" + carId +
                ", customerId=" + customerId +
                '}';
    }
}
