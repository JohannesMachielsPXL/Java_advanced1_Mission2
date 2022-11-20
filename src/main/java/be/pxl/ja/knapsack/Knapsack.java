package be.pxl.ja.knapsack;

import be.pxl.ja.citytrip.Attraction;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {
    private int maxCapacity;
    private List<Item> inventory = new ArrayList<>();
    public Knapsack (int maxCapacity){
        this.maxCapacity = maxCapacity;
    }
    public double getCurrentWeigth(){
        return inventory.stream().mapToDouble(Item::getWeigth).sum(); // met summaryStatistics al de waarden in 1 objectje teruggeven
    }
    // als methode exception kan opwerpen, dit in de signatuur meenemen
    // bij klasse assertions zit methode assertThrow om te controleren of een bepaalde exception effectief is opgegooid
    public void add(Item item) throws KnapsackFullException {
        if (getCurrentWeigth() + item.getWeigth() <= maxCapacity){
            inventory.add(item);
        } else {
            throw new KnapsackFullException("Cannot add " + item.getClass().getSimpleName().toLowerCase() + " [" + item.getName() + "]. Maximum capacity reached.");
        }
    }
    public List<Item> getItems(){
        return inventory;
    }

}
