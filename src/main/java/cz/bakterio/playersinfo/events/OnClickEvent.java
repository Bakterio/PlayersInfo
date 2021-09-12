package cz.bakterio.playersinfo.events;

import cz.bakterio.playersinfo.GUI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class OnClickEvent implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getView().getTitle().equalsIgnoreCase("Players:")) {
            Material item = e.getCurrentItem().getType();
            Player p = (Player) e.getWhoClicked();

            if (item.equals(Material.PLAYER_HEAD)) {
                p.openInventory(GUI.playerInfo(p, Bukkit.getPlayer(e.getCurrentItem().getItemMeta().getDisplayName())));
            }

            e.setCancelled(true);
        } else if (e.getView().getTitle().equalsIgnoreCase("Player info:")) {
            e.setCancelled(true);
        }
    }
}
