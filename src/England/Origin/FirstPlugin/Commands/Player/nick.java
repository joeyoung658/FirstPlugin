package England.Origin.FirstPlugin.Commands.Player;

import England.Origin.FirstPlugin.Data.ChangeData;

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
 * Created by Joes_room on 07/12/2016.
 */
public class nick implements CommandExecutor {



        @Override
        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            if (cmd.getName().equalsIgnoreCase("nick")) { //Enables user to set a custom prefix
                if (!(sender instanceof Player)) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +"This command can only be run by a player!");
                    return true;
                } else {
                    if (sender.hasPermission("<FP>.nick")){
                        if (args.length == 0) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.DARK_RED + "Incorrect arguments. /nick [Nick Name]");
                        } else if (args.length == 1) {
                            String nick = "~"+args[0];

                            if (!(sender.isOp())) {
                                if (!(nick.toCharArray().length < 32)) {
                                    sender.sendMessage(ChatColor.AQUA + "Nick needs to be less than 32 characters");
                                    return true;
                                }
                            }


                                if (ChangeData.changedatac(((Player) sender), "nick", nick)) {
                                    ((Player) sender).setDisplayName(ChatColor.translateAlternateColorCodes('&', PlayerNameData.checkforprefix(((Player) sender).getPlayer()) +
                                            nick + "&r"));
                                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "Your nick name is now " + ChatColor.translateAlternateColorCodes('&', nick));
                                } else {
                                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "nick name adding failed!");
                                }



                        } else {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.DARK_RED + "Incorrect argument!");
                        }
                } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "This is a donator only command, use /donate to find out more!");
                    }
                }
            } if (cmd.getName().equalsIgnoreCase("removenick")) {
                    if (args.length == 0) {
                        if (!(sender instanceof Player)) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +"This command can only be run by a player!");
                            return true;
                        } else {
                            if (sender.hasPermission("<FP>.nick")) {
                                if (ChangeData.changedatac(((Player) sender), "nick", null)) {
                                    PlayerNameData.namesetter(((Player) sender));
                                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "Your nick name is now off.");
                                } else {
                                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "Nick name adding failed!");
                                }
                                return false;
                            } else {
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "This is a donator only command, use /donate to find out more!");
                            }
                        }
                    } else if (args.length == 1) {
                        if (sender.hasPermission("<FP>.anick")) {
                            Player target = Bukkit.getPlayerExact(args[0]);
                            if (target == null) { //if player isnt online
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.DARK_RED + args[0] + " is not online!");
                            } else {
                                if (ChangeData.changedatac(target.getPlayer(), "nick", null)) {
                                    PlayerNameData.namesetter(((Player) sender));

                                    target.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.DARK_RED + "Your nick name has been removed by an admin!");
                                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "Players nick name has been removed!");
                                } else {
                                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "Nick name removal failed!");
                                }
                            }
                        }
                    }

            }
            return true;
        }
    }

