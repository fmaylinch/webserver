package tech.bts.server.data;

public class Purchase {

    private String date;
    private int quantity;
    private Product product;

    public Purchase(String date, int quantity, Product product) {
        this.date = date;
        this.quantity = quantity;
        this.product = product;
    }

    public String getDate() {
        return date;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }
}
