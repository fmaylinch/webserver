package tech.bts.server.jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;

/**
 * Example application using Jetty server
 */
public class Application
{
    public static void main( String[] args ) throws Exception
    {
        Server server = new Server(8080);

        ContextHandler contextHandler = new ContextHandler("/products");
        contextHandler.setHandler(new ProductsHandler());

        server.setHandler(contextHandler);

        server.start();
        server.join();
    }
}