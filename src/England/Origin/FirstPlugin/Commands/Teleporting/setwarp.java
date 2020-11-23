package England.Origin.FirstPlugin.Commands.Teleporting;

import England.Origin.FirstPlugin.Data.WarpData;
import England.Origin.FirstPlugin.Main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Created by Joes_room on 24/12/2016.
 */
public class setwarp implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("setwarp")) {
            if (sender.hasPermission("<FP>.awarp")) {
                if (args.length == 1) {
                    if (!(sender instanceof Player)) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +"This command can only be run by a player!");
                        return true;
                    } else {

                        Player player = (Player) sender;
                        List<String> warps = Main.instance.getConfig().getStringList("warpnames");

                        List<String> warpslower = Main.instance.getConfig().getStringList("warpnames");


                        for (int i = 0, l = warpslower.size(); i < l; ++i) {
                            warpslower.add(warpslower.remove(0).toLowerCase());
                        }

                        String worldname = player.getLocation().getWorld().getName();
                        float x = player.getLocation().getBlockX();
                        float y = player.getLocation().getBlockY();
                        float z = player.getLocation().getBlockZ();
                        float yaw = player.getLocation().getYaw();
                        float pitch = player.getLocation().getPitch();

                        WarpData.CreateWarpFile(args[0]);
                        WarpData.SetWarpDataString(args[0], "world", worldname);
                        WarpData.SetWarpDataFloat(args[0], "x", x);
                        WarpData.SetWarpDataFloat(args[0], "y", y);
                        WarpData.SetWarpDataFloat(args[0], "z", z);
                        WarpData.SetWarpDataFloat(args[0], "yaw", yaw);
                        WarpData.SetWarpDataFloat(args[0], "pitch", pitch);

                        if (!(warpslower.contains(args[0].toLowerCase()))) {
                            warps.add(args[0]);
                            Main.instance.getConfig().set("warpnames", warps);
                            Main.instance.saveConfig();
                        }

                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You have set warp " + args[0] + " successfully");
                    }
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "Incorrect arguments! /setwarp [WarpName]");
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "You do not have the correct permission to do this!");
            }
        }
        return true;
    }
}