package org.gonevertical.server.guice;

import org.gonevertical.server.endpoints.EndpointsModule;
import org.gonevertical.server.servlets.ServletsModule;
import org.gonevertical.server.servlets.paths.ServletsPathModule;

import com.google.inject.AbstractModule;
import com.google.inject.persist.jpa.JpaPersistModule;

/**
 * Main Server Guice Module
 */
public class ServerModule extends AbstractModule {
  
  @Override
  protected void configure() {
    install(new JpaPersistModule("transactions-optional"));
    bind(JpaInitilization.class).asEagerSingleton();
    
    install(new EndpointClassesModule());
    install(new ServletsPathModule());
    install(new ServletsModule());
    install(new EndpointsModule());
  }
  
}
