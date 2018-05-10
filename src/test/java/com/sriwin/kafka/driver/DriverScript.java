package com.sriwin.kafka.driver;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;
import com.sriwin.kafka.exception.CoreException;
import com.sriwin.kafka.utils.DirUtil;
import com.sriwin.kafka.utils.PropertyManager;
import org.slf4j.LoggerFactory;

public class DriverScript {
  public void doInit() {
    /**
     * initialize log4j
     */
    String logbackFilePath = DirUtil.getConfigDir() + "logback.xml";
    LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
    try {
      JoranConfigurator configurator = new JoranConfigurator();
      configurator.setContext(context);
      context.reset();
      configurator.doConfigure(logbackFilePath);
    } catch (JoranException je) {
      // StatusPrinter will handle this
    }
    StatusPrinter.printInCaseOfErrorsOrWarnings(context);

    try {
      PropertyManager propertyManager = PropertyManager.getInstance();
      propertyManager.init();
    } catch (CoreException e) {
      e.printStackTrace();
    }
  }
}
