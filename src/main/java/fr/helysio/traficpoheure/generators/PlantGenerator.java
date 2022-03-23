package fr.helysio.traficpoheure.generators;

import fr.helysio.traficpoheure.exception.WrongTypeOfBlockException;

import fr.helysio.traficpoheure.objects.Plant;
import io.netty.util.internal.ThreadLocalRandom;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.List;

public class PlantGenerator {
    private final World world;
    private final List<Location> alreadyUsedLocations;

    public PlantGenerator(World world) {
        this.world = world;
        this.alreadyUsedLocations = new ArrayList<>(0);
    }

    public Location getRandomLocation(double xMin, double xMax, double zMin, double zMax) {
        final double randomX = ThreadLocalRandom.current().nextDouble(xMin, xMax);
        final double randomZ = ThreadLocalRandom.current().nextDouble(zMin, zMax);
        return world.getHighestBlockAt(world.getWorldBorder().getCenter().add(randomX, 0, randomZ)).getLocation();
    }
    /**
     * Fonction qui fait apparaitre une plante à une position aléatoire sur la carte. La position aléatoire
     * est donnée par la fonction getRandomLocation(...)
     * La plante apparait sur le bloc le plus haut de la position. Si le bloc le plus haut n'est pas un bloc AIR
     * et n'est pas un bloc GRASS :
     * @throws WrongTypeOfBlockException
     */
    public boolean generatePlant(double xMin, double xMax, double zMin, double zMax, Plant plant)
            throws WrongTypeOfBlockException {
        Block block = world.getHighestBlockAt(getRandomLocation(xMin, xMax, zMin, zMax));
        Location blockLocation = block.getLocation();

        if (!(block.getType().equals(Material.AIR) | block.getType().equals(Material.GRASS)))
            throw new WrongTypeOfBlockException("Attention : Pas la surface " + "[X : " + blockLocation.getX() +
                    ", Y : " + blockLocation.getY() + ", Z : " + blockLocation.getZ() + "]");

        if (!alreadyUsedLocations.contains(blockLocation)) {
            block.setType(plant.getItem().getType());
            System.out.println(plant.getName() + " has grown here [X : " + blockLocation.getX() + ", Y : " + blockLocation.getY() + ", Z : " + blockLocation.getZ() + "]");
            alreadyUsedLocations.add(blockLocation);
        } else
            return false;

        return true;
    }
}
