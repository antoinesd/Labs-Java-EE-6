package org.beginningee6.tutorial;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * @author Alexis Hassler - http://www.alexis-hassler.com
 */
public class ItemBeanTest {
    
    @Mock ItemEJB itemEJB;
    @Mock Customer customer;
    @Mock LanguageSingleton languageSingleton;
    @InjectMocks ItemBean itemBean;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void shouldGetForbiddenToBuyReturnFalseWhenCustomerCanBuy() {
        when(customer.canBuy()).thenReturn(Boolean.TRUE);
        assertFalse(itemBean.getForbiddenToBuy());
    }
    
    @Test
    public void testDoCreateBook() {
        Book book = new Book();
        book.title="title";
        book.description = "description";
        book.price = 0F;
        itemBean.setBook(book);
        final String firstTag = "A";
        final String secondTag = "B";
        itemBean.setTags(firstTag+","+secondTag);
        itemBean.setLanguageCode("");
        
        final String language = "L";
        when(languageSingleton.getLanguageValue(itemBean.getLanguageCode())).thenReturn(language);
        final List<Book> allBooks = Arrays.asList(book, new Book(), new Book());
        when(itemEJB.findAllBooks()).thenReturn(allBooks);
        
        itemBean.doCreateBook();
        assertEquals("ItemBean language code", language, book.getContentLanguage());
        assertEquals("Tags", Arrays.asList(firstTag, secondTag), book.getTags());
        assertSame("Booklist", allBooks, itemBean.getBookList());
        verify(itemEJB).createBook(book);
    }

}
