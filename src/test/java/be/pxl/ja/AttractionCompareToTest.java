package be.pxl.ja;

import be.pxl.ja.citytrip.Attraction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AttractionCompareToTest {
    Attraction attraction1;
    Attraction attraction2;
    Attraction attraction3;
    @BeforeEach
    public void init(){
        attraction1 = new Attraction("El Grotto", 0.5, 8);
        attraction2 = new Attraction("Funky Town", 2.5, 9);
        attraction3 = new Attraction("Waste of Time", 0.1, 8);
    }
    @Test
    public void testCompareToReturnsNegativeWhenThisAttractionRatingLargerThenComparingAttractionRating(){
        Assertions.assertEquals(-1, attraction2.compareTo(attraction1));
    }
    @Test
    public void testCompareToReturnsPositiveWhenThisRatingSmallerThenComparingAttractionRating(){
        Assertions.assertEquals(1, attraction1.compareTo(attraction2));
    }
    @Test
    public void testCompareToReturnsZeroWhenThisAttractionRatingEqualToComparingAttractionRating(){
        Assertions.assertEquals(0, attraction1.compareTo(attraction3));
    }

}
