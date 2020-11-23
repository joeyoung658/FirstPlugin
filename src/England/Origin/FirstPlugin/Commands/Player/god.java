package England.Origin.FirstPlugin.Commands.Player;

import England.Origin.FirstPlugin.Data.ChangeData;
import England.Origin.FirstPlugin.Data.PlayerNameData;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Joes_room on 12/12/2016.
 */

public class god implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("god")) {
            if (args.length == 0) {
                if (!(sender instanceof Player)) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +"This command can only be run by a player!");
                    return true;
                } else {
                    if (sender.hasPermission("<FP>.god")) {
                        Player player = (Player) sender;
                        if (!(PlayerNameData.filegetdata(((Player) sender), "god") == null)) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You have disabled god mode!");
                            ChangeData.changedatac(((Player) sender), "god", null);
                            player.setInvulnerable(false);
                            return true;
                        } else {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "God mode has been enabled!");
                            ChangeData.changedatac(((Player) sender), "god", "true");
                            player.setInvulnerable(true);
                            return true;
                        }
                    } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "You do not have permission to use this command!");
                    }
                }
            } else if (args.length == 1) {
                if (sender.hasPermission("<FP>.agod")) {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if (target == null) { //if player isnt online
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.DARK_RED + args[0] + " is not online!");
                    } else {
                        if (!(PlayerNameData.filegetdata(target, "god") == null)) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "God mode has been disabled for "  + target.getDisplayName());
                            target.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "God mode has been disabled by an Admin!");
                            ChangeData.changedatac(target, "god", null);
                            target.setInvulnerable(false);
                            return true;
                        } else {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "God mode has been enabled for "  + target.getDisplayName());
                            target.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "God mode has been enabled by an Admin!");
                            ChangeData.changedatac(target, "god", "true");
                            target.setInvulnerable(true);
                            return true;
                        }
                    }
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "You do not have permission to use this command!");
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "Incorrect arguments! /God");
                return true;
            }
        }
        return true;
    }
}
