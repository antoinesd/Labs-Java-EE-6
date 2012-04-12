package org.beginningee6.tutorial;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author Antonio Goncalves & Alexis Moussine-Pouchkine
 *         Tutorial - Beginning with The Java EE 6 Platform
 *         http://www.antoniogoncalves.org
 *         http://blogs.sun.com/alexismp
 *         --
 *         An Item mapped super class, inherited by Book and CD
 */
@MappedSuperclass
public abstract class Item {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Id
    @GeneratedValue
    protected Long id;
    @Column(nullable = false)
    //@Size(min = 5, max = 50, message = "Title should be between 5 and 50")
    protected String title;
    protected Float price;
    @Column(length = 2000)
    protected String description;

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
