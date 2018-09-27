package tech.bts.server.spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.bts.server.data.Product;
import tech.bts.server.data.ProductsDatabase;
import tech.bts.server.data.Purchase;
import tech.bts.server.data.PurchasesDatabase;

import java.io.IOException;
import java.util.List;

@RestController
public class PurchasesController {

    @RequestMapping("/purchases")
    public String index() throws IOException {

        PurchasesDatabase db = new PurchasesDatabase();

        List<Purchase> purchases;
        purchases = db.getPurchases();

        String html = TemplateUtil.createHtml("purchases.hb.html", purchases);

        return html;
    }
}