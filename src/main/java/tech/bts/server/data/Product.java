package tech.bts.server.data;

public class Product {

    // Fields
    private String name;
    private int price;

    // Constructor
    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }


    // These methods are called "getters"
    // Used to access the private fields from other classes.

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }



    // Methods

    @Override
    public String toString() {
        return this.name + " with price: " + this.price + " euros";
    }
}
