package asia.ubb.ubbjoincooldown;

import asia.ubb.ubbjoincooldown.listeners.PlayerJoinEventListener;
import asia.ubb.ubbjoincooldown.listeners.PlayerQuitEventListener;
import asia.ubb.ubbjoincooldown.utils.TimeUtils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class UBBJoinCooldownPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        FileConfiguration config = getConfig();
        String cooldownTimeString = config.getString("cooldown");

        long cooldownSecond;
        if (cooldownTimeString != null)
            cooldownSecond = TimeUtils.parseSecond(cooldownTimeString);
        else
            cooldownSecond = 10;

        getServer().getPluginManager().registerEvents(new PlayerJoinEventListener(cooldownSecond), this);
        getServer().getPluginManager().registerEvents(new PlayerQuitEventListener(), this);
    }

}
