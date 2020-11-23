package England.Origin.FirstPlugin.Commands.Containers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


/**
 * Created by Joes_room on 14/12/2016.
 */
public class enderchest implements CommandExecutor {



    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("enderchest")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +"This command can only be run by a player!");
                return true;
            } else {
                Player player = (Player) sender;
                if (args.length == 0) {

                    if (sender.hasPermission("<FP>.enderchest")) {
                        player.openInventory(player.getEnderChest());
                        return true;
                    } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "This is a donator only command, use /donate to find out more!");
                        return true;
                    }
                } else if (args.length == 1) {
                    if (sender.hasPermission("<FP>.aenderchest")) {
                        Player target = Bukkit.getPlayerExact(args[0]);
                        if (target == null) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.DARK_RED + args[0] + " is not online!");
                        } else {
                            player.openInventory(target.getEnderChest());
                            return true;
                        }
                    } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "You do not have permission to use this command!");
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
