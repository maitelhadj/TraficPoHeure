package fr.helysio.traficpoheure.generators;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;

public class MerchantGenerator {
    private final World world;

    public MerchantGenerator(World world) {
        this.world = world;
    }

    public Villager generateMerchant(Location location) {
        Villager villager = (Villager) world.spawnEntity(location, EntityType.VILLAGER);
        villager.setCustomName("Marchand");

        return villager;
    }
}
