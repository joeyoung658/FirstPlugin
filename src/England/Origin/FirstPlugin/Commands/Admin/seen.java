package England.Origin.FirstPlugin.Commands.Admin;

import England.Origin.FirstPlugin.Data.GetData;
import England.Origin.FirstPlugin.Data.PlayerNameData;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * Created by josep on 17/01/2017.
 */
public class seen implements CommandExecutor {
    @SuppressWarnings("deprecation")
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("seen")) {
            if (sender.hasPermission("<FP>.seen")) {
                if (args.length == 1){
                    Player target = Bukkit.getPlayerExact(args[0]); //checks to see if first argument is online
                    if (target == null) { //if player isn't not online do below
                        OfflinePlayer otarget = Bukkit.getServer().getOfflinePlayer(args[0]);
                        UUID offline_uuid = otarget.getUniqueId();
                        if (!(otarget.hasPlayedBefore())) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.DARK_RED + args[0] + " has never joined the server!");
                            return false;
                        }
                        String firstjoin;
                        String lastseen;
                        String logoutlocation;
                        Boolean vanished;
                        Boolean keepinven;
                        if (!(GetData.file_get_data_using_uuid_string(offline_uuid, "FirstJoinDate") == null)) {
                            firstjoin = GetData.file_get_data_using_uuid_string(offline_uuid, "FirstJoinDate");
                        } else {
                            firstjoin = "Record not on file.";
                        }

                        if (!(GetData.file_get_data_using_uuid_string(offline_uuid, "LastSeenDate") == null)) {
                            lastseen = GetData.file_get_data_using_uuid_string(offline_uuid, "LastSeenDate");
                        } else {
                            lastseen = "Record not on file.";
                        }

                        if (!(GetData.file_get_data_using_uuid_string(offline_uuid, "logoutlocation") == null)) {
                            logoutlocation = "(" + GetData.file_get_data_using_uuid_string(offline_uuid, "logoutlocation.worldname") +  ", " +
                                    GetData.file_get_data_using_uuid_int(offline_uuid, "logoutlocation.x").toString() +  ", " +
                                    GetData.file_get_data_using_uuid_int(offline_uuid, "logoutlocation.y").toString() +  ", " +
                                    GetData.file_get_data_using_uuid_int(offline_uuid, "logoutlocation.z").toString()+  ", " +
                                    GetData.file_get_data_using_uuid_int(offline_uuid, "logoutlocation.yaw").toString()+  ", " +
                                    GetData.file_get_data_using_uuid_int(offline_uuid, "logoutlocation.pitch").toString() + ")";
                        } else {
                            logoutlocation = "Record not on file.";
                        }
                        if (!(GetData.file_get_data_using_uuid_string(offline_uuid, "vanish") == null)) {
                            vanished = true;
                        } else {
                            vanished = false;
                        }

                        if (!(GetData.file_get_data_using_uuid_string(offline_uuid, "keepinven") == null)) {
                            keepinven = true;
                        } else {
                            keepinven = false;
                        }

                        String reason = null;
                        String duration = null;
                        if (Bukkit.getBanList(BanList.Type.NAME).isBanned(otarget.getName()))  {
                             reason = " Reason - " +
                                    Bukkit.getBanList(BanList.Type.NAME).getBanEntry(otarget.getName()).getReason();
                            duration = " Unban Date - : " +
                                    Bukkit.getBanList(BanList.Type.NAME).getBanEntry(otarget.getName()).getExpiration();

                             if (reason == null) {
                                 reason = "No reason given";
                             }

                             if (duration == null){
                                 duration = "Never";
                             }
                        }

                        sender.sendMessage("-----" + ChatColor.YELLOW + args[0] + ChatColor.LIGHT_PURPLE + "'s Player information;" + ChatColor.RESET +"-----");
                        sender.sendMessage(ChatColor.AQUA + "- First Joined(GMT): " + ChatColor.WHITE + firstjoin);
                        sender.sendMessage(ChatColor.AQUA + "- Last Seen(GMT): " + ChatColor.WHITE + lastseen);
                        if (Bukkit.getBanList(BanList.Type.NAME).isBanned(otarget.getName()))  { sender.sendMessage(ChatColor.AQUA  + "- Banned Status: " + ChatColor.WHITE + reason + duration);}
                        sender.sendMessage(ChatColor.AQUA + "- IP Address: " + ChatColor.WHITE +  GetData.file_get_data_using_uuid_string(offline_uuid, "ipAddress"));
                        sender.sendMessage(ChatColor.AQUA + "- Keep Inventory: " + ChatColor.WHITE + keepinven);
                        if (sender.hasPermission("<FP>.avanish")) { sender.sendMessage(ChatColor.AQUA + "- Vanished: " + ChatColor.WHITE + vanished);}
                        sender.sendMessage(ChatColor.AQUA + "- Log Out Location: " + ChatColor.WHITE +  logoutlocation);

                        return false;

                    } else {


                        String ofirstjoin;
                        String lastjointime;
                        Boolean ovanished;
                        Boolean okeepinven;

                        if (!(PlayerNameData.filegetdata(target.getPlayer(), "LastJoinDate") == null)) {
                            lastjointime = PlayerNameData.filegetdata(target.getPlayer(), "LastJoinDate");
                        } else {
                            lastjointime = "Record not on file.";
                        }
                        if (!(PlayerNameData.filegetdata(target.getPlayer(), "FirstJoinDate") == null)) {
                            ofirstjoin = PlayerNameData.filegetdata(target.getPlayer(), "FirstJoinDate");
                        } else {
                            ofirstjoin = "Record not on file.";
                        }
                        if (!(PlayerNameData.filegetdata(target, "vanish") == null)) {
                            ovanished = true;
                        } else {
                            ovanished = false;
                        }

                        if (!(PlayerNameData.filegetdata(target, "keepinven") == null)) {
                            okeepinven = true;
                        } else {
                            okeepinven = false;
                        }
                        sender.sendMessage("-----" + ChatColor.YELLOW + target.getDisplayName() + ChatColor.LIGHT_PURPLE + "'s Player information;" + ChatColor.RESET +"-----");
                        sender.sendMessage(ChatColor.AQUA + "- First Joined (GMT): " + ChatColor.WHITE + ofirstjoin);
                        sender.sendMessage(ChatColor.AQUA + "- Join Time(GMT): " + ChatColor.WHITE + lastjointime);
                        sender.sendMessage(ChatColor.AQUA + "- IP Address: " + ChatColor.WHITE +  PlayerNameData.filegetdata(target.getPlayer(), "ipAddress"));
                        sender.sendMessage(ChatColor.AQUA + "- Gamemode: " + ChatColor.WHITE + target.getGameMode());
                        sender.sendMessage(ChatColor.AQUA + "- XP: " + ChatColor.WHITE + target.getExpToLevel());
                        sender.sendMessage(ChatColor.AQUA + "- World: " + ChatColor.WHITE + target.getWorld().getName());
                        if (sender.isOp()) { sender.sendMessage(ChatColor.AQUA + "- Health: " + ChatColor.WHITE + target.getHealth());}
                        sender.sendMessage(ChatColor.AQUA + "- Keep Inventory: " + ChatColor.WHITE + okeepinven);
                        if (sender.hasPermission("<FP>.avanish")) { sender.sendMessage(ChatColor.AQUA + "- Vanished: " + ChatColor.WHITE + ovanished);}
                        return false;
                    }
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "Incorrect arguments! /seen [Playername]");
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "This is a staff only command!");

            }
        }
        return true;
    }
}