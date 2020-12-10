package England.Origin.FirstPlugin.Commands.Fun;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Joes_room on 07/12/2016.
 */

public class thor implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("thor")) {
            if (args.length == 1) {
//                if (!(sender instanceof Player)) {
//                    sender.sendMessage("This command can only be run by a player!");
//                    return true;
//                }
                if (sender.hasPermission("<FP>.thor")) {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if (target == null) { //if player isnt online
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.DARK_RED + args[0] + " is not online!");
                    } else {

                        World world = target.getWorld();
                        world.strikeLightning(target.getLocation());
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.YELLOW + "You've struck Thors wrath onto " + target.getDisplayName());

                    }
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "You do not have permission to use this command!");


                }

            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "Incorrect arguments! /thor [Playername]");
                return true;
            }
        }
        return true;
    }
}
