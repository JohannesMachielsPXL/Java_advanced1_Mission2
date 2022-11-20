package be.pxl.ja.robbery;

import be.pxl.ja.knapsack.KnapsackFullException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Demo {
    public static void main(String[] args) throws KnapsackFullException {
        Knapsack sack = new Knapsack(250);
        Product p1 = new Product("p1", 5,20);
        Product p2 = new Product("p2", 8,25);
        Product p3= new Product("p3", 6,30);
        sack.add(p1);
        sack.add(p2);
        sack.add(p3);
        List<Product> sackContent = sack.getItems();
        // sorteren op prijs klein naar groot
        System.out.println("Sorteren op prijs klein naar groot");
        Collections.sort(sackContent);
        sackContent.forEach(System.out::println);
        System.out.println();
        // sorteten op gewicht
        System.out.println("Sorteren op gewicht klein naar groot");
        sackContent.sort(Comparator.comparingDouble(Product::getWeigth));
        sackContent.forEach(System.out::println);
        System.out.println();
        // Vergelijken van gewichten van 2 items
        System.out.println("Gewichten van 2 items vergelijken");
        double vergelijking = p1.compareTo(p2);
        System.out.println("p1 vergeleken met p2 geeft: " + vergelijking);
        System.out.println();
        // Lijst van de items in de zak oproepen
        System.out.println("Lijst van de items in de zak:");
        for (Product product : sackContent) {
            System.out.println("- " + product);
        }
        System.out.println();
        // Gewicht van de inhoud opvragen
        System.out.println("Gewicht van items in de zak weergeven");
        double sackWeigth = sack.getCurrentWeigth();
        System.out.println("de zak weegt " + sackWeigth);


    }
}
