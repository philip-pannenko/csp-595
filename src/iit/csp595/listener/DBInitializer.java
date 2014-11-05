package iit.csp595.listener;

import iit.csp595.domain.Database;

import javax.servlet.ServletContextEvent;

public class DBInitializer implements javax.servlet.ServletContextListener {

  @Override
  public void contextDestroyed(ServletContextEvent arg0) {
  }

  @Override
  public void contextInitialized(ServletContextEvent arg0) {
    Database.initDB();
  }
}
