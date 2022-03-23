package fr.helysio.traficpoheure.objects;

import fr.helysio.traficpoheure.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Crown {

    private int lvl;
    private double bonus;
    private List<String> lore = Arrays.asList("§7Lorsque vous avez cette couronne", "§7vos points sont boostés");
    private ItemBuilder crown = new ItemBuilder(Material.GOLD_HELMET,1,"§aCouronne",lore);

    public Crown(int lvl, double bonus) {
        this.lvl = lvl;
        this.bonus = bonus;
    }

    public ItemStack getCrown() {
        return null;
    }

    public int getLvl()
    {
        return this.lvl;
    }

    public double getBonus()
    {
        return this.bonus;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
