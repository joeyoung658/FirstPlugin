package England.Origin.FirstPlugin.Commands.Admin;

import England.Origin.FirstPlugin.Data.ChangeData;
import England.Origin.FirstPlugin.Data.PlayerNameData;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joes_room on 08/12/2016.
 */
public class vanish implements CommandExecutor {

    public static List<Player> vanishtoggle = new ArrayList<>();
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("vanish")) {
            if (args.length == 0) {
                if (!(sender instanceof Player)) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +"This command can only be run by a player!");
                    return true;
                } else {
                if (sender.hasPermission("<FP>.vanish")) {
                        if (!(PlayerNameData.filegetdata(((Player) sender), "vanish") == null)) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You have disabled vanish mode!");
                        vanishtoggle.remove(((Player) sender).getPlayer());
                        ChangeData.changedatac(((Player) sender), "vanish", null);
                        offvanish(((Player) sender));
                        return true;
                        } else {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You have enabled vanish mode!");
                            vanishtoggle.add(((Player) sender).getPlayer());
                            ChangeData.changedatac(((Player) sender), "vanish", "true");
                            onvanish(((Player) sender));
                            return true;
                        }
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "You do not have permission to do this!");
                }
                }
            } else if (args.length == 1) {
                if (sender.hasPermission("<FP>.avanish")) {
                    Player target = Bukkit.getPlayerExact(args[0]);

                    if (target == null) { //if player isnt online
                        sender.sendMessage(ChatColor.DARK_RED + args[0] + " is not online!");
                    } else {
                            if (!(PlayerNameData.filegetdata(target, "vanish") == null)) {

                                target.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "An Admin has disabled vanish mode!");
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You have disabled vanish mode for " + target.getDisplayName());
                                ChangeData.changedatac(target, "vanish", null);
                                offvanish(target);
                                return true;
                            } else {
                                target.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "An Admin enabled vanish mode for you!");
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You have enabled vanish mode for " + target.getDisplayName());
                                ChangeData.changedatac(target, "vanish", "true");
                                onvanish(target);
                                return true;
                            }
                    }
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "You do not have permission to do this!");
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "Incorrect arguments");
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "/vanish");
            }
        }
        return true;
    }

    @Deprecated
    public static void onvanish(Player player){

        for (Player players : Bukkit.getOnlinePlayers()) {
            if (!(players.hasPermission("<FP>.vanish.see"))) {

                players.hidePlayer(player);
            }

        }
    }

    @Deprecated
    public static void offvanish(Player player){

        for (Player players : Bukkit.getOnlinePlayers()) {
            players.showPlayer(player);
        }
    }
}
