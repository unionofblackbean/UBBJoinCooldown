package asia.ubb.ubbjoincooldown.listeners;

import asia.ubb.ubbjoincooldown.services.CooldownService;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.time.LocalDateTime;

public class PlayerQuitEventListener implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        if (CooldownService.getPlayerOfflineTime(event.getPlayer()) == null)
            CooldownService.setPlayerOfflineTime(event.getPlayer(), LocalDateTime.now());
    }

}
