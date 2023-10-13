package DeepslateGeneration.DeepslateGeneration;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public final String FORMABOVEDEEPSLATE="Create when Deepslate below forming block";
    public final String FORMBELOW0= "Create when the forming block is below";
    @Override
    public void onEnable() {
        loadConfig();
        Bukkit.getPluginManager().registerEvents(new BlockFormListener(this), this);
    }

    public void loadConfig() {
        getConfig().addDefault(FORMABOVEDEEPSLATE, true);
        getConfig().addDefault(FORMBELOW0, 0);
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    public boolean GetFORMABOVEDEEPSLATE () {
        reloadConfig();
        return getConfig().getBoolean(FORMABOVEDEEPSLATE);
    }
    public int GetFORMBELOW0 () {
        reloadConfig();
        return getConfig().getInt(FORMBELOW0);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
