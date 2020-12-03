package England.Origin.FirstPlugin.Commands.Player;

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
 * Created by josep on 27/05/2017.
 */



//todo improve usability
public class prefix implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        List<String> Staffw = new ArrayList<String>(); {
            {
                Staffw.add(ChatColor.WHITE + "[" + ChatColor.DARK_RED + "Auto-Reports" + ChatColor.WHITE + "] " + ChatColor.GREEN + sender.getName() + " attempted to impersonate a staff member!");
                Staffw.add(ChatColor.WHITE + "[" + ChatColor.DARK_RED + "Auto-Reports" + ChatColor.WHITE + "] " + ChatColor.GREEN + sender.getName() + " attempted to impersonate a Rank member!");
            }}

        if (cmd.getName().equalsIgnoreCase("prefix")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +"This command can only be run by a player!");
                return false;
            }
            if (!(sender.hasPermission("<FP>.prefix"))) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e[&4Server&e]&f ") + "You do not have permission to use this command!");
                return false;
            }

            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("remove")) {
                    if (PlayerNameData.changedata(((Player) sender), "prefix", "&e")) {
                        PlayerNameData.namesetter(((Player) sender));
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e[&4Server&e]&f ") + ChatColor.AQUA + "Your Prefix has been removed!");
                        return true;
                    }
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e[&4Server&e]&f ") + ChatColor.RED + "Your prefix was not removed");
                    return true;


                } else if (args[0].equalsIgnoreCase("restore")) {
                    if (!(sender.hasPermission("<FP>.prefix"))) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e[&4Server&e]&f ") + "You do not have permission to use this command!");
                        return false;
                    }
                    if (PlayerNameData.changedata(((Player) sender), "prefix", null)) {
                        PlayerNameData.namesetter(((Player) sender));
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e[&4Server&e]&f ") + ChatColor.AQUA + "Your Prefix default has been restored!");
                        return true;
                    }

                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e[&4Server&e]&f ") + ChatColor.RED + "Your default prefix was not restored!");
                    return true;

                } else {

                    sender.sendMessage(ChatColor.RED + "Incorrect arguments!");
                    sender.sendMessage(ChatColor.AQUA + "/prefix remove - Removes your prefix");
                    sender.sendMessage(ChatColor.AQUA + "/prefix restore - Restores your prefix");
                    sender.sendMessage(ChatColor.AQUA + "/prefix custom [CustomPrefix] - Ability to add a custom prefix");


                }
            }else if (args.length == 2) {



                    if (args[0].equalsIgnoreCase("custom")) { //Enables user to set a custom prefix
                    if (sender.hasPermission("<FP>.apcustom")) {

                            if (args[1] == null) {
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e[&4Server&e]&f ") + ChatColor.AQUA  + " Incorrect arguments. Type /prefix for help.");
                            }

                            String e = args[1];
                            if (!(sender.hasPermission("<FP>.BYPASSCP"))) {
                                if (e.toLowerCase().contains("admin") || e.toLowerCase().contains("helper") || e.toLowerCase().contains("builder") || e.toLowerCase().contains("moderator") ||
                                        e.toLowerCase().contains("staff") || e.toLowerCase().contains("mod")) {
                                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e[&4Server&e]&f ") + ChatColor.AQUA + "Do not try to impersonate a member of staff. Staff have been notified");
                                    for (Player p : Bukkit.getOnlinePlayers()) { //gets all online players
                                        if (p.hasPermission("<FP>.REPORT.R")) { //check if they have certain permission
                                            p.sendMessage(Staffw.get(0)); //sends the message to the user
                                        }
                                    }
                                    return false;
                                } else if (e.toLowerCase().contains("omega") || e.toLowerCase().contains("alpha") || (e.toLowerCase().contains("botm") || (e.toLowerCase().contains("voting")))) {
                                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e[&4Server&e]&f ") + ChatColor.AQUA + "Do not try to impersonate another rank. Staff have been notified");
                                    for (Player p : Bukkit.getOnlinePlayers()) { //gets all online players
                                        if (p.hasPermission("<FP>.REPORT.R")) { //check if they have certain permission
                                            p.sendMessage(Staffw.get(0)); //sends the message to the user
                                        }
                                    }
                                    return false;
                                }
                            }
                            if (e.toCharArray().length < 15) {
                                if (PlayerNameData.changedata(((Player) sender), "prefix", "&f[" + e + "&f]&e")) {
                                    PlayerNameData.namesetter(((Player) sender));
                                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e[&4Server&e]&f ") + ChatColor.AQUA + "Custom prefix added!");
                                } else {
                                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e[&4Server&e]&f ") + ChatColor.RED + "Custom prefix adding failed!");
                                }
                            } else {
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e[&4Server&e]&f ") + ChatColor.AQUA + "Prefix needs to be less than 15 characters");
                            }

                    } else {

                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e[&4Server&e]&f ") + ChatColor.DARK_RED + "You do not have permission todo this.");
                    }
                } else {

                        sender.sendMessage(ChatColor.RED + "Incorrect arguments!");
                        sender.sendMessage(ChatColor.AQUA + "/prefix remove - Removes your prefix");
                        sender.sendMessage(ChatColor.AQUA + "/prefix restore - Restores your prefix");
                        sender.sendMessage(ChatColor.AQUA + "/prefix custom [CustomPrefix] - Ability to add a custom prefix");


                    }
            } else {

                    sender.sendMessage(ChatColor.RED + "Incorrect arguments!");
                    sender.sendMessage(ChatColor.AQUA + "/prefix remove - Removes your prefix");
                    sender.sendMessage(ChatColor.AQUA + "/prefix restore - Restores your prefix");
                    sender.sendMessage(ChatColor.AQUA + "/prefix custom [CustomPrefix] - Ability to add a custom prefix");


                }

        }
        return true;
    }

}
