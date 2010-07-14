package com.unintendeduse.repositories;

import com.google.appengine.api.datastore.Key;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.vercer.engine.persist.ObjectDatastore;
import org.apache.velocity.Template;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.view.VelocityView;
import org.apache.velocity.tools.view.VelocityViewServlet;
import org.apache.velocity.tools.view.ViewToolContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;

@Singleton
public class TwiggyController extends HttpServlet {
    private ObjectDatastore datastore;
    private VelocityView velocityView;

    @Inject
    public TwiggyController(VelocityView velocityView) {
        this.velocityView = velocityView;

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ViewToolContext context = velocityView.createContext(req, resp);
        Template template = velocityView.getTemplate("/twigpersist/twiggyController.vm");
        System.out.println("ima gonna render this bastard");
        velocityView.merge(template, context, resp.getWriter());
        
    }
}
