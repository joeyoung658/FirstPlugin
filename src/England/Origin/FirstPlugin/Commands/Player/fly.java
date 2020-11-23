package England.Origin.FirstPlugin.Commands.Player;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Joes_room on 07/12/2016.
 */

public class fly implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("fly")) {
            if (args.length == 0) {
                if (!(sender instanceof Player)) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") + "This command can only be run by a player!");
                    return true;
                } else {
                    if (sender.hasPermission("<FP>.fly")) {
                        Player player = (Player) sender;
                        if (player.getAllowFlight() == true) {
                            player.setAllowFlight(false);
                            player.setFlying(false);
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "Fly mode has been disabled!");
                            return true;
                        } else {
                            player.setAllowFlight(true);
                            player.setFlying(true);
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "Fly mode has been enabled!");
                            return true;
                        }
                    } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "You do not have permission to use this command!");
                    }
                }
            } else if (args.length == 1) {
                if (sender.hasPermission("<FP>.afly")) {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if (target == null) { //if player isnt online
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.DARK_RED + args[0] + " is not online!");
                    } else {
                        // if (args[0].equalsIgnoreCase("on")) {
                        if (target.getAllowFlight() == true) {
                            target.setAllowFlight(false);
                            target.setFlying(false);
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "Fly mode has been disabled for " + target.getDisplayName());
                            target.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "Fly mode has been disabled by an Admin!");
                            return true;
                        } else {
                            target.setAllowFlight(true);
                            target.setFlying(true);
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "Fly mode has been enabled for " + target.getDisplayName());
                            target.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "Fly mode has been enabled by an Admin!");
                            return true;
                        }

                    }
                }else{
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "You do not have permission to use this command!");
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "Incorrect arguments! /fly");
                return true;
            }
        }
        return true;
    }
}
