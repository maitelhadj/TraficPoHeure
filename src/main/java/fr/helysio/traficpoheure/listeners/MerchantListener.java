package fr.helysio.traficpoheure.listeners;

import fr.helysio.traficpoheure.TraficPOHeure;
import fr.helysio.traficpoheure.game.TraficPOHeureGameManager;
import fr.helysio.traficpoheure.managers.TeamManager;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class MerchantListener implements Listener {

    private TraficPOHeure main;
    private TraficPOHeureGameManager gameManager;

    @EventHandler
    public void onMerchantClick(PlayerInteractEntityEvent e) {
        if (!(e.getRightClicked() instanceof Villager)) return;
        Villager villager = (Villager) e.getRightClicked();
        Player player = e.getPlayer();
        villager.getLocation();
        String vname = villager.getName();

    }
}
