package fr.helysio.traficpoheure;

import fr.helysio.traficpoheure.managers.PlantManager;
import fr.helysio.traficpoheure.managers.TeamManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

import static org.bukkit.Bukkit.getServer;

public class PointCounter extends BukkitRunnable {

    private TraficPOHeure main;
    private PlantManager plantManager;
    private ArrayList<TeamManager> teams;
    
    public PointCounter(TraficPOHeure main, PlantManager plantManager, ArrayList<TeamManager> teams) {
        this.main = main;
        this.plantManager = plantManager;
        this.teams = teams;
    }

    @Override
    public void run() {
//        runTaskTimer(this.main, 0, 100);
        for (TeamManager team : teams) {
            team.getScoreManager().updateScore();
        }
    }


}
