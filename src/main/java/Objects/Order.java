package Objects;

import java.util.Date;

public class Order {

    private int orderID;
    private Date date;
    private String email;
    private int orderLinesID;
    private int amount;
    private int sum;
    private String toppingName;
    private String bottomName;

    public Order(int orderID, Date date, String email, int orderLinesID, int amount, int sum, String toppingName, String bottomName) {
        this.orderID = orderID;
        this.date = date;
        this.email = email;
        this.orderLinesID = orderLinesID;
        this.amount = amount;
        this.sum = sum;
        this.toppingName = toppingName;
        this.bottomName = bottomName;
    }

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

    public String toString2() {
        return "Ordre: " + "\nOrdre ID: " + orderID + ".\nOrdrelinje ID: " + orderLinesID
                + ".\nAntal: " + amount + ".\nPris: " + sum + " kr.\nBund: " + bottomName + ".\nTopping: " + toppingName
                + ".\nDato: " + date + ".\nEmail: " + email;
    }
}
