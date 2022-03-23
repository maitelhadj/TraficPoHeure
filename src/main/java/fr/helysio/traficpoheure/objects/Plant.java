package fr.helysio.traficpoheure.objects;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

public class Plant {
    private String name;
    private ItemStack item;
    private double score;
    private Location pos;

    public Plant() {
        this.name = "";
        this.item = null;
        this.score = 0;
    }

    public Plant(String name, ItemStack item, double score, Location pos) {
        this.name = name;
        this.item = item;
        this.score = score;
    }

    public String getName()
    {
        return name;
    }

    public ItemStack getItem()
    {
        return item;
    }

    public double getScore()
    {
        return score;
    }
}