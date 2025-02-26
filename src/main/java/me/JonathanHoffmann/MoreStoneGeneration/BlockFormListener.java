package me.JonathanHoffmann.MoreStoneGeneration;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFormEvent;

public class BlockFormListener implements Listener {
    public final String FORMDEEPSLATEBELOW0_EXPLANATION = "Replace Stone with Deepslate and Cobblestone with Cobbled Deepslate generation below Y0 in the Overworld";
    public final String REPLACE_BASALT_WITH_TUFF_EXPLANATION = "Replace Basalt with Tuff generation in the Overworld";
    public final String CONVERT_STONE_AND_COBBLE_TO_ENDSTONE_EXPLANATION = "Replace Stone and Cobblestone with Endstone generation in the End";

    private final MoreStoneGeneration plugin;

    public BlockFormListener(MoreStoneGeneration plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockForm(BlockFormEvent event) {
        Block block = event.getBlock();
        World world = block.getWorld();
        Material newMaterial = event.getNewState().getType();

        // Overworld transformations
        if (world.getEnvironment() == World.Environment.NORMAL) {
            if (block.getY() <= 0 && plugin.getConfig().getBoolean(FORMDEEPSLATEBELOW0_EXPLANATION, true)) {
                if (newMaterial == Material.STONE) {
                    event.setCancelled(true);
                    block.setType(Material.DEEPSLATE);
                } else if (newMaterial == Material.COBBLESTONE) {
                    event.setCancelled(true);
                    block.setType(Material.COBBLED_DEEPSLATE);
                }
            } else if (newMaterial == Material.BASALT) {
                if (plugin.getConfig().getBoolean(REPLACE_BASALT_WITH_TUFF_EXPLANATION, true)) {
                    event.setCancelled(true);
                    block.setType(Material.TUFF);
                }
            }
        }

        // End transformations
        else if (world.getEnvironment() == World.Environment.THE_END) {
            if (newMaterial == Material.STONE || newMaterial == Material.COBBLESTONE) {
                if (plugin.getConfig().getBoolean(CONVERT_STONE_AND_COBBLE_TO_ENDSTONE_EXPLANATION, true)) {
                    event.setCancelled(true);
                    block.setType(Material.END_STONE);
                }
            }
        }
    }
}
