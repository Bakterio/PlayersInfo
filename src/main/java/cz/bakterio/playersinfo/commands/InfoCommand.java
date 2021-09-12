package cz.bakterio.playersinfo.commands;

import cz.bakterio.playersinfo.GUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class InfoCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;

            p.openInventory(GUI.mainMenu(p));
        }

        return true;
    }
}
