package nl.dustswiffer.nl.nodupers.events;

import nl.dustswiffer.nl.nodupers.NoDupers;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

import org.bukkit.inventory.ItemStack;

import static org.bukkit.Bukkit.getServer;

public class RightClickListener implements Listener {
    private final NoDupers plugin;

    public RightClickListener(NoDupers plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onPlayerInteract(PlayerInteractAtEntityEvent event) {

        Player player =  event.getPlayer();
        Entity entity = event.getRightClicked();

        if ((player.getInventory().getItemInMainHand().getType().name().endsWith("SHULKER_BOX")) || (player.getInventory().getItemInMainHand().getType().name().equals("PAPER") && player.getInventory().getItemInMainHand().getItemMeta().hasLore() && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Banknote") && player.getInventory().getItemInMainHand().getItemMeta().getLore().get(0).contains("$") && player.getInventory().getItemInMainHand().getItemMeta().getLore().get(1).contains("Withdrawn by"))) {
            if(entity instanceof ItemFrame){

                player.sendMessage(ChatColor.RED.toString() + ChatColor.BOLD.toString() + "You are not allowed to put this item in a item frame");
                plugin.notifyStaff("item frame dupe", player.getDisplayName());
                getServer().getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
                    public void run() {

                        ItemStack itemInFrame = ((ItemFrame) entity).getItem();
                        player.getInventory().setItemInMainHand(itemInFrame);
                        ((ItemFrame) entity).setItem(null);
                    }
                }, 5L);
            }
        }

    }
}
