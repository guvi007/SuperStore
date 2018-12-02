import java.io.Serializable;

public class Product implements Serializable, Comparable<Product> {

    private String name, ID;
    private int price, quantity;

    Product(String name, String id, int price, int quantity) {
        this.name = name;
        ID = id;
        this.price = price;
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(String id) {
        this.ID = id;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int compareTo(Product o) {
        return this.name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return this.getName() + " : " + this.getID();
    }
}
