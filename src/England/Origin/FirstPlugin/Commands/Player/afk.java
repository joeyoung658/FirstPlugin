package England.Origin.FirstPlugin.Commands.Player;

import England.Origin.FirstPlugin.Data.PlayerNameData;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by josep on 27/01/2017.
 */
public class afk implements CommandExecutor, Listener {

    public static List<Player> afkplayers = new ArrayList<>();
    public static Map<Player, Location> afkcheck = new HashMap<>();


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("afk")) {
            if (args.length == 0) {
                if (!(sender instanceof Player)) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ")  +"This command can only be run by a player!");
                    return true;
                }
                Player player = (Player) sender;
                if (afkplayers.contains(player)) {
                    afkplayers.remove(player);
                    afkcheck.put(player, player.getLocation());
                    if (PlayerNameData.filegetdata(player, "vanish") == null) {
                        Bukkit.broadcastMessage(ChatColor.GRAY + "* " + player.getDisplayName() + ChatColor.GRAY + " is no longer afk!");
                    }
                    return true;
                } else {
                    afkplayers.add(player);
                    Bukkit.broadcastMessage(ChatColor.GRAY + "* " + player.getDisplayName() + ChatColor.GRAY + " is now afk!");
                    return true;
            }
        } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ")  +ChatColor.RED + "Incorrect arguments! /afk");
            }
        }
        return false;
    }


    @EventHandler
    public void PlayerMoveEvent(PlayerMoveEvent event) {
        afkremove(event.getPlayer());
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        afkremove(event.getPlayer());
    }



//    //Memory leak?
//    public static void isafk() {
//        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
//            @Override
//            public void run() {
//
//
//
//            }
//        }, 20l * 60 * 5);
//    }

    private void afkremove(Player player){
        if (afkplayers.contains(player)) {
            afkplayers.remove(player);
            if (afkcheck.containsKey(player)) {afkcheck.remove(player);}
            if (PlayerNameData.filegetdata(player, "vanish") == null) {
                Bukkit.broadcastMessage(ChatColor.GRAY + "* " + player.getDisplayName() + ChatColor.GRAY + " is no longer afk!");
            }
        }
    }
}