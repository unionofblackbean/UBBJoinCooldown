package asia.ubb.ubbjoincooldown.services;

import org.bukkit.entity.Player;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public class CooldownService {

    private static Map<UUID, LocalDateTime> playerOfflineTimeMap;

    public static void setPlayerOfflineTime(Player player, LocalDateTime dateTime) {
        playerOfflineTimeMap.put(player.getUniqueId(), dateTime);
    }

    public static LocalDateTime getPlayerOfflineTime(Player player) {
        return playerOfflineTimeMap.get(player.getUniqueId());
    }

    public static void removePlayerOfflineTime(Player player) {
        playerOfflineTimeMap.remove(player.getUniqueId());
    }

}
