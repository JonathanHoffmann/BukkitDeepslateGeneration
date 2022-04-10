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

public class BlockFormListener implements Listener {

    private Main main;

    public BlockFormListener(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onBlockForm(BlockFormEvent e) {

        Block b = e.getBlock();
        //Bukkit.broadcastMessage(e.getNewState().getType().name() + " new state material");
        if (b.getType().equals(Material.STONE) || b.getType().equals(Material.COBBLESTONE)) {
        }
        if (b.getWorld().getEnvironment().equals(World.Environment.NORMAL)) {
            if (b.getY() < 0) {
                if(e.getNewState().getType().equals(Material.STONE)||e.getNewState().getType().equals(Material.COBBLESTONE))
                {
                    e.setCancelled(true);
                    //Bukkit.broadcastMessage("Canceling old event and creatung new.");
                    b.setType(Material.DEEPSLATE);

                    /*
                    //Dunno why, but Calling a new event didn't work.
                    BlockState bs = e.getNewState();
                    bs.setType(Material.DEEPSLATE);
                    BlockFormEvent newEvent = new BlockFormEvent(b,bs);
                    Bukkit.getServer().getPluginManager().callEvent(newEvent);
                    */
                }
            }
        }
    }
}
