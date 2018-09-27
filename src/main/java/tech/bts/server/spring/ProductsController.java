package tech.bts.server.spring;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.bts.server.data.Product;
import tech.bts.server.data.ProductsDatabase;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.List;

@RestController
public class ProductsController {

    @RequestMapping("/products")
    public String index(@RequestParam(value = "maxPrice", required = false) Integer maxPrice) throws IOException {

        System.out.println("maxPrice = " + maxPrice);

        // 1- Get the data (products) from the database
        ProductsDatabase db = new ProductsDatabase();

        List<Product> products;

        if (maxPrice == null) {
            products = db.getProducts();
        } else {
            products = db.getProductsLessThanPrice(maxPrice);
        }

        /* We use Handlebars to generate the HTML

        String productsHtmlPart = "";

        // Loop the list and print details
        for (Product product : products) {
            productsHtmlPart += "<p>" + product + "</p>";
        }
        */

        // 2- Get the HTML template
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("products.hb.html");
        StringWriter writer = new StringWriter();
        IOUtils.copy(inputStream, writer, "UTF-8");
        String html = writer.toString();

        // 3- Fill the template with the data (products)
        Handlebars handlebars = new Handlebars();
        Template template = handlebars.compileInline(html);
        html = template.apply(products);

        return html;
    }
}