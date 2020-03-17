package Objects;

public class Topping {
    private int id;
    private String name;
    private int price;

    public Topping(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
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
