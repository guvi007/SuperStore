import java.util.ArrayList;

public interface Building {

    void addStuff(String Category, Object stuff);
    void deleteStuff(String parentCategory, Object stuff);
    void modifyProduct(Product product);
    Product returnProduct(Product p);
    boolean stockChecker(Product p);
}
