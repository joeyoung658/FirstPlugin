package England.Origin.FirstPlugin.Commands.Teleporting;

import England.Origin.FirstPlugin.Listeners.Back;
import England.Origin.FirstPlugin.Player.Teleporting;
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
public class tpayes implements CommandExecutor{


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("tpyes")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +"This command can only be run by a player!");
                return true;
            }
//            if (!(sender.hasPermission("<FP>.tpa"))) {
//                sender.sendMessage(ChatColor.RED + "Please use /trigger in order to request to teleport to another player!");
//                return false;
//            }
            if (args.length == 0) {
                if (tparequests.containsKey(sender)) {
                    Player tpato = tparequests.get(sender);
                    if (!(tpato.isOnline())) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You have no teleport requests pending!");
                        tparequests.remove(sender);
                        return false;
                    }
                    tparequests.remove(sender);
                    tpato.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +((Player) sender).getPlayer().getDisplayName() + ChatColor.AQUA +  " has accepted your teleport request!");
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You have accepted the teleport request! Please stand by.");

                    Back.backsave(tpato.getPlayer());

                    Teleporting.delay(tpato,((Player) sender).getLocation().getWorld().getName(), ((Player) sender).getLocation().getBlockX(),
                            ((Player) sender).getLocation().getBlockY(), ((Player) sender).getLocation().getBlockZ(),
                            ((Player) sender).getLocation().getYaw(), ((Player) sender).getLocation().getPitch());
                    if (tpahererequests.containsKey(sender)) {
                        tpahererequests.remove(sender);
                    }
                    return false;
                } else if (tpahererequests.containsKey(sender)) {
                    Player tpafrom = tpahererequests.get(sender);
                    if (!(tpafrom.isOnline())) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You have no teleport requests pending!");
                        tpahererequests.remove(sender);
                        return false;
                    }
                    tpahererequests.remove(sender);
                    tpafrom.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +((Player) sender).getDisplayName() + ChatColor.AQUA +  " has accepted your request for them to telport to you!");
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You have accepted the teleport request! Please stand by.");

                    Back.backsave(((Player) sender).getPlayer());

                    Teleporting.delay(((Player) sender),tpafrom.getLocation().getWorld().getName(), tpafrom.getLocation().getBlockX(),
                            tpafrom.getLocation().getBlockY(), tpafrom.getLocation().getBlockZ(),
                            tpafrom.getLocation().getYaw(), tpafrom.getLocation().getPitch());
                    if (tparequests.containsKey(sender)) {
                        tparequests.remove(sender);
                    }
                    return false;

                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You have no teleport requests pending!");
                    return false;
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "Incorrect arguments! /tpyes");
            }
        }
        return false;
    }
}
