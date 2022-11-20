package be.pxl.ja;

import be.pxl.ja.citytrip.Attraction;
import be.pxl.ja.citytrip.Knapsack;
import be.pxl.ja.knapsack.KnapsackFullException;
import be.pxl.ja.robbery.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CitytripKnapsackTest {
    private Attraction a;
    private Attraction b;
    private Attraction c;
    private Knapsack citytrip;
    private List<Attraction> planning;

    @BeforeEach
    public void init() {
        a = new Attraction("a", 0.5, 5);
        b = new Attraction("b", 1.5, 8);
        c = new Attraction("c", 1.0, 6);
        citytrip = new Knapsack(2);
        planning = citytrip.getItems();
    }

    @Test
    public void testGetCurrentWeigthReturnsZeroWhenKnapsackIsEmpty() {
        Assertions.assertEquals(0, citytrip.getCurrentWeigth());
    }
    @Test
    public void testGetCurrentWeigthReturnsSumOfItemsWeigthsInKnapsack() throws KnapsackFullException {
        for (Attraction attraction : Arrays.asList(a, b)) {
            citytrip.add(attraction);
        }
        Assertions.assertEquals(2, citytrip.getCurrentWeigth());
    }

    @Test
    public void testAddAddsItemsToProductsList() throws KnapsackFullException {
        for (Attraction attraction : Arrays.asList(a,b)) {
            citytrip.add(attraction);
        }
        Assertions.assertEquals(2, (long) planning.size());
    }

    @Test
    public void testAddReturnsExceptionWhenSackIsFull() throws KnapsackFullException {
        try {
            for (Attraction attraction : Arrays.asList(a,b,c)) {
                citytrip.add(attraction);
            }
        } catch (KnapsackFullException e) {
            Assertions.assertEquals("Attraction " + c.getName() + " not added to citytrip.", e.getMessage());
            Assertions.assertEquals(2, citytrip.getCurrentWeigth());
            Assertions.assertNotNull(planning);
        }
    }

}
