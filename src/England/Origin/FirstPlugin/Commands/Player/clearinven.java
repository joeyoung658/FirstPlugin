package England.Origin.FirstPlugin.Commands.Player;

import England.Origin.FirstPlugin.Player.SaveInven;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static England.Origin.FirstPlugin.Player.SaveInven.SavePlayerInven;

/**
 * Created by Joes_room on 22/12/2016.
 */
public class clearinven implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("clearinven")) {

            if (args.length == 0) {
                if (!(sender instanceof Player)) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ")  +"This command can only be run by players!");
                    return true;
                }
                if (sender.hasPermission("<FP>.clearinven")) {
                    SavePlayerInven(((Player) sender));
                    ((Player) sender).getInventory().clear();
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ")  +ChatColor.AQUA + "All items cleared from " + ((Player) sender).getDisplayName());
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ")  +ChatColor.RED + "You do not have permission to do this!");
                }
            }else if (args.length == 1) {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (sender.hasPermission("<FP>.aclearinven")) {
                    if (target == null) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ")  +ChatColor.RED + args[0] + " is not online!");
                        return false;
                    }
                    SavePlayerInven(target);
                    target.getInventory().clear();
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ")  +ChatColor.AQUA + "All items cleared from " + target.getDisplayName());
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ")  +ChatColor.RED + "You do not have permission to do this!");
                }
            }
    }
        return true;
    }
}
