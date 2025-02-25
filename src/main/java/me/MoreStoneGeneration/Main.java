package me.MoreStoneGeneration;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public final String FORMDEEPSLATEBELOW0_EXPLANATION="Replace Stone with Deepslate and Cobblestone with Cobbled Deepslate generation below Y0 in the Overworld";
    public final String FORMDEEPSLATEBELOW0 = "replaceStoneDeepslateBelow0";
    
    public final String REPLACE_BASALT_WITH_TUFF_EXPLANATION = "Replace Basalt with Tuff generation in the Overworld";
    public final String REPLACE_BASALT_WITH_TUFF = "replaceBasaltWithTuff";
    
    public final String CONVERT_STONE_AND_COBBLE_TO_ENDSTONE_EXPLANATION = "Replace Stone and Cobblestone with Endstone generation in the End";
    public final String CONVERT_STONE_AND_COBBLE_TO_ENDSTONE = "convertStoneAndCobbleToEndstone";

    @Override
    public void onEnable() {
        loadConfig();
        Bukkit.getPluginManager().registerEvents(new BlockFormListener(this), this);
    }

    public void loadConfig() {
        getConfig().addDefault(FORMDEEPSLATEBELOW0, true);
        getConfig().addDefault(REPLACE_BASALT_WITH_TUFF, true);
        getConfig().addDefault(CONVERT_STONE_AND_COBBLE_TO_ENDSTONE, true);
        
        getConfig().addDefault(FORMDEEPSLATEBELOW0 + "_description", FORMDEEPSLATEBELOW0_EXPLANATION);
        getConfig().addDefault(REPLACE_BASALT_WITH_TUFF + "_description", REPLACE_BASALT_WITH_TUFF_EXPLANATION);
        getConfig().addDefault(CONVERT_STONE_AND_COBBLE_TO_ENDSTONE + "_description", CONVERT_STONE_AND_COBBLE_TO_ENDSTONE_EXPLANATION);
        
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
