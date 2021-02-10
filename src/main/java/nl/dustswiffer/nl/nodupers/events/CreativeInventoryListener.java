package nl.dustswiffer.nl.nodupers.events;

import nl.dustswiffer.nl.nodupers.NoDupers;
import org.bukkit.ChatColor;
import org.bukkit.block.ShulkerBox;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class CreativeInventoryListener implements Listener {
    private final NoDupers plugin;

    public CreativeInventoryListener(NoDupers plugin) {
        this.plugin = plugin;
    }


    @EventHandler(priority = EventPriority.HIGHEST)
    public void onItemMoveInventory(InventoryClickEvent event) {
        final InventoryHolder inventoryHolder = event.getInventory().getHolder();

        if(inventoryHolder instanceof ShulkerBox){
            final HumanEntity  humanEntity = event.getWhoClicked();
            final ItemStack item = event.getCurrentItem();
            if( item != null && item.getType().name().equals("PAPER") && item.getItemMeta().hasLore() && item.getItemMeta().getDisplayName().contains("Banknote") && item.getItemMeta().getLore().get(0).contains("$") && item.getItemMeta().getLore().get(1).contains("Withdrawn by")){
                if(!humanEntity.isOp()){
                    plugin.notifyStaff("shulker fill dupe", humanEntity.getName());
                    humanEntity.sendMessage(ChatColor.RED.toString() + ChatColor.BOLD.toString() + "You are not allowed to interact with this item within this container!");
                    event.setResult(Event.Result.DENY);
                }
            }
        }
    }
}
