package England.Origin.FirstPlugin.Commands.Player;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Joes_room on 22/12/2016.
 */
public class invsee implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("invsee")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +"This command can only be run by players!");
                return true;
            } else {
                Player player = (Player) sender;
                if (args.length == 1) {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if (sender.hasPermission("<FP>.invsee")) {
                        if (target == null) {
                            sender.sendMessage(ChatColor.DARK_RED + args[0] + " is not online!");
                            return false;
                        } else {
                            player.openInventory(target.getInventory());
                            return true;
                        }
                    } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "You do not have permission to do this!");
                        return false;
                    }
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "Incorrect arguments! /invsee [PlayerName]");
                }
            }
        }
        return true;
    }
}