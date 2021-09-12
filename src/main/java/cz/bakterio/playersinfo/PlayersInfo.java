package cz.bakterio.playersinfo;

import cz.bakterio.playersinfo.commands.InfoCommand;
import cz.bakterio.playersinfo.events.OnClickEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlayersInfo extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("players").setExecutor(new InfoCommand());
        getServer().getPluginManager().registerEvents(new OnClickEvent(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
