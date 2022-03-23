package fr.helysio.traficpoheure.scoreboards;

import fr.helysio.api.HelysioAPI;
import fr.helysio.gamemanager.game.GameState;
import fr.helysio.gamemanager.game.IGameManager;
import fr.helysio.gamemanager.scoreboards.AbstractGameBoardManager;
import fr.helysio.traficpoheure.players.TraficPOHeurePlayerData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class TraficPOHeureScoreBoard {

    /*
     *  CONSTRUCTOR
     */

    public TraficPOHeureScoreBoard() {

    }

    /*
     *  METHODS
     */

    public String getBoardName() {

        return "§6§lTraficPOHeure";
    }

    public String[] getLines(Player player) {

        if(this.gameManager.getGameState().equals(GameState.WAITING))
            return super.getLines(player);
        else {

            TraficPOHeurePlayerData playerData = (TraficPOHeurePlayerData) this.gameManager.getData(player);

            return new String[] {
                    HelysioAPI.getInstance().getServerInfo(),
                    " ",
                    "§7Joueurs : §a" + (Bukkit.getOnlinePlayers().size() - this.gameManager.getSpectators()),
                    " ",
                    "§eplay.helysio.fr"};
        }
    }
}