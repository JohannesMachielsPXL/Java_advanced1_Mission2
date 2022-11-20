package be.pxl.ja.robbery;

import be.pxl.ja.knapsack.KnapsackFullException;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {
    private int maxCapacity;
    private List<Product> products = new ArrayList<>();
    public Knapsack (int maxCapacity){
        this.maxCapacity = maxCapacity;
    }

    public double getCurrentWeigth(){
        return products.stream().mapToDouble(Product::getWeigth).sum(); // met summaryStatistics al de waarden in 1 objectje teruggeven
    }

    // als methode exception kan opwerpen, dit in de signatuur meenemen
    // bij klasse assertions zit methode assertThrow om te controleren of een bepaalde exception effectief is opgegooid
    public void add(Product product) throws KnapsackFullException {
        if (getCurrentWeigth() + product.getWeigth() <= maxCapacity){
            products.add(product);
        } else {
            throw new KnapsackFullException("Cannot add " + product.getClass().getSimpleName().toLowerCase() + " [" + product.getName() + "]. Maximum capacity reached.");
        }
    }

    public List<Product> getItems(){
        return products;
    }

}
