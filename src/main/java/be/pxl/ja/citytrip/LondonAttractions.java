package be.pxl.ja.citytrip;

import be.pxl.ja.knapsack.Inventory;
import be.pxl.ja.knapsack.Item;

import java.util.List;

public class LondonAttractions extends Inventory implements Item {
    private String name;
    private double time;
    private Inventory _londonAttractions;

    public LondonAttractions(Inventory _inventory) {
        this._londonAttractions = _inventory;
    }

    @Override
    public double getWeigth() {
        return time;
    }

    @Override
    public String getName() {
        return name;
    }
}
