package org.beginningee6.tutorial;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
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

    @Inject
    private IsbnGenerator isbnGenerator;

    @Inject
    private Logger logger;    

    // ======================================
    // =          Business methods          =
    // ======================================

    @GET // Exo 2
    @Path("{bookKey}") // Exo 2
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON}) // Exo 2
    public Book getBook(@PathParam("bookKey") Long bookKey) { // Exo 2 : @PathParam("bookKey")
        Book theBook = em.find(Book.class, bookKey);
        return theBook;
    }

    public Book createBook(Book book) {
        logger.info("Creation : " + book);
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

    public List<Book> findFilteredBooks(String queryFilter) {
        return em.createNamedQuery("findFilteredBooks").setParameter("filter", "%" + queryFilter + "%").getResultList();
    }

    public CD createCD(CD cd) {
        em.persist(cd);
        return cd;
    }

    public List<CD> findAllCDs() {
        return em.createNamedQuery("findAllCDs").getResultList();
    }
}