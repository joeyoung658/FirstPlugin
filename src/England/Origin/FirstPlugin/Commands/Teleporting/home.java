package England.Origin.FirstPlugin.Commands.Teleporting;

import England.Origin.FirstPlugin.Data.GetData;
import England.Origin.FirstPlugin.Data.HomeData;
import England.Origin.FirstPlugin.Data.PlayerNameData;
import England.Origin.FirstPlugin.Data.WarpData;
import England.Origin.FirstPlugin.Listeners.Back;
import England.Origin.FirstPlugin.Main;
import England.Origin.FirstPlugin.Player.Teleporting;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Joes_room on 22/12/2016.
 */
public class home implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("home")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +"This command can only be run by a player!");
                return true;
            } else {
                Player player = (Player) sender;
                if (PlayerNameData.filegetdata(player, "homes") == null) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You have not set any homes! Type /sethome [Home Name] to set a home.");
                    return false;
                }
                if (args.length == 0) {


                    //List<String> homes = Main.instance.getConfig().getStringList("homes");

                    Set<String> homess = GetData.filegetdataset(player, "homes");
                    List<String> homes = new ArrayList<>();
                    homes.addAll(homess);

                    int homeamount = homes.size();
                    int homecap = GetData.filegetdataint(player, "homeamount");

                    StringBuilder homenames = new StringBuilder();
                    for (int i = 0; i < homes.size(); i++) {

                        homenames.append(homes.get(i) + ", ");
                        //sender.sendMessage(i + "");
                    }

                    sender.sendMessage(ChatColor.AQUA + "You have " + homeamount + "/"  + homecap + " homes: " + ChatColor.RESET + homenames.toString());

                } else if (args.length == 1) {
                    //List<String> homeslower = Main.instance.getConfig().getStringList("homes");

                    Set<String> homess = GetData.filegetdataset(player, "homes");
                    List<String> homes = new ArrayList<>();
                    homes.addAll(homess);




                    if (homes.contains(args[0])) {
                        String worldname = HomeData.filegetdatastring(player, args[0]);
                        int x = HomeData.filegetdataint(player, args[0], "x");
                        int y = HomeData.filegetdataint(player, args[0], "y");
                        int z = HomeData.filegetdataint(player, args[0], "z");
                        float yaw = HomeData.filegetdataint(player, args[0], "yaw");
                        float pitch = HomeData.filegetdataint(player, args[0], "pitch");

                        Back.backsave(((Player) sender).getPlayer());
                        Teleporting.delay(((Player) sender), worldname, x, y, z, yaw, pitch);
                        return false;
                    } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "That home does not exist! - Please note homes are case sensitive.");
                        return false;
                    }
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +"Incorrect arguments! /home [Home Name]");
                }

            }

        }
        return true;
    }
}
