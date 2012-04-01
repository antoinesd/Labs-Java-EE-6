package org.beginningee6.tutorial;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * @author Antonio Goncalves & Alexis Moussine-Pouchkine
 *         Tutorial - Beginning with The Java EE 6 Platform
 *         http://www.antoniogoncalves.org
 *         http://blogs.sun.com/alexismp
 *         --
 *         A CDI (Web)Bean used as a controller by the JSF view
 */
@ManagedBean
@RequestScoped
public class ItemBean implements Serializable {

    // ======================================
    // =             Attributes             =
    // ======================================

    // Insert customer @Inject here

    @EJB
    private ItemEJB itemEJB;
    @EJB
    private LanguageSingleton languageSingleton;
    private Book book = new Book();
    private List<Book> bookList = new ArrayList<Book>();
    private String tags;
    @Size(min = 2, max = 2, message = "Language code should be exactly {min} characters")
    private String languageCode;
    private CD cd = new CD();
    private List<CD> cdList = new ArrayList<CD>();

    // ======================================
    // =          Lifecycle methods         =
    // ======================================
    @PostConstruct
    private void initList() {
        bookList = itemEJB.findAllBooks();
        cdList = itemEJB.findAllCDs();
    }

    // ======================================
    // =           Public Methods           =
    // ======================================
//    public Boolean getForbiddenToBuy() {
//        return cust.canBuy() ? Boolean.FALSE : Boolean.TRUE;
//    }
//
//    public String getBuyButtonLabel() {
//        return cust.canBuy() ? "Buy me!" : "Sorry, can't buy";
//    }
//
//    public String doBuy(javax.faces.event.ActionEvent event) {
//        String isbn = (String) event.getComponent().getAttributes().get("isbn");
//        OrderItem orderItem = cust.buy(isbn); // Will only proceed for @Premium customers
//        System.out.println("** Just bought : " + orderItem);
//        return null;    // Stay on the same page
//    }
    
    public String doNewBookForm() {
        return "newBook.xhtml";
    }

    public String doNewCDForm() {
        return "newCD.xhtml";
    }

    public String doCreateBook() {
        book.setTags(transformToList(tags));
        book.setContentLanguage(languageSingleton.getLanguageValue(languageCode));
        book = itemEJB.createBook(book);
        bookList = itemEJB.findAllBooks();
        return "newBook.xhtml";
    }

    public String doCreateCD() {
        cd = itemEJB.createCD(cd);
        cdList = itemEJB.findAllCDs();
        return "newCD.xhtml";
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

    public CD getCd() {
        return cd;
    }

    public void setCd(CD cd) {
        this.cd = cd;
    }

    public List<CD> getCdList() {
        return cdList;
    }

    public void setCdList(List<CD> cdList) {
        this.cdList = cdList;
    }
}
