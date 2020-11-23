package England.Origin.FirstPlugin.Commands.Admin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


//todo migrate to Permissions sytem?

/**
 * Created by josep on 16/01/2017.
 */
public class fakejoinleave implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("fake")) {
            if (sender.hasPermission("<FP>.fake")) {
            if (args.length == 1) {
                if (!(sender instanceof Player)) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +"This command can only be run by a player!");
                    return true;
                }

                    if (args[0].equalsIgnoreCase("leave")) {

                        Bukkit.broadcastMessage((ChatColor.translateAlternateColorCodes('&', "&7[&4-&7] ")+  ((Player) sender).getDisplayName()) + ChatColor.RED + " disconnected!");


                        return false;
                    } else if (args[0].equalsIgnoreCase("join")) {
                        Bukkit.broadcastMessage((ChatColor.translateAlternateColorCodes('&', "&7[&a+&7] ")+  ((Player) sender).getDisplayName()) + ChatColor.GREEN + " joined!");

                        return false;
                    } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "Incorrect arguments! /fake [Join/Leave]");
                        return false;
                    }


                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "Incorrect arguments! /fake [Join/Leave]");
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "This ia  moderator + only command!");
            }

        }


        return true;
    }
}
