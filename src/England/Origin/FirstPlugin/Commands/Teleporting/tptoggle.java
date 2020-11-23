package England.Origin.FirstPlugin.Commands.Teleporting;

import England.Origin.FirstPlugin.Data.ChangeData;
import England.Origin.FirstPlugin.Data.PlayerNameData;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by josep on 27/01/2017.
 */
public class tptoggle implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("tptoggle")) {
            if (args.length == 0) {
//                if (!(sender.hasPermission("<FP>.tpa"))) {
//                    sender.sendMessage(ChatColor.RED + "Please use /trigger in order to request to teleport to another player!");
//                    return false;
//                }
                if (!(sender instanceof Player)) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +"This command can only be run by a player!");
                    return true;
                } else {
                        if (!(PlayerNameData.filegetdata(((Player) sender), "tptoggle") == null)) {

                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You will now receive teleport requests!");

                            ChangeData.changedatac(((Player) sender), "tptoggle", null);

                            return true;
                        } else {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You will no longer receive teleport requests!");

                            ChangeData.changedatac(((Player) sender), "tptoggle", "true");

                            return true;
                        }

                }
            } else if (args.length == 1) {
                if (sender.hasPermission("<FP>.atptoggle")) {
                    Player target = Bukkit.getPlayerExact(args[0]);

                    if (target == null) { //if player isnt online
                        sender.sendMessage(ChatColor.DARK_RED + args[0] + " is not online!");
                    } else {
                        if (!(PlayerNameData.filegetdata(target, "tptoggle") == null)) {

                            target.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "An Admin enabled you to receive teleport requests!");
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You have disabled tptoggle mode for " + target.getDisplayName());
                            ChangeData.changedatac(target, "tptoggle", null);

                            return true;
                        } else {
                            target.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "An Admin has prevented you from receiving teleport requests!");
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You have enabled tptoggle mode for " + target.getDisplayName());
                            ChangeData.changedatac(target, "tptoggle", "true");

                            return true;
                        }
                    }
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "You do not have permission to do this!");
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "Incorrect arguments");
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "/tptoggle");
            }
        }
        return true;
    }

}
