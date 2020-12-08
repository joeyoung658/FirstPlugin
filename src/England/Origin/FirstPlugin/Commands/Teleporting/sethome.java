package England.Origin.FirstPlugin.Commands.Teleporting;

import England.Origin.FirstPlugin.Data.GetData;
import England.Origin.FirstPlugin.Data.HomeData;
import England.Origin.FirstPlugin.Data.PlayerNameData;
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
 * Created by Joes_room on 11/02/2016.
 */
public class sethome implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("sethome")) {


                //todo run async

                if (args.length == 1) {
                    if (!(sender instanceof Player)) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +"This command can only be run by a player!");
                        return true;
                    } else {

                        Player player = (Player) sender;

                        if (!(PlayerNameData.filegetdata(player, "homes") == null)) {
                            Set<String> homess = GetData.filegetdataset(player, "homes");
                            List<String> homes = new ArrayList<>();
                            homes.addAll(homess);

                            if (homes.size() >= GetData.filegetdataint(player, "homeamount")) {
                                if (!(sender.hasPermission("  "))) {
                                    sender.sendMessage(ChatColor.AQUA + "You may not set anymore homes!");
                                    return false;
                                }
                            }
                        }


                        new BukkitRunnable(){
                            @Override
                            public void run() {
                                String worldname = player.getLocation().getWorld().getName();
                                float x = player.getLocation().getBlockX();
                                float y = player.getLocation().getBlockY();
                                float z = player.getLocation().getBlockZ();
                                float yaw = player.getLocation().getYaw();
                                float pitch = player.getLocation().getPitch();

                                HomeData.SetHomeDataString(player, args[0], "world", worldname);
                                HomeData.SetHomeDataFloat(player, args[0], "x", x);
                                HomeData.SetHomeDataFloat(player, args[0], "y", y);
                                HomeData.SetHomeDataFloat(player, args[0], "z", z);
                                HomeData.SetHomeDataFloat(player, args[0], "yaw", yaw);
                                HomeData.SetHomeDataFloat(player, args[0], "pitch", pitch);
                            }
                        }.runTaskAsynchronously(Main.instance);

                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "New home (" + args[0] + ") created successfully");
                    }
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "Incorrect arguments! /sethome [Home Name]");
                }
        }
        return true;
    }
}