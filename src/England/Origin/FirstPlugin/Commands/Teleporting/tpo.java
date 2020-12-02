package England.Origin.FirstPlugin.Commands.Teleporting;

import England.Origin.FirstPlugin.Data.Back;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by josep on 24/01/2017.
 */
public class tpo implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("tpo")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +"This command can only be run by a player!");
                return true;
            }
            if (args.length == 1) {
                if (sender.hasPermission("<FP>.tpo")) {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (target == null) {
                    sender.sendMessage(ChatColor.AQUA + args[0 ] + " is not online!");
                    return false;
                }
                    Back.backsave(((Player) sender).getPlayer());
                    ((Player) sender).teleport(new Location(Bukkit.getWorld(target.getLocation().getWorld().getName()), target.getLocation().getBlockX(), target.getLocation().getBlockY()
                            , target.getLocation().getBlockZ(), target.getLocation().getYaw(), target.getLocation().getPitch()));
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "You do not have permission to do this!");
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "Incorrect arguments! /tpo [PlayerName]");
            }
        }
        return false;
    }
}


