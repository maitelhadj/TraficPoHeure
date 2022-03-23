package fr.helysio.traficpoheure.admin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerSpawn implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String receiver, String[] strings) {

        // On verifie que c'est bien un joueur qui execute la commande.
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cSeul un joueur peut executer cette commande !");
            return false;
        }

        Player player = (Player) sender;

        if(!player.hasPermission("admin")) {
            sender.sendMessage("§cSeul un administrateur peut executer cette commande !");
            return false;
        }

        if (receiver.equalsIgnoreCase("setspawn")) {
            if
        }



        return false;
    }
}
