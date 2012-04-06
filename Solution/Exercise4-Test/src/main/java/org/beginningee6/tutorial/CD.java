package org.beginningee6.tutorial;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

/**
 * @author Antonio Goncalves & Alexis Moussine-Pouchkine
 *         Tutorial - Beginning with The Java EE 6 Platform
 *         http://www.antoniogoncalves.org
 *         http://blogs.sun.com/alexismp
 *         --
 *         Simple Book entity
 */
@Entity
@NamedQuery(name = "findAllCDs", query = "SELECT c FROM CD c ORDER BY c.id DESC")
public class CD extends Item {

    // ======================================
    // =             Attributes             =
    // ======================================
    private String musicCompany;
    private Integer numberOfCDs;
    private Float totalDuration;
    private String style;

    // ======================================
    // =            Constructors            =
    // ======================================

    public CD() {
    }

    public CD(String title, Float price, String description, String musicCompany, Integer numberOfCDs, Float totalDuration) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.musicCompany = musicCompany;
        this.numberOfCDs = numberOfCDs;
        this.totalDuration = totalDuration;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public String getMusicCompany() {
        return musicCompany;
    }

    public void setMusicCompany(String musicCompany) {
        this.musicCompany = musicCompany;
    }

    public Integer getNumberOfCDs() {
        return numberOfCDs;
    }

    public void setNumberOfCDs(Integer numberOfCDs) {
        this.numberOfCDs = numberOfCDs;
    }

    public Float getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(Float totalDuration) {
        this.totalDuration = totalDuration;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    // ======================================
    // =         hash, equals, toString     =
    // ======================================

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Book");
        sb.append("{id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", price=").append(price);
        sb.append(", description='").append(description).append('\'');
        sb.append(", musicCompany='").append(musicCompany).append('\'');
        sb.append(", numberOfCDs=").append(numberOfCDs);
        sb.append(", totalDuration=").append(totalDuration);
        sb.append(", style=").append(style);
        sb.append('}');
        return sb.toString();
    }
}