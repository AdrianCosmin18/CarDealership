package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ServiceMechanic {

    private int id;
    private int hours;
    private String comments;
    private Double rate;
    private int serviceTicketId;
    private int serviceId;
    private int mechanicId;

    public ServiceMechanic(int hours, String comments, Double rate, int serviceTicketId, int serviceId, int mechanicId) {
        this.hours = hours;
        this.comments = comments;
        this.rate = rate;
        this.serviceTicketId = serviceTicketId;
        this.serviceId = serviceId;
        this.mechanicId = mechanicId;
    }

    @Override
    public String toString() {
        return "ServiceMechanic{" +
                "id=" + id +
                ", hours=" + hours +
                ", comments='" + comments + '\'' +
                ", rate=" + rate +
                ", serviceTicketId=" + serviceTicketId +
                ", serviceId=" + serviceId +
                ", mechanicId=" + mechanicId +
                '}';
    }
}
