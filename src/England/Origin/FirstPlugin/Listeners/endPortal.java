package England.Origin.FirstPlugin.Listeners;

import England.Origin.FirstPlugin.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.UUID;

import static England.Origin.FirstPlugin.Main.instance;

public class endPortal implements Listener {

    private final JavaPlugin plugin;

    public endPortal(JavaPlugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onPortalTravel(PlayerPortalEvent event){
        if (event.getCause() == PlayerTeleportEvent.TeleportCause.END_PORTAL){
            int toggle = plugin.getConfig().getInt("endToggle");
            if (toggle == 0) {
                event.setCancelled(true);
                Player player = event.getPlayer();
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        "&e[&4Server&e]&f ") + ChatColor.RED +
                        "The End is currently disabled!");
            }
        }
    }
}
