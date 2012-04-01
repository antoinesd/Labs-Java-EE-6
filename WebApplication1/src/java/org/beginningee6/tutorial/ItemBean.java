package org.beginningee6.tutorial;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Antonio Goncalves & Alexis Moussine-Pouchkine
 *         Tutorial - Beginning with The Java EE 6 Platform
 *         http://www.antoniogoncalves.org
 *         http://blogs.sun.com/alexismp
 *         --
 *         A JSF Managed Bean
 */
@ManagedBean
@RequestScoped
public class ItemBean {

    // ======================================
    // =             Attributes             =
    // ======================================

    @EJB
    private ItemEJB itemEJB;

    @EJB
    private LanguageSingleton languageSingleton;

    private Book book = new Book();
    private List<Book> bookList = new ArrayList<Book>();
    private String tags;
    private String languageCode;

    // ======================================
    // =          Lifecycle methods         =
    // ======================================

    @PostConstruct
    private void initList() {
        bookList = itemEJB.findAllBooks();
    }

    // ======================================
    // =           Public Methods           =
    // ======================================

    public String doNewBookForm() {
        return "newBook.xhtml";
    }

    public String doCreateBook() {
        book.setTags(transformToList(tags));
        book.setContentLanguage(languageSingleton.getLanguageValue(languageCode));
        book = itemEJB.createBook(book);
        bookList = itemEJB.findAllBooks();
        return "newBook.xhtml";
    }

    // ======================================
    // =           Private methods          =
    // ======================================

    private List<String> transformToList(String tagsRequestParameter) {
        List<String> listOfTags = new ArrayList<String>();
        StringTokenizer tokens = new StringTokenizer(tagsRequestParameter, ",");
        while (tokens.hasMoreElements()) {
            listOfTags.add(((String) tokens.nextElement()).trim());
        }
        return listOfTags;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }
}
