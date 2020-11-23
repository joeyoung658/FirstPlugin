package England.Origin.FirstPlugin.Player;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by josep on 05/07/2017.
 */
public class DenyBlockBreak implements Listener {

    public static ArrayList<Player> DenyBlockBreak = new ArrayList<>();

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {

        if (DenyBlockBreak.contains(event.getPlayer())) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', "&e[&4Server&e]&f ") + ChatColor.RED + "You can't place/break blocks within this event.");
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (DenyBlockBreak.contains(event.getPlayer())){
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', "&e[&4Server&e]&f ") + ChatColor.RED + "You can't place/break blocks within this event.");
        }
    }
}