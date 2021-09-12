package cz.bakterio.playersinfo;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.LinkedList;

public class GUI {

    public static Inventory mainMenu(Player p) {
        ArrayList<Player> onlinePlayers = new ArrayList<>(p.getServer().getOnlinePlayers());
        Inventory inv = Bukkit.createInventory(p, 54, "Players:");

        for (Player i : onlinePlayers) {
            ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(i.getDisplayName());

            LinkedList<String> lore = new LinkedList<>();
            lore.add("Health: " + ChatColor.RED + i.getHealth() + ChatColor.RESET);
            lore.add("Level: " + ChatColor.AQUA + i.getLevel() + ChatColor.RESET);
            meta.setLore(lore);

            item.setItemMeta(meta);
            inv.addItem(item);
        }

        return inv;
    }

    public static Inventory playerInfo(Player p, Player infoPlayer) {
        Inventory inv = Bukkit.createInventory(p, 54, "Player info:");

        ItemStack helmet = infoPlayer.getInventory().getHelmet();
        ItemStack chectplate = infoPlayer.getInventory().getChestplate();
        ItemStack leggins = infoPlayer.getInventory().getLeggings();
        ItemStack shoes = infoPlayer.getInventory().getBoots();

        int index = 15;
        for (ItemStack i : new ItemStack[]{helmet, chectplate, leggins, shoes}) {
            if (i == null)
                inv.setItem(index, newItem(Material.BARRIER, ChatColor.RED + "None :("));
            else
                inv.setItem(index, i);

            index += 9;
        }

        ItemStack health = newItem(Material.REDSTONE_WIRE, "Health: " + ChatColor.RED + infoPlayer.getHealth());
        ItemStack level = newItem(Material.EXPERIENCE_BOTTLE, "Level: " + ChatColor.AQUA + infoPlayer.getLevel(),
                "Ex: " + ChatColor.AQUA + infoPlayer.getExp() + ChatColor.RESET);
        ItemStack world = newItem(Material.GRASS_BLOCK, "World: " + ChatColor.GREEN + infoPlayer.getWorld().getName());
        ItemStack ping = newItem(Material.ARROW, "Ping: " + ChatColor.RED + infoPlayer.getPing());

        index = 10;
        System.out.println("health = " + health);
        for (ItemStack i : new ItemStack[]{health, level, world, ping}) {
            inv.setItem(index, i);
            index += 9;
        }

        ItemStack player = newItem(Material.PLAYER_HEAD, "Player: " + ChatColor.RED + infoPlayer.getDisplayName());
        inv.setItem(2, player);

        return inv;
    }

    private static ItemStack newItem(Material material, String name) {
        ItemStack item = new ItemStack(material);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(name);
        item.setItemMeta(itemMeta);

        return item;
    }

    private static ItemStack newItem(Material material, String name, String lore) {
        ItemStack item = new ItemStack(material);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(name);

        ArrayList<String> l = new ArrayList<>();
        l.add(lore);
        itemMeta.setLore(l);
        item.setItemMeta(itemMeta);

        return item;
    }
}
