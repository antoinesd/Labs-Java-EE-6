package org.beginningee6.tutorial;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Antonio Goncalves & Alexis Moussine-Pouchkine
 *         Tutorial - Beginning with The Java EE 6 Platform
 *         http://www.antoniogoncalves.org
 *         http://blogs.sun.com/alexismp
 *         --
 *         Simple Book entity
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "findAllBooks", query = "SELECT b FROM Book b ORDER BY b.id DESC"),
        @NamedQuery(name = "findFilteredBooks", query = "SELECT b FROM Book b WHERE b.title LIKE :filter ORDER BY b.id DESC"),
        @NamedQuery(name = "findAllScifiBooks", query = "SELECT b FROM Book b JOIN b.tags t WHERE t = 'scifi' ORDER BY b.id DESC")
})
public class Book extends Item {

    // ======================================
    // =             Attributes             =
    // ======================================
    private String isbn;
    private Integer nbOfPage;
    private Boolean illustrations;
    private String contentLanguage;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tags")
    private List<String> tags = new ArrayList<String>();

    // ======================================
    // =            Constructors            =
    // ======================================

    public Book() {
    }

    public Book(String title, Float price, String description, String isbn, Integer nbOfPage, Boolean illustrations) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.isbn = isbn;
        this.nbOfPage = nbOfPage;
        this.illustrations = illustrations;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getNbOfPage() {
        return nbOfPage;
    }

    public void setNbOfPage(Integer nbOfPage) {
        this.nbOfPage = nbOfPage;
    }

    public Boolean getIllustrations() {
        return illustrations;
    }

    public void setIllustrations(Boolean illustrations) {
        this.illustrations = illustrations;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getTagsAsString() {
        String s = new String();
        for (String tag : tags) {
            s += tag + ", ";
        }
        if (s.length() > 2)
            return s.substring(0, s.length() - 2);
        else
            return s;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getContentLanguage() {
        return contentLanguage;
    }

    public void setContentLanguage(String contentLanguage) {
        this.contentLanguage = contentLanguage;
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
        sb.append(", isbn='").append(isbn).append('\'');
        sb.append(", nbOfPage=").append(nbOfPage);
        sb.append(", illustrations=").append(illustrations);
        sb.append(", contentLanguage=").append(contentLanguage);
        sb.append(", tags=").append(getTagsAsString());
        sb.append('}');
        return sb.toString();
    }
}