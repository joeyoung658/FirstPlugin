package England.Origin.FirstPlugin.Commands.Fun;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by josep on 01/06/2017.
 */
public class tableflip implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("tableflip")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("This command can only be run by players!");
                return true;
            }
            if (args.length == 0) {


                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") + ((Player) sender).getDisplayName()
                        + ChatColor.RED +" has flipped a table in a spite of rage... (╯°□°）╯︵ ┻━┻ ");
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "Error: " + ChatColor.WHITE + "Incorrect arguments.");
            }
        }


        if (cmd.getName().equalsIgnoreCase("unflip")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("This command can only be run by players!");
                return true;
            }
            if (args.length == 0) {


                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") + ((Player) sender).getDisplayName() + ChatColor.RED
                        +" has fixed the table as violence is never the answer.  ┬─┬ノ( ゜-゜ノ) ");
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "Error: " + ChatColor.WHITE + "Incorrect arguments.");
            }
        }
        return false;
    }


}
