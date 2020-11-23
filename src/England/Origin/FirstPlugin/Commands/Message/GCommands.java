package England.Origin.FirstPlugin.Commands.Message;

//Group Chat Commands


import England.Origin.FirstPlugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.Console;


public class GCommands implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        StringBuilder b = new StringBuilder(); // Coverts args into long string
        for (int i = 0; i < args.length; i++)
            b.append(args[i] + " ");


        if (label.equalsIgnoreCase("sc")) {
            if (!(sender instanceof Player)) {
                //sender.sendMessage("This command can only be run by a player!");
                for (Player p : Bukkit.getOnlinePlayers()) { //gets all online players
                    if (p.hasPermission("<FP>.AC.R")) { //check if they have certain permission
                        p.sendMessage(ChatColor.WHITE + "[" + ChatColor.GREEN + "Admin-Chat" + ChatColor.WHITE + "]" + ChatColor.RED + " Console" + ChatColor.WHITE + ": "  + ChatColor.translateAlternateColorCodes('&',b.toString())); //sends the message to the user
                    }
                }
                Main.instance.getLogger().info("Admin Chat - Console:" + b.toString());
                return true;
            }
            if (sender.isOp() || sender.hasPermission("<FP>.AC")) {
                if (args.length == 0) {
                    sender.sendMessage(ChatColor.DARK_RED + "Incorrect usage - /ac [Message]"); //If user does not add a message
                } else {
                    for (Player p : Bukkit.getOnlinePlayers()) { //gets all online players
                        if (p.hasPermission("<FP>.AC.R")) { //check if they have certain permission
                            p.sendMessage(ChatColor.WHITE + "[" + ChatColor.GREEN + "Staff-Chat" + ChatColor.WHITE + "] " + ((Player) sender).getDisplayName() + ": " +  ChatColor.translateAlternateColorCodes('&',b.toString())); //sends the message to the user
                        }
                    }
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.DARK_RED + "Incorrect Permissions to talk in staff chat!");
            } //if they do not have original permission
        }

        if (label.equalsIgnoreCase("dc")) { //same as above
            if (!(sender instanceof Player)) {
                //sender.sendMessage("This command can only be run by a player!");
                for (Player p : Bukkit.getOnlinePlayers()) { //gets all online players
                    if (p.hasPermission("<FP>.DC.R")) { //check if they have certain permission
                        p.sendMessage(ChatColor.WHITE + "[" + ChatColor.DARK_PURPLE + "Donor-Chat" + ChatColor.WHITE + "]" + ChatColor.RED + " Console" + ChatColor.WHITE + ": " +ChatColor.translateAlternateColorCodes('&', b.toString()));
                    }
                }
                Main.instance.getLogger().info("Donor Chat - Console:" + b.toString());
                return true;
            }
            if (sender.isOp() || sender.hasPermission("<FP>.DC")) {
                if (args.length == 0){
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.DARK_RED + "Incorrect usage - /dc [Message]");
                } else {
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        if (p.hasPermission("<FP>.DC.R")) {
                            p.sendMessage(ChatColor.WHITE + "[" + ChatColor.DARK_PURPLE + "Donor-Chat" + ChatColor.WHITE + "] " + ((Player) sender).getDisplayName() + ": " + ChatColor.translateAlternateColorCodes('&', b.toString()));
                        }
                    }
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.DARK_RED + "Incorrect Permissions to talk in Donor chat!"); }
        }

        if (label.equalsIgnoreCase("bc")) { //same as above
            if (!(sender instanceof Player)) {
                //sender.sendMessage("This command can only be run by a player!");
                for (Player p : Bukkit.getOnlinePlayers()) { //gets all online players
                    if (p.hasPermission("<FP>.BC.R"))  { //check if they have certain permission
                        p.sendMessage(ChatColor.WHITE + "[" + ChatColor.GOLD + "Builder-Chat" + ChatColor.WHITE + "]" + ChatColor.RED + " Console" + ChatColor.WHITE + ": " +ChatColor.translateAlternateColorCodes('&', b.toString()));
                    }
                }
                Main.instance.getLogger().info("Builder Chat - Console: " + b.toString());
                return true;
            }
            if (sender.isOp() || sender.hasPermission("<FP>.BC")) {
                if (args.length == 0){
                    sender.sendMessage(ChatColor.DARK_RED + "Incorrect usage - /dc [Message]");
                } else {
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        if (p.hasPermission("<FP>.BC.R")) {
                            p.sendMessage("[" + ChatColor.GOLD + "Builder-Chat" + ChatColor.WHITE + "] " + ((Player) sender).getDisplayName() + ": " +
                                    ChatColor.translateAlternateColorCodes('&', b.toString()));
                        }
                    }
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.DARK_RED + "Incorrect Permissions to talk in builder chat!"); }
        }


            return false; //ends commands statement
        }
    }







