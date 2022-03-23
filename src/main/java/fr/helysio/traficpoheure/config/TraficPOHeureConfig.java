package fr.helysio.traficpoheure.config;

import fr.helysio.gamemanager.config.AbstractConfig;
import fr.helysio.gamemanager.config.items.IConfigItem;
import fr.helysio.gamemanager.game.IGameManager;

import java.util.List;

public class TraficPOHeureConfig extends AbstractConfig {

    public TraficPOHeureConfig(IGameManager gameManager) {
        super(gameManager);
    }

    @Override
    public List<IConfigItem> setItems(IGameManager gameManager) {

        List<IConfigItem> previous = super.setItems(gameManager);

        return previous;
    }
}
