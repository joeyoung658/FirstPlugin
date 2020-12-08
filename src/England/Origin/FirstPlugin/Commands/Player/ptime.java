package England.Origin.FirstPlugin.Commands.Player;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Joes_room on 22/8/2016.
 */
public class ptime implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("ptime")) { //Enables user to set a custom prefix
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +"This command can only be run by a player!");
                return true;
            } else {
                if (sender.hasPermission("<FP>.ptime")){
                    if (args.length == 1) {
                        Player player = (Player) sender;
                        if (args[0].equalsIgnoreCase("day")) {
                            player.setPlayerTime(1000, false);
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You have set your time to day!");
                            return true;
                        } else if (args[0].equalsIgnoreCase("night")) {
                            player.setPlayerTime(13000, false);
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You have set your time to night.");
                            return true;
                        } else if (args[0].equalsIgnoreCase("reset")) {
                            player.resetPlayerTime();
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You have re-synced your time with the servers local time.");
                            return true;
                        } else {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "Incorrent arguments /ptime [Day/Night/Reset]");
                        }
                    } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "Incorrent arguments  /ptime [Day/Night/Reset]");
                    }

                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "You do not have permission to do this!");
                }
            }
        }
        return true;
    }

}


