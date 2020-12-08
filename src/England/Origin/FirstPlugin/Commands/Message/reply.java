package England.Origin.FirstPlugin.Commands.Message;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


/**
 * Created by josep on 29/01/2017.
 */
public class reply implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        StringBuilder b = new StringBuilder(); // Coverts args into long string
        for (int i = 0; i < args.length; i++)
            b.append(args[i] + " ");


        if (cmd.getName().equalsIgnoreCase("reply")) {
            if (!(args.length == 0)) {
                if (msg.msg.containsKey(sender)) {
                    Player tpato = msg.msg.get(sender);
                    if (!(tpato.isOnline())) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "That player recently went offline!");
                        msg.msg.remove(sender);
                        return false;
                    }
                    String playername;
                    if (!(sender instanceof Player)) {
                        playername = sender.getName();
                    } else {
                        Player player = (Player) sender;
                        playername = player.getDisplayName();
                        if (msg.msg.containsKey(tpato)) {
                            msg.msg.remove(tpato);
                            msg.msg.put(tpato, ((Player) sender));
                        } else {
                            msg.msg.put(tpato, ((Player) sender));
                        }
                    }
                    sender.sendMessage(ChatColor.YELLOW + "[" + ChatColor.AQUA + "me"  + ChatColor.YELLOW + " -> " + ChatColor.AQUA + tpato.getDisplayName() + ChatColor.YELLOW + "] " + ChatColor.RESET + ChatColor.translateAlternateColorCodes('&', b.toString()));
                    tpato.sendMessage(ChatColor.YELLOW + "[" + ChatColor.AQUA +  playername + ChatColor.YELLOW + " -> " + ChatColor.AQUA + "me" + ChatColor.YELLOW + "] " + ChatColor.RESET + ChatColor.translateAlternateColorCodes('&', b.toString()));
                    return false;
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "You have no one whom you can reply to!");
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "Incorrect usage! /reply [Message]");
            }
        }
        return false;
    }
}
