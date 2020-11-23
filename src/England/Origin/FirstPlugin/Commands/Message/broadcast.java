package England.Origin.FirstPlugin.Commands.Message;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by josep on 19/01/2017.
 */
public class broadcast implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        StringBuilder b = new StringBuilder(); // Coverts args into long string
        for (int i = 0; i < args.length; i++)
            b.append(args[i] + " ");

        if (label.equalsIgnoreCase("broadcast")) {
            if (sender.hasPermission("<FP>.broadcast")) {
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e[&4Server-Announcement&e]&f " + b.toString()));
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ")  +ChatColor.RED + "You do not have permission to do this!");
            }
        }
        return false;
    }


}
