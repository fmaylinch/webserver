package tech.bts.server.jetty;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import tech.bts.server.data.Product;
import tech.bts.server.data.ProductsDatabase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ProductsHandler extends AbstractHandler
{
    @Override
    public void handle( String target,
                        Request baseRequest,
                        HttpServletRequest request,
                        HttpServletResponse response ) throws IOException
    {
        ProductsDatabase db = new ProductsDatabase();
        List<Product> products = db.getProducts();

        String uri = request.getRequestURI();
        System.out.println("URI: " + uri);

        PrintWriter out = response.getWriter();
        response.setStatus(HttpServletResponse.SC_OK);

        out.println("<h1>Products</h1>");

        for (Product product : products) {
            out.println("<p>" + product + "</p>");
        }

        baseRequest.setHandled(true);
    }
}