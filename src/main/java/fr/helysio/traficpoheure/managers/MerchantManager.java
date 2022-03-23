package fr.helysio.traficpoheure.managers;

import fr.helysio.traficpoheure.generators.MerchantGenerator;
import org.bukkit.Location;
import org.bukkit.entity.Villager;

public class MerchantManager {
    private Villager merchant;
    private Location location;

    public MerchantManager(MerchantGenerator merchantGenerator, Location location) {
        this.merchant = merchantGenerator.generateMerchant(location);
        this.location = location;
    }


}
