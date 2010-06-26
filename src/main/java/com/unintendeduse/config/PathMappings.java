package com.unintendeduse.config;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.inject.Provides;
import com.google.inject.servlet.ServletModule;
import com.unintendeduse.IndexServlet;
import com.unintendeduse.twigpersist.TwiggyController;
import com.vercer.engine.persist.ObjectDatastore;
import com.vercer.engine.persist.annotation.AnnotationObjectDatastore;

class PathMappings extends ServletModule {
    @Override
    protected void configureServlets() {
        // Do your path mappings here.
        serve("/twiggy").with(TwiggyController.class);
        serve("/").with(IndexServlet.class);
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

}