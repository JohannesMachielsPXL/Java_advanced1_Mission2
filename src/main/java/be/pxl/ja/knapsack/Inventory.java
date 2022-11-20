package be.pxl.ja.knapsack;

import java.util.List;

public class Inventory {
    private List<Item> _inventory;

    public List<Item> get_inventory() {
        return _inventory;
    }

    public void set_inventory(List<Item> _inventory) {
        this._inventory = _inventory;
    }

    public Inventory() {

    }
}
