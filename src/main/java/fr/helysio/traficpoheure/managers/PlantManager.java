package fr.helysio.traficpoheure.managers;

import fr.helysio.traficpoheure.objects.Plant;
import org.bukkit.Location;
import java.util.*;

public class PlantManager {

    private HashMap<Location, Plant> plants;
    private int result;

    //prend une liste en paramètre
    PlantManager() {
        this.plants = new HashMap<>(6);

        //TODO recup les pos de plantes dans yml
//        for (int i=0; i<6; i++) {
//            this.plants.putIfAbsent(i,new Plant());
//        }

    }

    PlantManager(HashMap<Location, Plant> plants) {
        this.plants = plants;
    }

    public Plant addPlant(Plant plant, Location slot) {
        return this.plants.put(slot, plant);
    }

    public Plant removePlant(Location slot) {
        return this.plants.put(slot, new Plant());
    }

    public double getTotalScore() {
        double result = 0;

        Iterator<Plant> iterator = this.plants.values().iterator();
        while (iterator.hasNext()) {
            result += iterator.next().getScore();
        }

        return this.result+=result;
    }

    public boolean isLocated(Location location) {
        return plants.containsKey(location);
    }

}