package Objects;

import java.util.Date;

public class Order {

    private int orderID;
    private Date date;

    public Order(int orderID, Date date) {
        this.orderID = orderID;
        this.date = date;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Ordre ID: [" + orderID + "] Dato: [" + date + "]";
    }
}
