package tech.bts.server.data;

import java.util.Arrays;
import java.util.List;

public class PurchasesDatabase {

    private List<Purchase> purchases;

    public PurchasesDatabase() {

        ProductsDatabase db = new ProductsDatabase();
        List<Product> products = db.getProducts();

        // Create objects of your class
        Purchase p1 = new Purchase("2018-09-25", 10, products.get(2));
        Purchase p2 = new Purchase("2018-09-26", 5, products.get(0));
        Purchase p3 = new Purchase("2018-09-27", 20, products.get(2));

        // Create list
        this.purchases = Arrays.asList(p1, p2, p3);
    }

    public List<Purchase> getPurchases() {

        // Simulating that we get the purchases from the database
        return this.purchases;
    }
}
