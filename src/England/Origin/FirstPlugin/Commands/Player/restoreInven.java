package England.Origin.FirstPlugin.Commands.Player;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

import static England.Origin.FirstPlugin.Player.SaveInven.SavedInven;

/**
 * Created by josep on 31/07/2017.
 */
public class restoreInven implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        StringBuilder b = new StringBuilder(); // Coverts args into long string
        for (int i = 0; i < args.length; i++)
            b.append(args[i] + " ");


        if (cmd.getName().equalsIgnoreCase("restoreinven")) {
            if (args.length == 0){
                if (!(sender instanceof Player)) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e[&4Server&e]&f ") + "You cannot restore your inventory!");
                    return true;
                }
                if (!(sender.hasPermission("<FP>.restoreinven"))){
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e[&4Server&e]&f ") +  ChatColor.RED + "You do not have permission todo this!");
                    return true;
                }

                if (!(SavedInven.containsKey(((Player) sender).getPlayer()))){
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e[&4Server&e]&f ") +  ChatColor.RED + "No inventory found which can be restored!");
                    return true;
                }

                //ItemStack[] items = ((Player) sender).getInventory().getContents();

                ((Player) sender).getInventory().clear();

                ((Player) sender).getInventory().setContents(SavedInven.get(sender).getContents());

                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e[&4Server&e]&f ") +  ChatColor.RED + "Restored");

            }
        }
        return true;
    }
}