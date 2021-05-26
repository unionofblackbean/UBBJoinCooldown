package asia.ubb.ubbjoincooldown.listeners;

import asia.ubb.ubbjoincooldown.services.CooldownService;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class PlayerJoinEventListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        LocalDateTime playerOfflineTime = CooldownService.getPlayerOfflineTime(player);
        if (playerOfflineTime.until(LocalDateTime.now(), ChronoUnit.SECONDS) >= 30) {
            CooldownService.removePlayerOfflineTime(event.getPlayer());
        } else {
            player.kickPlayer("Please wait 30 seconds before joining the server again!");
        }
    }

}
