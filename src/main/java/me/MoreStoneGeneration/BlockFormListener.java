package me.MoreStoneGeneration;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFormEvent;

public class BlockFormListener implements Listener {

    private final Main plugin;

    public BlockFormListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockForm(BlockFormEvent event) {
        Block block = event.getBlock();
        World world = block.getWorld();
        Material newMaterial = event.getNewState().getType();
        
        // Overworld transformations
        if (world.getEnvironment() == World.Environment.NORMAL) {
            if (block.getY() <= 0 && plugin.getConfig().getBoolean("replaceStoneDeepslateBelow0", true)) {
                if (newMaterial == Material.STONE) {
                    event.setCancelled(true);
                    block.setType(Material.DEEPSLATE);
                } else if (newMaterial == Material.COBBLESTONE) {
                    event.setCancelled(true);
                    block.setType(Material.COBBLED_DEEPSLATE);
                }
            } else if (newMaterial == Material.BASALT) {
                if (plugin.getConfig().getBoolean("replaceBasaltWithTuff", true)) {
                    event.setCancelled(true);
                    block.setType(Material.TUFF);
                }
            }
        }
        
        // End transformations
        else if (world.getEnvironment() == World.Environment.THE_END) {
            if (newMaterial == Material.STONE || newMaterial == Material.COBBLESTONE) {
                if (plugin.getConfig().getBoolean("convertStoneAndCobbleToEndstone", true)) {
                    event.setCancelled(true);
                    block.setType(Material.END_STONE);
                }
            }
        }
    }
}
