package be.pxl.ja.citytrip;

import be.pxl.ja.knapsack.KnapsackFullException;

import java.util.Comparator;
import java.util.List;

public final class CitytripKnapsackUtil {
    public static void fill(Knapsack citytrip, List<Attraction> attractions) {
        attractions.sort(Comparator.comparingDouble(Attraction::getRating).reversed());

        try {
            for (Attraction a : attractions)
                citytrip.add(a);
        } catch (KnapsackFullException e) {
            System.out.println(e.getMessage());
        }
    }

}
