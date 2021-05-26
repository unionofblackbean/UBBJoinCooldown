package asia.ubb.ubbjoincooldown;

import asia.ubb.ubbjoincooldown.listeners.PlayerJoinEventListener;
import asia.ubb.ubbjoincooldown.listeners.PlayerQuitEventListener;
import org.bukkit.plugin.java.JavaPlugin;

public class UBBJoinCooldownPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerJoinEventListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerQuitEventListener(), this);
    }

}
