package England.Origin.FirstPlugin.Commands.Teleporting;

import England.Origin.FirstPlugin.Data.Back;
import England.Origin.FirstPlugin.Data.GetData;
import England.Origin.FirstPlugin.Data.HomeData;
import England.Origin.FirstPlugin.Data.PlayerNameData;
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


//todo run async

public class home implements CommandExecutor {
    public boolean onCommand(final CommandSender sender, Command cmd, String label, String[] args) {
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
                        getPlayerHomeCords(((Player) sender), args[0], result -> {
                            if (result == null) {
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "That home does not exist! - Please note homes are case sensitive.");
                                return;
                            }
                            Teleporting.delay(((Player) sender),
                                    result.getWorld().getName(),
                                    result.getBlockX(),
                                    result.getBlockY(),
                                    result.getBlockZ(),
                                    result.getYaw(),
                                    result.getPitch());
                        });
                        return false;

                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +"Incorrect arguments! /home [Home Name]");
                }
            }
        }
        return true;
    }

    public interface LocationCallBack {
        public void onQueryDone(Location result);
    }

    public static void getPlayerHomeCords(final Player player,
                                          final String home,
                                          final LocationCallBack callback) {
        // Run outside of the tick loop
        Bukkit.getScheduler().runTaskAsynchronously(Main.instance, new Runnable() {
            @Override
            public void run() {
                Location result;
                Set<String> homess = GetData.filegetdataset(player, "homes");
                List<String> homes = new ArrayList<>();
                homes.addAll(homess);
                if (homes.contains(home)) {
                    String worldname = HomeData.filegetdatastring(player, home);
                    int x = HomeData.filegetdataint(player, home, "x");
                    int y = HomeData.filegetdataint(player, home, "y");
                    int z = HomeData.filegetdataint(player, home, "z");
                    float yaw = HomeData.filegetdataint(player, home, "yaw");
                    float pitch = HomeData.filegetdataint(player, home, "pitch");
                    Back.backsave(player);
                    result = new Location(Bukkit.getWorld(worldname), x, y, z, yaw, pitch);
                } else {
                    result = null;
                }
                Bukkit.getScheduler().runTask(Main.instance, new Runnable() {
                    @Override
                    public void run() {
                        callback.onQueryDone(result);
                    }
                });
            }
        });
    }
}
