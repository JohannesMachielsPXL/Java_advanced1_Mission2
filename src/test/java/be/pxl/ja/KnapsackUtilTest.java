package be.pxl.ja;

import be.pxl.ja.knapsack.KnapsackFullException;
import be.pxl.ja.knapsack.KnapsackUtil;
import be.pxl.ja.robbery.Knapsack;
import be.pxl.ja.robbery.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class KnapsackUtilTest {
    private Knapsack sack;
    private List<Product> sackContent;
    private List<Product> products;

    private Product p1;
    private Product p2;
    private Product p3;
    private Product p4;

    @BeforeEach
    public void init() {
        sack = new Knapsack(40);
        sackContent = sack.getItems();
        products = new ArrayList<>();
        p1 = new Product("p1", 11, 10);
        p2 = new Product("p2", 9, 100);
        p3 = new Product("p3", 10, 10);
        p4 = new Product("p4", 12, 100);
        products.add(p1);
        products.add(p2);
        products.add(p3);
    }

    @Test
    public void fillAddsProductsToKnapsackTest() {
        KnapsackUtil.fill(sack, products);
        Assertions.assertEquals(3, (long) sackContent.size());
    }

    @Test
    public void fillDoesNotAddItemWhenKnapsackackIsFull() {
        products.add(p4);
        KnapsackUtil.fill(sack, products);
        Assertions.assertEquals(3, (long) sackContent.size());
    }
    @Test
    public void fillSortsItems(){
        KnapsackUtil.fill(sack, products);
        Assertions.assertEquals("p2", sackContent.get(0).getName());
    }

    /*
    Hoe kan je testen of een exception juist wordt opgegooid
    Hoe kan je testen of de exception message die je verwacht overeenkomt met die de message van de exception die wordt opgegooid
     */

    @Test
    public void fillThrowsExceptionWhenKnapsackIsFull() {
        KnapsackFullException thrown = Assertions.assertThrows(KnapsackFullException.class, () -> {
            products.add(p4);
            KnapsackUtil.fill(sack, products);
        });
        Assertions.assertEquals("Product " + p4.getName() + " not allowed in knapsack.", thrown.getMessage());
    }



}
