package org.beginningee6.tutorial;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Antonio Goncalves & Alexis Moussine-Pouchkine
 *         Tutorial - Beginning with The Java EE 6 Platform
 *         http://www.antoniogoncalves.org
 *         http://blogs.sun.com/alexismp
 *         --
 *         A stateless EJB doing CRUD operations and queries on Books
 */
@Stateless
@Interceptors(LoggingInterceptor.class)
@Path("/items")
public class ItemEJB {

    // ======================================
    // =             Attributes             =
    // ======================================

    @PersistenceContext
    private EntityManager em;

    @Resource
    private IsbnGenerator isbnGenerator;

    // ======================================
    // =          Business methods          =
    // ======================================

    @GET
    @Path("{bookKey}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Book getBook(@PathParam("bookKey") Long bookKey) {
        Book theBook = em.find(Book.class, bookKey);
        return theBook;
    }

    public Book createBook(Book book) {
        book.setIsbn(isbnGenerator.generateIsbn());
        em.persist(book);
        return book;
    }

    public List<Book> findAllBooks() {
        return em.createNamedQuery("findAllBooks").getResultList();
    }

    public List<Book> findAllScifiBooks() {
        return em.createNamedQuery("findAllScifiBooks").getResultList();
    }

    public CD createCD(CD cd) {
        em.persist(cd);
        return cd;
    }

    public List<CD> findAllCDs() {
        return em.createNamedQuery("findAllCDs").getResultList();
    }
}