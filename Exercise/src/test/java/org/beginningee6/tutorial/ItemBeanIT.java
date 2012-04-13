package org.beginningee6.tutorial;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;

/**
 * @author Alexis Hassler - http://www.alexis-hassler.com
 */
public class ItemBeanIT {
    
    public static JavaArchive deploy() {
        return ShrinkWrap.create(JavaArchive.class, "test.jar");
    }

    ItemBean itemBean;
    DBInit dBInit;
    
    @Test
    public void shouldGetForbiddenToBuyReturnFalseWhenCustomerCanBuy() {
        // itemBean has a premium customer
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
        itemBean.setLanguageCode("FR");
        
        itemBean.doCreateBook();
        
        assertEquals("ItemBean language code", "French", book.getContentLanguage());
        assertEquals("Tags", Arrays.asList(firstTag, secondTag), book.getTags());
    }

}
