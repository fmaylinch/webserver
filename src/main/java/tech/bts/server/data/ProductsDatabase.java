package tech.bts.server.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductsDatabase {

    private List<Product> products;

    public ProductsDatabase() {

        // Create objects of your class (Product or whatever)
        Product p1 = new Product("iPhone", 1200);
        Product p2 = new Product("TV", 500);
        Product p3 = new Product("pen", 2);
        Product p4 = new Product("Macbook", 2000);
        Product p5 = new Product("Charger", 50);

        // Create list
        this.products = Arrays.asList(p1, p2, p3, p4, p5);
    }

    public List<Product> getProducts() {

        // Simulating that we get the products from the database
        return this.products;
    }

    public List<Product> getProductsLessThanPrice(int maxPrice) {

        List<Product> result = new ArrayList<>();

        for (Product product : products) {
            if (product.getPrice() <= maxPrice) {
                result.add(product);
            }
        }

        return result;
    }
}
