package England.Origin.FirstPlugin.Player;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by josep on 27/05/2017.
 */
public class Freeze implements Listener{

    public static ArrayList<UUID> Frozen = new ArrayList<UUID>();

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {

        if (Frozen.contains(event.getPlayer().getUniqueId())) {
            event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f") + ChatColor.RED + "You are frozen and unable to move!");
            event.setCancelled(true);
        }

    }

}