package be.pxl.ja;

import be.pxl.ja.knapsack.KnapsackFullException;
import be.pxl.ja.robbery.Knapsack;
import be.pxl.ja.robbery.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnapsackTest {
    private Product p1;
    private Product p2;
    private Product p3;
    private Knapsack sack;
    private List<Product> sackContent;

    @BeforeEach
    public void init() {
        p1 = new Product("p1", 5, 10);
        p2 = new Product("p2", 8, 100);
        p3 = new Product("p3", 6, 50);
        sack = new Knapsack(20);
        sackContent = sack.getItems();
    }

    @Test
    public void testGetCurrentWeigthReturnsZeroWhenKnapsackIsEmpty() {
        Assertions.assertEquals(0, sack.getCurrentWeigth());
    }

    @Test
    public void testGetCurrentWeigthReturnsSumOfItemsWeigthsInKnapsack() throws KnapsackFullException {
        for (Product product : Arrays.asList(p1, p2, p3)) {
            sack.add(product);
        }
        Assertions.assertEquals(19, sack.getCurrentWeigth());
    }

    @Test
    public void testAddAddsItemsToProductsList() throws KnapsackFullException {
        for (Product product : Arrays.asList(p1, p2, p3)) {
            sack.add(product);
        }
        Assertions.assertEquals(3, sackContent.stream().count());
    }

    @Test
    public void testAddReturnsExceptionWhenSackIsFull() throws KnapsackFullException {
        Product p4 = new Product("p4", 4, 4);
        try {
            for (Product product : Arrays.asList(p1, p2, p3, p4)) {
                sack.add(product);
            }
        } catch (KnapsackFullException e) {
            System.out.println(e.toString());
            Assertions.assertEquals("Product " + p4.getName() + " not allowed in knapsack.", e.getMessage());
            Assertions.assertEquals(19, sack.getCurrentWeigth());
            Assertions.assertNotNull(sackContent);
        }
    }

}
