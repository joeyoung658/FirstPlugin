package England.Origin.FirstPlugin.Commands.Player;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Joes_room on 13/12/2016.
 */
public class heal implements CommandExecutor {


    @Override
        public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {

            if (alias.equalsIgnoreCase("heal")) {
                if (args.length == 0) {
                    if (sender.hasPermission("<FP>.heal")) {
                        if (!(sender instanceof Player)) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +"This command can only be run by a player!");
                            return true;
                        } else {
                            Player player = (Player) sender;
                            player.setHealth(20.0);
                            player.setFoodLevel(20);
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "You have been healed");
                            return true;
                        }
                    } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "You do not have permission to use this command!");
                    }
                } else if (args.length == 1) {
                    if (sender.hasPermission("<FP>.aheal")) {
                        Player target = Bukkit.getPlayerExact(args[0]);
                        if (target == null) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "Your target " + args[0] + " is not online!");
                        } else {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You've healed " + args[0]);
                            target.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "You've been healed by an Admin!");
                            target.setHealth(20.0);
                            target.setFoodLevel(20);
                        }
                    }else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "You do not have permission to use this command!");
                    }
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "Incorrect arguments! /heal");
                }
            }
        return true;
        }
    }


