package tech.bts.server.spring;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import org.apache.commons.io.IOUtils;
import tech.bts.server.data.Product;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.List;

public class TemplateUtil {

    public static String createHtml(String templateFile, List<Product> products) throws IOException {

        // Get the HTML template
        InputStream inputStream = ClassLoader.getSystemResourceAsStream(templateFile);
        StringWriter writer = new StringWriter();
        IOUtils.copy(inputStream, writer, "UTF-8");
        String html = writer.toString();

        // Fill the template with the data (products)
        Handlebars handlebars = new Handlebars();
        Template template = handlebars.compileInline(html);
        html = template.apply(products);

        return html;
    }

}
