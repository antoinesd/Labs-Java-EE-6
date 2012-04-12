package org.beginningee6.tutorial;

/**
 * @author Antonio Goncalves & Alexis Moussine-Pouchkine
 *         Tutorial - Beginning with The Java EE 6 Platform
 *         http://www.antoniogoncalves.org
 *         http://blogs.sun.com/alexismp
 *         --
 *         A simple helper POJO
 */

public class OrderItem {
    String id = "INVALID";
    public OrderItem(String id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "OrderItem{" + "id=" + id + '}';
    }
}