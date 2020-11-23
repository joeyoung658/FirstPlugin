package England.Origin.FirstPlugin.Commands.Admin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by josep on 07/01/2017.
 */
public class getuuid implements CommandExecutor {
    @SuppressWarnings("deprecation")
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {



        if (label.equalsIgnoreCase("getuuid")) {
            if (sender.hasPermission("<FP>.getuuid")) {
                if (args.length == 1) {

                    Player target = Bukkit.getPlayerExact(args[0]);

                    if (!(target == null)) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "The players ID is - " + target.getUniqueId().toString());
                        return true;
                    }

                    OfflinePlayer otarget = Bukkit.getOfflinePlayer(args[0]);

                    if (!(otarget == null)) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "The players ID is - " + otarget.getUniqueId().toString());
                        return true;
                    }
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + args[0] + " has never joined the server before!");


                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "Incorrect arguments! /getuuid [PlayerName]");
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "This is a staff only commands!");
            }
        }


        return true;
    }
}
