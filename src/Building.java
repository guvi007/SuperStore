public interface Building {

    void addProduct(Product product);
    void deleteProduct(Product product);
    void modifyProduct(Product product);
    Product returnProduct();
    boolean stockChecker(Product p);
}
