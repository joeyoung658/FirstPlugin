package England.Origin.FirstPlugin.Commands.Teleporting;

import England.Origin.FirstPlugin.Data.PlayerNameData;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by josep on 24/01/2017.
 */
public class tpahere implements CommandExecutor {

    public static Map<Player, Player> tpahererequests = new HashMap<>();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("tpahere")) {
//            if (!(sender.hasPermission("<FP>.tpa"))) {
//                sender.sendMessage(ChatColor.RED + "Please use /trigger in order to request to teleport to another player!");
//                return false;
//            }
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +"This command can only be run by a player!");
                return true;
            }
            if (args.length == 1) {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (target == null) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "Player is not online!");
                    return false;
                }
                if (!(PlayerNameData.filegetdata(target, "tptoggle") == null)) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "This player has teleport requests disabled!");
                    return false;
                }

                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You have requested " + target.getDisplayName() + ChatColor.AQUA + " to teleport to you!");
                target.sendMessage(((Player) sender).getDisplayName() +  ChatColor.AQUA +  " has requested for you to teleport to them!"  + ChatColor.RED + " Type /tpyes to accept the request.");

                if (tpahererequests.containsKey(target)) {
                    tpahererequests.remove(target);
                    tpahererequests.put(target, ((Player) sender));
                } else {
                    tpahererequests.put(target, ((Player) sender));
                }





            } else {
                sender.sendMessage(ChatColor.RED + "Incorrect arguments! /tpa [PlayerName]");
            }
        }
        return false;
    }
}
