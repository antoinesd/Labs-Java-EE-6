package org.beginningee6.tutorial;


/**
 * @author Antonio Goncalves & Alexis Moussine-Pouchkine
 *         Tutorial - Beginning with The Java EE 6 Platform
 *         http://www.antoniogoncalves.org
 *         http://blogs.sun.com/alexismp
 *         --
 *         A simple implementation of the Customer interface with no CDI Qualifier
 */
public class DefaultCustomer implements Customer {

    @Override
    public OrderItem buy(String id) {
        System.out.println("Not supported yet.");
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean canBuy() {
        return false;
    }

}
