public class Product {

    private String name, ID;
    private int price, quantity;

    Product(String name, String id, int price, int quantity) {
        this.name = name;
        ID = id;
        this.price = price;
        this.quantity = quantity;
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
    public boolean equals(Object obj) {
        Product o = (Product) obj;
        if (o.getName().equals(((Product) obj).name) && o.getID().equals(((Product) obj).ID))
            return true;
        return false;
    }
}
