package be.pxl.ja.knapsack;

import be.pxl.ja.robbery.Knapsack;
import be.pxl.ja.robbery.Product;

import java.util.Comparator;
import java.util.List;

public final class KnapsackUtil {

    public static void fill(Knapsack sack, List<Product> products) {
        products.sort(Comparator.comparingDouble(Product::getPrice).reversed());

        try {
            for (Product p : products)
                sack.add(p);
        } catch (KnapsackFullException e) {
            System.out.println(e.getMessage());
        }
    }

}
