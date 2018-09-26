package tech.bts.server.spring;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.bts.server.data.Product;
import tech.bts.server.data.ProductsDatabase;

import java.io.IOException;
import java.util.List;

@RestController
public class ProductsApiController {

    @RequestMapping(value = "/api/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> index(@RequestParam(value = "maxPrice", required = false) Integer maxPrice) throws IOException {

        ProductsDatabase db = new ProductsDatabase();

        List<Product> products;

        if (maxPrice == null) {
            products = db.getProducts();
        } else {
            products = db.getProductsLessThanPrice(maxPrice);
        }

        return products;
    }
}