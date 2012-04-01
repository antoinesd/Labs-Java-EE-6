package org.beginningee6.tutorial;

/**
 * @author Antonio Goncalves & Alexis Moussine-Pouchkine
 *         Tutorial - Beginning with The Java EE 6 Platform
 *         http://www.antoniogoncalves.org
 *         http://blogs.sun.com/alexismp
 *         --
 *         A simple POJO annotation with a CDI Qualifier
 */

// TODO: add @Premium

public class SpecialCustomer implements Customer {

    @Override
    public OrderItem buy(String id) {
        OrderItem theOrder = new OrderItem(id);
        return theOrder;
    }

    @Override
    public boolean canBuy() {
        return true;
    }

}
