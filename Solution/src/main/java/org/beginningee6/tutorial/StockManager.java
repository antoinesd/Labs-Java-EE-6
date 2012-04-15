/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.beginningee6.tutorial;

import java.util.logging.Logger;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

/**
 *
 * @author yblazart
 */
@Singleton
@Startup
public class StockManager {
    
    @Inject
    private Logger logger;
    
    
    public void prepareOrder(@Observes OrderItem orderItem) {
//        throw new RuntimeException("test fail");
        logger.info("Stock new order :"+orderItem.toString());
                
    } 
    
}
