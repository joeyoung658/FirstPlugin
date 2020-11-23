package England.Origin.FirstPlugin.Commands.Toggles;

import England.Origin.FirstPlugin.Data.ChangeData;
import England.Origin.FirstPlugin.Data.PlayerNameData;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by josep on 08/01/2017.
 */
public class togglekeepxp implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("togglekeepxp")) {
            if (args.length == 0) {
                if (!(sender instanceof Player)) {
                    sender.sendMessage("This command can only be run by a player!");
                    return true;
                } else {
                    if (sender.hasPermission("<FP>.keepxp")) {
                        if (!(PlayerNameData.filegetdata(((Player) sender), "keepxp") == null)) {

                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You will now drop your xp upon death!");

                            ChangeData.changedatac(((Player) sender), "keepxp", null);

                            return true;
                        } else {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You will no longer drop your xp upon death!");

                            ChangeData.changedatac(((Player) sender), "keepxp", "true");

                            return true;
                        }
                    } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "You do not have permission to do this!");
                    }
                }
            } else if (args.length == 1) {
                if (sender.hasPermission("<FP>.skeepxp")) {
                    Player target = Bukkit.getPlayerExact(args[0]);

                    if (target == null) { //if player isnt online
                        sender.sendMessage(ChatColor.DARK_RED + args[0] + " is not online!");
                    } else {
                        if (!(PlayerNameData.filegetdata(target, "keepxp") == null)) {

                            target.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "An Admin enabled you to drop your xp upon death!");
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You have disabled keepxp mode for " + target.getDisplayName());
                            ChangeData.changedatac(target, "keepxp", null);

                            return true;
                        } else {
                            target.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "An Admin enabled you to keep your xp upon death!");
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You have enabled keepxp mode for " + target.getDisplayName());
                            ChangeData.changedatac(target, "keepxp", "true");

                            return true;
                        }
                    }
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "You do not have permission to do this!");
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "Incorrect arguments");
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "/keepxp");
            }
        }
        return true;
    }

}