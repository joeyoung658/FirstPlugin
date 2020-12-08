package England.Origin.FirstPlugin.Commands.Teleporting;

import England.Origin.FirstPlugin.Data.Back;
import England.Origin.FirstPlugin.Data.WarpData;
import England.Origin.FirstPlugin.Main;
import England.Origin.FirstPlugin.Player.Teleporting;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joes_room on 22/12/2016.
 */
public class warp implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("warp")) {

                if (args.length == 0) {

                    if (!(sender instanceof Player)) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +"This command can only be run by a player!");
                        return true;
                    } else {
                        List<String> warps = Main.instance.getConfig().getStringList("warpnames");
                        StringBuilder warpnames = new StringBuilder();
                        for (int i = 0; i < warps.size(); i++) {

                            warpnames.append(warps.get(i) + ", ");
                            //sender.sendMessage(i + "");
                        }

                        sender.sendMessage(ChatColor.AQUA + "Warps: " + ChatColor.RESET + warpnames.toString());
                    }
                } else if (args.length == 1) {
                    List<String> warps = Main.instance.getConfig().getStringList("warpnames");
                    List<String> warpslower = new ArrayList<>();





                    for (int i = 0, l = warps.size(); i < l; ++i) {
                        //warpslower.add(warpslower.remove(i).toLowerCase());
                        warpslower.add(warps.get(i).toLowerCase());
                    }

                    if (warpslower.contains(args[0].toLowerCase())) {
                        String worldname = WarpData.filegetdatastring(args[0], "world");
                        int x = WarpData.filegetdataint(args[0], "x");
                        int y = WarpData.filegetdataint(args[0], "y");
                        int z = WarpData.filegetdataint(args[0], "z");
                        float yaw = WarpData.filegetdataint(args[0], "yaw");
                        float pitch = WarpData.filegetdataint(args[0], "pitch");

                        Back.backsave(((Player) sender).getPlayer());
                        Teleporting.delay(((Player) sender), worldname, x, y, z, yaw, pitch);
                        return false;
                    } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "That warp does not exist!");
                        return false;
                    }
                }

        }
        return true;
    }
}
