package fr.helysio.traficpoheure.managers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class CrownManager {

    public Player crownOwner;

    private int lvl;
    private double bonus;

    public CrownManager(int lvl, double bonus) {
        this.lvl = lvl;
        this.bonus = bonus;
    }

    public int getLvl() {
        return this.lvl;
    }

    public double getBonus() {
        return this.bonus;
    }

}
