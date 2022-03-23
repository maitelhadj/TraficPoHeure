package fr.helysio.traficpoheure;

import fr.helysio.traficpoheure.game.TraficPOHeureGameManager;
import fr.helysio.traficpoheure.guis.TraficPOHeureConfigGui;
import fr.helysio.traficpoheure.listeners.TraficPOHeureListener;
import fr.helysio.traficpoheure.scoreboards.TraficPOHeureScoreBoard;
import org.bukkit.plugin.java.JavaPlugin;

public class TraficPOHeure extends JavaPlugin {

    private TraficPOHeure instance;

    public void enable() {
        instance = this;



        ServeurStart();
    }

    public void ServeurStart() {
        this.getLogger().info("!==================================================!");
        this.getLogger().info("||                                                ||");
        this.getLogger().info("||        Plugin TraficPOHeure démarré !          ||");
        this.getLogger().info("||                                                ||");
        this.getLogger().info("!==================================================!");
    }

    public TraficPOHeureGameManager getGameManager() {
        return new TraficPOHeureGameManager(this);
    }

    public TraficPOHeureScoreBoard getBoardManager() {
        return new TraficPOHeureScoreBoard();
    }

    public TraficPOHeureConfigGui getConfigGui() {
        return new TraficPOHeureConfigGui();
    }

    public TraficPOHeure getTraficInstance() {
        return instance;
    }
}
