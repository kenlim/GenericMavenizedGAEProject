package namespace;

import com.google.inject.Singleton;
import org.apache.velocity.Template;
import org.apache.velocity.tools.view.VelocityViewServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Singleton
public class IndexServlet extends VelocityViewServlet{

    @Override
    protected Template getTemplate(HttpServletRequest request, HttpServletResponse response) {
        return getTemplate("/index.vm");
    }
}
