package be.pxl.ja;

import be.pxl.ja.robbery.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ProductCompareToTest {
    private Product p1;
    private Product p2;

    @BeforeEach
    public void init(){
        p1 = new Product("p1", 5,10);
        p2 = new Product("p2", 8,100);
    }

    @Test
    public void testCompareToReturnsNegative1IfProductIsCheaper(){
        Assertions.assertEquals(-1, p1.compareTo(p2));
    }

    @Test
    public void testCompareToReturnsPositive1IfProductIsMoreExpensive(){
        Assertions.assertEquals(1, p2.compareTo(p1));
    }
    @Test
    public void testCompareToReturns0WhenPricesAreTheSame(){
        Product p3 = new Product("p3", 8,10);
        Assertions.assertEquals(0, p1.compareTo(p3));
    }

}
