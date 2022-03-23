package fr.helysio.traficpoheure.game;

import fr.helysio.traficpoheure.TraficPOHeure;
import fr.helysio.traficpoheure.generators.MerchantGenerator;
import fr.helysio.traficpoheure.generators.PlantGenerator;
import fr.helysio.traficpoheure.managers.CrownManager;
import fr.helysio.traficpoheure.managers.TeamManager;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.List;

public class TraficPOHeureGameManager {

    private TraficPOHeure instance;
    private World world;

    private PlantGenerator plantGenerator;
    private MerchantGenerator merchantGenerator;

    private List<TeamManager> teams;
    private CrownManager crown;

    public TeamManager getTeam(Player player) {
        return null;
    }
}
