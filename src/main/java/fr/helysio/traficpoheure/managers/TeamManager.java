package fr.helysio.traficpoheure.managers;

import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TeamManager {

    private AtomicInteger aid = new AtomicInteger(0);
    private final int id;
    private List<Player> players;
    private ScoreManager scoreManager;
    private MerchantManager merchantManager;

    public TeamManager(List<Player> players, ScoreManager scoreManager, MerchantManager merchantManager) {
        this.id = aid.incrementAndGet();
        this.players = players;
        this.scoreManager = scoreManager;
        this.merchantManager = merchantManager;
    }

    public void setScoreManager(ScoreManager scoreManager) {
        this.scoreManager = scoreManager;
    }

    public void setMerchantManager(MerchantManager merchantManager) {
        this.merchantManager = merchantManager;
    }

    public int getId() {
        return this.id;
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public ScoreManager getScoreManager() {
        return this.scoreManager;
    }

    public MerchantManager getMerchantManager() {
        return this.merchantManager;
    }

    public double getScore() {
        return scoreManager.getScore();
    }

    public boolean isMember(Player player) {
        return players.contains(player);
    }
}
