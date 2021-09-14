package cz.bakterio.playersinfo;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class PlayersTasks {

    private static void teleportToPlayer(Player teleportedPlayer, Player playerToTeleport) {
        teleportedPlayer.teleport(playerToTeleport.getLocation());
        System.out.println("Location:" + playerToTeleport.getLocation().getDirection().getBlockX() + " " + playerToTeleport.getLocation().getDirection().getBlockY() + " " + playerToTeleport.getLocation().getDirection().getBlockZ());
        teleportedPlayer.sendMessage("You has been teleported to " + ChatColor.YELLOW + playerToTeleport.getDisplayName() + ".");
        playerToTeleport.sendMessage(ChatColor.YELLOW + teleportedPlayer.getDisplayName() + ChatColor.RESET + " has been teleported to you.");
    }

    public static void teleportToPlayer(Player teleportedPlayer, Player playerToTeleport, boolean check) {
        if (check) {
            if (!teleportedPlayer.hasPermission("playersinfo.teleport")){
                teleportedPlayer.sendMessage("You don't have " + ChatColor.BOLD + "permissions" + ChatColor.RESET + " to teleport players / teleport to another player.");
                return;
            }
        }

        teleportToPlayer(teleportedPlayer, playerToTeleport);
    }

    public static void sendPrivateMessage(Player sender, Player target, String message) {
        target.sendMessage(ChatColor.YELLOW + sender.getDisplayName() + ": " + ChatColor.RESET + message);
    }

}
