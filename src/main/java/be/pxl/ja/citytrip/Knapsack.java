package be.pxl.ja.citytrip;

import be.pxl.ja.knapsack.KnapsackFullException;
import be.pxl.ja.robbery.Product;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {
    private int maxCapacity;
    private List<Attraction> attractions = new ArrayList<>();
    public Knapsack (int maxCapacity){
        this.maxCapacity = maxCapacity;
    }
    public double getCurrentWeigth(){
        return attractions.stream().mapToDouble(Attraction::getWeigth).sum(); // met summaryStatistics al de waarden in 1 objectje teruggeven
    }
    // als methode exception kan opwerpen, dit in de signatuur meenemen
    // bij klasse assertions zit methode assertThrow om te controleren of een bepaalde exception effectief is opgegooid
    public void add(Attraction attraction) throws KnapsackFullException {
        if (getCurrentWeigth() + attraction.getWeigth() <= maxCapacity){
            attractions.add(attraction);
        } else {
            throw new KnapsackFullException("Cannot add " + attraction.getClass().getSimpleName().toLowerCase() + " [" + attraction.getName() + "]. Maximum capacity reached.");
        }
    }
    public List<Attraction> getItems(){
        return attractions;
    }

}
