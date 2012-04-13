package org.beginningee6.tutorial;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.junit.*;
import static org.junit.Assert.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

/**
 * @author Alexis Hassler - http://www.alexis-hassler.com
 */
public class ItemEJBTest {
    
    @Mock EntityManager em;
    @Mock Query namedQuery;
    @Mock IsbnGenerator isbnGenerator;
    @Mock Logger logger;
    @InjectMocks ItemEJB itemEJB;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void shouldGetBookSimplyReturnFoundBook() throws Exception {
        final Book book = new Book();
        when(em.find(Book.class, 1L)).thenReturn(book);
        
        Book bookFound = itemEJB.getBook(1L);
        assertSame(book, bookFound);
    }

    @Test
    public void shouldCreateBookReturnCreatedBookWithIsbn() throws Exception {
        when(isbnGenerator.generateIsbn()).then(RETURNS_MOCKS);
        final Book book = new Book();
        
        Book bookFound = itemEJB.createBook(book);
        assertSame(book, bookFound);
        assertNotNull(book.getIsbn());
    }

    @Test
    public void shouldFindAllBooksSimplyReturnFoundBooks() throws Exception {
        final List<Book> books = Arrays.asList(new Book(), new Book(), new Book());
        final int bookNumber = books.size();
        when(namedQuery.getResultList()).thenReturn(books);
        when(em.createNamedQuery("findAllBooks")).thenReturn(namedQuery);
        
        final List<Book> allBooks = itemEJB.findAllBooks();
        assertEquals("List size has been modified", bookNumber, allBooks.size());
        assertSame(books, allBooks);
    }

    @Test
    public void shouldFindAllScifiBooksSimplyReturnFoundBooks() throws Exception {
        final List<Book> books = Arrays.asList(new Book(), new Book(), new Book());
        final int bookNumber = books.size();
        when(namedQuery.getResultList()).thenReturn(books);
        when(em.createNamedQuery("findAllScifiBooks")).thenReturn(namedQuery);
        
        final List<Book> scifiBooks = itemEJB.findAllScifiBooks();
        assertEquals("List size has been modified", bookNumber, scifiBooks.size());
        assertSame(books, scifiBooks);
    }

    @Test
    public void shouldCreateCDReturnCreatedCD() throws Exception {
        final CD cd = new CD();
        
        CD cdFound = itemEJB.createCD(cd);
        assertSame(cd, cdFound);
    }

    @Test
    public void shouldFindAllCDsSimplyReturnFoundCDs() throws Exception {
        final List<CD> CDs = Arrays.asList(new CD(), new CD(), new CD());
        final int cdNumber = CDs.size();
        when(namedQuery.getResultList()).thenReturn(CDs);
        when(em.createNamedQuery("findAllCDs")).thenReturn(namedQuery);
        
        final List<CD> allCDs = itemEJB.findAllCDs();
        assertEquals("List size has been modified", cdNumber, allCDs.size());
        assertSame(CDs, allCDs);
    }
}
