package England.Origin.FirstPlugin.Commands.Message;

import England.Origin.FirstPlugin.Data.ChangeData;
import England.Origin.FirstPlugin.Data.PlayerNameData;
import England.Origin.FirstPlugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by josep on 29/01/2017.
 */
public class msg implements CommandExecutor {


    //todo ensure this isn't causing a memory leak and msg are being removed
    public static Map<Player, Player> msg = new HashMap<>();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        StringBuilder b = new StringBuilder(); // Coverts args into long string
        for (int i = 1; i < args.length; i++)
            b.append(args[i] + " ");
        if (cmd.getName().equalsIgnoreCase("msg")) {
            if (args.length < 2) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.DARK_RED + "Incorrect usage - /msg [PlayerName] [Message]"); //If user does not add a message
            } else {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (target == null) { //if player isnt online
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.DARK_RED + args[0] + " is not online!");
                    return false;
                }
                if (!(PlayerNameData.filegetdata(target, "vanish") == null)) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.DARK_RED + args[0] + " is not online!");
                    return false;
                }
                String playername;
                if (!(sender instanceof Player)) {
                    playername = sender.getName();
                } else {
                    Player player = (Player) sender;
                    playername = player.getDisplayName();
                    if (msg.containsKey(target)) {
                        msg.remove(target);
                        msg.put(target, ((Player) sender));
                    } else {
                        msg.put(target, ((Player) sender));
                    }
                }
                sender.sendMessage(ChatColor.YELLOW + "[" + ChatColor.AQUA + "me"  + ChatColor.YELLOW + " -> " + ChatColor.AQUA + target.getDisplayName() + ChatColor.YELLOW + "] " + ChatColor.RESET + ChatColor.translateAlternateColorCodes('&', b.toString()));
                target.sendMessage(ChatColor.YELLOW + "[" + ChatColor.AQUA +  playername + ChatColor.YELLOW + " -> " + ChatColor.AQUA + "me" + ChatColor.YELLOW + "] " + ChatColor.RESET + ChatColor.translateAlternateColorCodes('&', b.toString()));
            }
        }
        return false;
    }
}
