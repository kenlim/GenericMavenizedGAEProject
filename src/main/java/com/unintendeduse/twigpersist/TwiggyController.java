package com.unintendeduse.twigpersist;

import com.google.appengine.api.datastore.Key;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.vercer.engine.persist.ObjectDatastore;
import org.apache.velocity.Template;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.view.VelocityViewServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;

@Singleton
public class TwiggyController extends VelocityViewServlet {
    private ObjectDatastore datastore;

    @Inject
    public TwiggyController(ObjectDatastore datastore) {

        this.datastore = datastore;
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TwiggyTitle twiggyTitle = new TwiggyTitle();

        twiggyTitle.setName(request.getParameter("name"));
        twiggyTitle.setDescription(request.getParameter("description"));


        Key key = datastore.store().instance(twiggyTitle).returnKeyNow();
        response.sendRedirect("/twiggy");
    }


    @Override
    protected void fillContext(Context context, HttpServletRequest request) {
        Iterator<TwiggyTitle> titleQueryResultIterator = datastore.find(TwiggyTitle.class);
        context.put("twiggies", titleQueryResultIterator);

    }

    @Override
    protected Template getTemplate(HttpServletRequest request, HttpServletResponse response) {
        return getTemplate("/twigpersist/twiggyController.vm");
    }
}
