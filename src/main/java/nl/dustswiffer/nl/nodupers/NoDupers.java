package nl.dustswiffer.nl.nodupers;

import nl.dustswiffer.nl.nodupers.commands.NoDupersCommand;
import nl.dustswiffer.nl.nodupers.events.BlockPlaceListener;
import nl.dustswiffer.nl.nodupers.events.CreativeInventoryListener;
import nl.dustswiffer.nl.nodupers.events.RightClickListener;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class NoDupers extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Created by Dustswiffer");
        getServer().getPluginManager().registerEvents(new RightClickListener(this), this);
        getServer().getPluginManager().registerEvents(new CreativeInventoryListener(this), this);
        getServer().getPluginManager().registerEvents(new BlockPlaceListener(this), this);

        getCommand("nodupers").setExecutor(new NoDupersCommand(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void notifyStaff(String checkTriggered, String stinky){

        for (Player player : getServer().getOnlinePlayers()) {
            if (player.isOp() || player.hasPermission("nodupers.notify")) {
                player.sendMessage(ChatColor.RED.toString() + ChatColor.BOLD.toString() + "IMPORTANT! " + ChatColor.RESET.toString() + stinky + " may have attempted to dupe with " + checkTriggered + ".");
            }
    }
}

        }