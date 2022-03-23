package fr.helysio.traficpoheure.objects;

import org.bukkit.Location;

public class Area {

    private int lvl;
    private int bones;
    private Location location0;
    private Location location1;
    private boolean isActive;

    public Area(int lvl, int bones, Location location0, Location location1) {
        this.lvl = lvl;
        this.bones = bones;
        this.location0 = location0;
        this.location1 = location1;
    }

    public int getLvl()
    {
        return this.lvl;
    }

    public int getBones()
    {
        return this.bones;
    }

}
