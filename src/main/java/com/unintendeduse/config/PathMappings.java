package com.unintendeduse.config;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.inject.Provides;
import com.google.inject.servlet.ServletModule;
import com.unintendeduse.repositories.TwiggyController;
import com.unintendeduse.view.GuicedVelocityViewServlet;
import com.vercer.engine.persist.ObjectDatastore;
import com.vercer.engine.persist.annotation.AnnotationObjectDatastore;
import org.apache.velocity.tools.view.JeeContextConfig;
import org.apache.velocity.tools.view.VelocityView;

import javax.servlet.ServletContext;

class PathMappings extends ServletModule {
    @Override
    protected void configureServlets() {
        // Do your path mappings here.
        serve("/twiggy").with(TwiggyController.class);
        serve("*.vm").with(GuicedVelocityViewServlet.class);
    }

    @Provides
    UserService getUserService() {
        // GAE User Service provider.
        return UserServiceFactory.getUserService();
    }

    @Provides
    ObjectDatastore getObjectDatastore() {
        return new AnnotationObjectDatastore();
    }

    @Provides
    VelocityView getVelocityViewEngine(ServletContext servletContext) {
        return new VelocityView(servletContext);
    }

}