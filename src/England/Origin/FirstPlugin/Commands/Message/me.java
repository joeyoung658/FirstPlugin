package England.Origin.FirstPlugin.Commands.Message;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by josep on 07/01/2017.
 */
public class me implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("me")) {
                if (!(sender instanceof Player)) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +"This command can only be run by a player!");
                    return true;
                } else {
                    StringBuilder b = new StringBuilder(); // Coverts args into long string
                    for (int i = 0; i < args.length; i++)
                        b.append(args[i] + " ");
                    Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + "* " + ((Player) sender).getDisplayName() + ChatColor.DARK_PURPLE + " " + b.toString());
                }
        }
        return true;
    }
}
