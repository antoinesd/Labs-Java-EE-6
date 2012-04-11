package org.beginningee6.tutorial;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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
}