package fr.helysio.traficpoheure.listeners;

import fr.helysio.traficpoheure.game.TraficPOHeureGameManager;
import org.bukkit.event.Listener;

public class TraficPOHeureListener implements Listener {

    /*
     *  FIELDS
     */

    private TraficPOHeureGameManager gameManager;

    /*
     *  CONSTRUCTOR
     */

    public TraficPOHeureListener(TraficPOHeureGameManager gameManager) {

        this.gameManager = gameManager;
    }
}