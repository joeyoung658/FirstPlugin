package England.Origin.FirstPlugin.Commands.Teleporting;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static England.Origin.FirstPlugin.Commands.Teleporting.tpa.tparequests;
import static England.Origin.FirstPlugin.Commands.Teleporting.tpahere.tpahererequests;

/**
 * Created by josep on 24/01/2017.
 */



public class tpdeny implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("tpdeny")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +"This command can only be run by a player!");
                return true;
            }
//            if (!(sender.hasPermission("<FP>.tpa"))) {
//                sender.sendMessage(ChatColor.RED + "Please use /trigger in order to request to teleport to another player!");
//                return false;
//            }
            if (args.length == 0) {
                if (tparequests.containsKey(sender) || tpahererequests.containsKey(sender)) {

                    if (tpahererequests.containsKey(sender) && tparequests.containsKey(sender)) {
                        tpahererequests.remove(sender);
                        tparequests.remove(sender);
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You have denied the tpa request!");
                    }

                    if (tpahererequests.containsKey(sender)) {
                        tpahererequests.remove(sender);
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You have denied the tpa request!");
                    }
                    if (tparequests.containsKey(sender)) {
                        tparequests.remove(sender);
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You have denied the tpa request!");
                    }
                    return false;
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You have no teleport requests pending!");
                    return false;
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "Incorrect arguments! /tpdeny");
            }
        }
        return false;
    }
}