package be.pxl.ja;

import be.pxl.ja.citytrip.Attraction;
import be.pxl.ja.citytrip.CitytripKnapsackUtil;
import be.pxl.ja.citytrip.Knapsack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CitytripKnapsackUtilityTest {
    private Knapsack citytrip;
    private List<Attraction> plannedAttractions;
    private List<Attraction> possibleAttractions;
    private Attraction a;
    private Attraction b;
    private Attraction c;
    private Attraction d;
    @BeforeEach
    public void init() {
        citytrip = new Knapsack(5);
        plannedAttractions = citytrip.getItems();
        possibleAttractions = new ArrayList<>();
        a = new Attraction("a", 1.0,5);
        b = new Attraction("b", 1.5,6);
        c = new Attraction("c", 2.0,8);
        d = new Attraction("d", 1.5,4);
        possibleAttractions.add(a);
        possibleAttractions.add(b);
        possibleAttractions.add(c);
    }
    @Test
    public void fillAddsAttractionsToCitytripTest() {
        CitytripKnapsackUtil.fill(citytrip, possibleAttractions);
        Assertions.assertEquals(3, (long) plannedAttractions.size());
    }
    @Test
    public void fillDoesNotAddItemWhenPlanningIsFull() {
        possibleAttractions.add(d);
        CitytripKnapsackUtil.fill(citytrip, possibleAttractions);
        Assertions.assertEquals(3, (long) plannedAttractions.size());
    }
    @Test
    public void fillSortsItems(){
        CitytripKnapsackUtil.fill(citytrip, possibleAttractions);
        Assertions.assertEquals("c", plannedAttractions.get(0).getName());
    }


}
