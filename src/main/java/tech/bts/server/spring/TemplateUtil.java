package tech.bts.server.spring;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

public class TemplateUtil {

    public static String createHtml(String templateFile, Object something) throws IOException {

        // Get the HTML template
        InputStream inputStream = ClassLoader.getSystemResourceAsStream(templateFile);
        StringWriter writer = new StringWriter();
        IOUtils.copy(inputStream, writer, "UTF-8");
        String html = writer.toString();

        // Fill the template with the data (products)
        Handlebars handlebars = new Handlebars();
        Template template = handlebars.compileInline(html);
        html = template.apply(something);

        return html;
    }

}
