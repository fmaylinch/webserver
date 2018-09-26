package tech.bts.server.spark;

import tech.bts.server.data.Product;
import tech.bts.server.data.ProductsDatabase;

import java.util.List;

import static spark.Spark.get;

/**
 * Example application using SparkJava framework
 */
public class Application {

    public static void main(String[] args) {

        get("/products", (req, res) -> {

            // Get the products
            ProductsDatabase db = new ProductsDatabase();
            List<Product> products = db.getProducts();

            String result = "<h1>Products</h1>";

            // Loop the list and print details
            for (Product product : products) {
                result += "<p>" + product + "</p>";
            }

            return result;
        });
    }
}
