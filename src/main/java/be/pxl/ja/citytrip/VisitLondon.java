package be.pxl.ja.citytrip;

import be.pxl.ja.knapsack.KnapsackUtil;

import java.util.ArrayList;
import java.util.List;

public class VisitLondon {
    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack(2);
        List<Attraction> attractions = new ArrayList<>();

        attractions.add(new Attraction("Westminster Abbey", 0.5, 7));
        attractions.add(new Attraction("Globe Theater", 0.5, 6));
        attractions.add(new Attraction("National Gallery", 1, 7));
        attractions.add(new Attraction("British Museum", 1.5, 9));
        attractions.add(new Attraction("St. Paul's Cathedral", 0.5, 8));

        CitytripKnapsackUtil.fill(knapsack, attractions);

        System.out.println("\nList of attractions:");
        String titles = String.format("%-20s | %4s day | %5s","name", "time", "rating");
        System.out.println(titles);
        for (Attraction attraction : knapsack.getItems()) {
            System.out.println(attraction);
        }
    }
}
