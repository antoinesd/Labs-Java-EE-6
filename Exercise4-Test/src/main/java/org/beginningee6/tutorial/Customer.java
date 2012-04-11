package org.beginningee6.tutorial;

import java.io.Serializable;

/**
 * @author Antonio Goncalves & Alexis Moussine-Pouchkine
 *         Tutorial - Beginning with The Java EE 6 Platform
 *         http://www.antoniogoncalves.org
 *         http://blogs.sun.com/alexismp
 *         --
 *         A simple interface defining two simple methods
 */
public interface Customer extends Serializable {
    public OrderItem buy(String id);
    public boolean canBuy();
}
