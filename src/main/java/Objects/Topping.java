package Objects;

public class Topping {
    private int topping_id;
    private String name;
    private int price;

    public Topping(int topping_id, String name, int price) {
        this.topping_id = topping_id;
        this.name = name;
        this.price = price;
    }

    public int getTopping_id() {
        return topping_id;
    }

    public void setTopping_id(int topping_id) {
        this.topping_id = topping_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
