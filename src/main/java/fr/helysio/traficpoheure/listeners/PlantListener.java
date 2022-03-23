package fr.helysio.traficpoheure.listeners;

import fr.helysio.traficpoheure.game.TraficPOHeureGameManager;
import fr.helysio.traficpoheure.managers.TeamManager;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class PlantListener implements Listener {

    private TraficPOHeureGameManager gameManager;

    PlantListener(TraficPOHeureGameManager gameManager) { this.gameManager = gameManager; }

    @EventHandler
    public void onLeftClick(BlockBreakEvent e) {
        e.setCancelled(true);
        Player player = e.getPlayer();
        Block block = e.getBlock();
        Location location = e.getBlock().getLocation();
        if (block.getType().name() != ) {

        }
        TeamManager teamManager = gameManager.getTeam(player);

        if (teamManager.getScoreManager().getPlantManager().isLocated(location)) {

        }
    }
}
