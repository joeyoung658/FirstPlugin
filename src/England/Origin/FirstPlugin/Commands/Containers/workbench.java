package England.Origin.FirstPlugin.Commands.Containers;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


/**
 * Created by Joes_room on 14/12/2016.
 */
public class workbench implements CommandExecutor {



    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("workbench")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +"This command can only be run by a player!");
                return true;
            } else {
                Player player = (Player) sender;
                if (sender.hasPermission("<FP>.workbench")) {
                    player.openWorkbench(player.getLocation(), true);
                    return true;
                }
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "This is a donator only command, use /donate to find out more!");
            }
        }
        return false;
    }
}