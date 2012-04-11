package org.beginningee6.tutorial;

import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 * @author Antonio Goncalves & Alexis Moussine-Pouchkine
 *         Tutorial - Beginning with The Java EE 6 Platform
 *         http://www.antoniogoncalves.org
 *         http://blogs.sun.com/alexismp
 *         --
 *         A simple POJO annotation with a CDI Qualifier
 */
public class SpecialCustomer implements Customer {

    @Inject @ImportantOrder Event<OrderItem> order;
    
    @Override
    public OrderItem buy(String id) {
        OrderItem theOrder = new OrderItem(id);
        order.fire(theOrder);  // will be caught by any method declaring
                               // an "@Observes Order" parameter.
        return theOrder;
    }

    @Override
    public boolean canBuy() {
        return true;
    }

}
