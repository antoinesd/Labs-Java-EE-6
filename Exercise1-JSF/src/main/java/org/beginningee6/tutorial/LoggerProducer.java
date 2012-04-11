package org.beginningee6.tutorial;

import java.util.logging.Logger;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 *
 * @author Alexis Hassler
 */
public class LoggerProducer {
    
    @Produces
    public Logger getLogger(InjectionPoint injectionPoint) {
        return Logger.getLogger("AAA"); //injectionPoint.getBean().getBeanClass().getName());
    }
    
}
