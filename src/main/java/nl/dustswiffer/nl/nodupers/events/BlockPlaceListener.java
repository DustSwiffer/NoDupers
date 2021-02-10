package nl.dustswiffer.nl.nodupers.events;

import nl.dustswiffer.nl.nodupers.NoDupers;
import org.bukkit.GameMode;
import org.bukkit.block.Block;
import org.bukkit.block.Container;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class BlockPlaceListener implements Listener {
    private final NoDupers plugin;

    public BlockPlaceListener(NoDupers plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {

        Player player = event.getPlayer();

        if(player.getGameMode().equals(GameMode.CREATIVE)) {

            if(!player.hasPermission("nodupers.container.bypass")) {

                Block block = event.getBlockPlaced();
                if(block.getState() instanceof InventoryHolder) {
                    Inventory blockInventory = ((InventoryHolder)(block.getState())).getInventory();
                    blockInventory.clear();
                }
            }

        }


    }

}
