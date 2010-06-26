package com.unintendeduse.config;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.inject.Provides;
import com.google.inject.servlet.ServletModule;
import com.unintendeduse.IndexServlet;

class PathMappings extends ServletModule {
    @Override
    protected void configureServlets() {
        // Do your path mappings here.
        serve("/").with(IndexServlet.class);
    }

    @Provides
    UserService getUserService() {
        // GAE User Service provider.
        return UserServiceFactory.getUserService();
    }

}