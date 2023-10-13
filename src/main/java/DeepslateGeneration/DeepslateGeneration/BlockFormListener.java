package DeepslateGeneration.DeepslateGeneration;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFormEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CompassMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class BlockFormListener implements Listener {

    private Main m;

    public BlockFormListener(Main m) {
        this.m = m;
    }

    @EventHandler
    public boolean onBlockForm(BlockFormEvent e) {
        boolean changeToDeepslate = false;
        Block b = e.getBlock();

        //Check if Blocktransform is eligable
        if (!(e.getNewState().getType().equals(Material.STONE) || e.getNewState().getType().equals(Material.COBBLESTONE))) {
            return false;
        }

        //Check for if block below is deepslate
        if (m.GetFORMABOVEDEEPSLATE()) {
            Location b_loc = b.getLocation().clone();
            b_loc.setY(b_loc.getY() - 1);
            Block below = b_loc.getBlock();
            if (below.getType().equals(Material.DEEPSLATE)) {
                changeToDeepslate = true;
            }
        }

        //check for height
        if (b.getY() < m.GetFORMBELOW0()) {
            changeToDeepslate = true;
        }

        //if one of previous checks was valid, cancel event and make it deepslate
        if(changeToDeepslate)
        {
            e.setCancelled(true);
            b.setType(Material.DEEPSLATE);
            return true;
        }
        return false;
    }
}

