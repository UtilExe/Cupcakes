package Objects;

import DBAccess.UserMapper;
import PresentationLayer.Redirect;

public class Cupcake {

    private Bottom bottom;
    private Topping topping;
    private int quantity;

    public Cupcake(Bottom bottom, Topping topping, int quantity) {
        this.bottom = bottom;
        this.topping = topping;
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
                "bottom=" + bottom +
                ", topping=" + topping +
                ", quantity=" + quantity +
                '}';
    }
}
