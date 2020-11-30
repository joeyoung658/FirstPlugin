package England.Origin.FirstPlugin.Commands.Teleporting;

import England.Origin.FirstPlugin.Data.GetData;
import England.Origin.FirstPlugin.Player.Teleporting;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by josep on 19/01/2017.
 */
public class back implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("back")) {


            if (args.length == 0) {
                if (!(sender instanceof Player)) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") + "This command can only be run by a player!");
                    return true;
                }
                Player player = (Player) sender;
                if (sender.hasPermission("<FP>.back")) {
                    String worldname = GetData.filegetdatastring(player, "back.worldname");
                    int x = GetData.filegetdataint(player, "back.x");
                    int y = GetData.filegetdataint(player, "back.y");
                    int z = GetData.filegetdataint(player, "back.z");
                    float yaw = GetData.filegetdataint(player, "back.yaw");
                    float pitch = GetData.filegetdataint(player, "back.pitch");
                    Teleporting.delay(((Player) sender), worldname, x, y, z, yaw, pitch);
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ")  +ChatColor.RED + "This is a donator only command, use /donate to find out more!");
                }

            } else if (args.length == 1) {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (target == null) { //if player isnt online
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ")  +ChatColor.DARK_RED + args[0] + " is not online!");
                } else {
                    if (sender.hasPermission("<FP>.aback")) {
                        String worldname = GetData.filegetdatastring(target, "back.worldname");
                        int x = GetData.filegetdataint(target, "back.x");
                        int y = GetData.filegetdataint(target, "back.y");
                        int z = GetData.filegetdataint(target, "back.z");
                        float yaw = GetData.filegetdataint(target, "back.yaw");
                        float pitch = GetData.filegetdataint(target, "back.pitch");



                        Bukkit.getPlayer(args[0]).teleport(new Location(Bukkit.getWorld(worldname), x, y, z, yaw, pitch));

                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ")  +ChatColor.AQUA + "You have sent " + target.getDisplayName() + ChatColor.AQUA + " back to their last location!");
                        target.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ")  +ChatColor.GRAY + "An Admin has teleported you to your last location!");
                    } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ")  +ChatColor.RED + "This is an admin only command!");
                    }
                }
            }


        }
    return false;
    }
}
