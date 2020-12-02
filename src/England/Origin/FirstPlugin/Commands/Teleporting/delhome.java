package England.Origin.FirstPlugin.Commands.Teleporting;

import England.Origin.FirstPlugin.Data.GetData;
import England.Origin.FirstPlugin.Data.HomeData;
import England.Origin.FirstPlugin.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by josep on 13/02/2017.
 */
public class delhome implements CommandExecutor {

    //run async

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("delhome")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ")  + " This command can only be run by a player!");
                return true;
            }
            if (args.length == 1) {
                Player player = (Player) sender;
                Set<String> homess = GetData.filegetdataset(player, "homes");
                List<String> homes = new ArrayList<>();
                homes.addAll(homess);
                if (!(homes.contains(args[0]))) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ")  +ChatColor.RED + "That homes does not exist! - Please note homes are case sensitive.");
                    return false;
                }
                new BukkitRunnable(){
                    @Override
                    public void run() {
                        HomeData.RemoveHome(player, args[0]);
                    }
                }.runTaskAsynchronously(Main.instance);
                sender.sendMessage(ChatColor.AQUA + "Home removed successfully!");
            } else {
                sender.sendMessage(ChatColor.RED + "Incorrect arguments! /delhome [Home Name]");
            }
        }
        return true;
    }
}
