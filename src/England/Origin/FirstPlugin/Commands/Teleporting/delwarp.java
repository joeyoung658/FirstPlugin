package England.Origin.FirstPlugin.Commands.Teleporting;

import England.Origin.FirstPlugin.Data.WarpData;
import England.Origin.FirstPlugin.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.List;

/**
 * Created by Joes_room on 24/12/2016.
 */
public class delwarp implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("delwarp")) {
            if (sender.hasPermission("<FP>.awarp")) {
                if (args.length == 1) {

                    List<String> warps = Main.instance.getConfig().getStringList("warpnames");
                    //List<String> warpslower = Main.instance.getConfig().getStringList("warpnames");

//                    for (int i = 0, l = warpslower.size(); i < l; ++i) {
//                        warpslower.add(warpslower.remove(0).toLowerCase());
//                    }

                    if (warps.contains(args[0])) {
                        warps.remove(args[0]);
                        Main.instance.getConfig().set("warpnames", warps);
                        Main.instance.saveConfig();
                        WarpData.RemoveWarpFile(args[0].toLowerCase());
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") + ChatColor.AQUA + "You have removed warp " + args[0] + " successfully");
                        return false;
                    } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") + ChatColor.AQUA + "That warp does not exist! - Remember warps are case sensitive upon removal.");
                    }


                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") + ChatColor.RED + "Incorrect arguments! /delwarp [warpname]");
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") + ChatColor.RED + "This is a Admin command only!");
            }
        }
        return true;
    }
}




