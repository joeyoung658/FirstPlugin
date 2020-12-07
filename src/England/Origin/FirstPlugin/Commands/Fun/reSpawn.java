package England.Origin.FirstPlugin.Commands.Fun;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class reSpawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("respawn")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("This command can only be run by players!");
                return true;
            }
            if (args.length == 0) {
                //Commands disabled as it causes the server to crash if on an entity
                if (((Player) sender).getLocation().getWorld().getName().endsWith("_nether"))
                {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "Sorry this command is currently disabled within the nether");
                    return true;
                }
                if (((Player) sender).getLocation().getWorld().getName().endsWith("_end"))
                {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "Sorry this command is currently disabled within the end");
                    return true;
                }
                ((Player) sender).setHealth(0);
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "Error: " + ChatColor.WHITE + "Incorrect arguments.");
            }
        }
        return false;
    }
}
