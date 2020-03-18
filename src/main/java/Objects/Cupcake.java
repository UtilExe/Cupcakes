package Objects;

import DBAccess.UserMapper;
import PresentationLayer.Redirect;

public class Cupcake {

    private Topping topping;
    private Bottom bottom;
    private int quantity;

    public Cupcake(Topping topping, Bottom bottom, int quantity) {
        this.topping = topping;
        this.bottom = bottom;
        this.quantity = quantity;
    }

    public int getToppingID() {
        return topping.getID();
    }

    public String getToppingName() {
        return topping.getName();
    }

    public int getToppingPrice() {
        return topping.getPrice();
    }

    public int getBottomID() {
        return bottom.getID();
    }

    public String getBottomName() {
        return bottom.getName();
    }

    public int getBottomPrice() {
        return bottom.getPrice();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Cupcake{" +
                "topping=" + topping +
                ", bottom=" + bottom +
                ", quantity=" + quantity +
                '}';
    }
}
