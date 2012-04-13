package org.beginningee6.tutorial;

import java.util.logging.Logger;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 * @author Alexis Hassler - http://www.alexis-hassler.com
 */
public class LoggerProducer {
    
    @Produces
    public Logger getLogger(InjectionPoint injectionPoint) {
        return Logger.getLogger(injectionPoint.getBean().getBeanClass().getName());
    }
    
}
