package England.Origin.FirstPlugin.Commands.Teleporting;

import England.Origin.FirstPlugin.Data.ChangeData;
import England.Origin.FirstPlugin.Data.GetData;
import England.Origin.FirstPlugin.Data.StringToInt;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by josep on 13/02/2017.
 */
public class ahome implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("ahome")) {
            if (sender.hasPermission("<FP>.home.ahome")){
            if (args.length == 3) {
                if (args[0].equalsIgnoreCase("increase")){
                    Player target = Bukkit.getPlayerExact(args[1]);
                    if (target == null) { //if player isnt online
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ")  +ChatColor.DARK_RED + args[1] + " is not online!");
                        return false;
                    }
                    int incraseamount = StringToInt.String_To_Int_Convert(args[2]);
                    if (incraseamount == 0) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ")  +ChatColor.RED + "Please input a value which is 0 or above.");
                        return false;
                    }
                    int newamount = GetData.filegetdataint(target, "homeamount") + incraseamount;
                    ChangeData.changedataint(target, "homeamount", newamount);
                    sender.sendMessage(ChatColor.AQUA + "Increased " + target.getDisplayName() + ChatColor.AQUA + "'s homes by " + args[2]);
                } else if (args[0].equalsIgnoreCase("decrease")) {
                    Player target = Bukkit.getPlayerExact(args[1]);
                    if (target == null) { //if player isnt online
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ")  +ChatColor.DARK_RED + args[1] + " is not online!");
                        return false;
                    }
                    int incraseamount = StringToInt.String_To_Int_Convert(args[2]);
                    if (incraseamount == 0) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ")  +ChatColor.RED + "Please input a value which is 0 or above.");
                        return false;
                    }
                    int newamount = GetData.filegetdataint(target, "homeamount") - incraseamount;
                    ChangeData.changedataint(target, "homeamount", newamount);
                    sender.sendMessage(ChatColor.AQUA + "Decreased " + target.getDisplayName() + ChatColor.AQUA + "'s homes by " + args[2]);
                }  else {
                    sender.sendMessage(ChatColor.AQUA  + "/ahome [increase] [Player] [Amount]");
                    sender.sendMessage(ChatColor.AQUA  + "/ahome [decrease] [Player] [Amount]");
                    sender.sendMessage(ChatColor.AQUA  + "/ahome [check] [Player]");
                }
            } else if (args.length == 2){
                if (args[0].equalsIgnoreCase("check")) {
                    Player target = Bukkit.getPlayerExact(args[1]);
                    if (target == null) { //if player isnt online
                        sender.sendMessage(ChatColor.DARK_RED + args[1] + " is not online!");
                        return false;
                    }
                    sender.sendMessage(target.getDisplayName() +  ChatColor.AQUA + " has " +  GetData.filegetdataint(target, "homeamount") + " homes.");
                } else {
                    sender.sendMessage(ChatColor.AQUA  + "/ahome [increase] [Player] [Amount]");
                    sender.sendMessage(ChatColor.AQUA  + "/ahome [decrease] [Player] [Amount]");
                    sender.sendMessage(ChatColor.AQUA  + "/ahome [check] [Player]");
                }
                }else {
                sender.sendMessage(ChatColor.AQUA  + "/ahome [increase] [Player] [Amount]");
                sender.sendMessage(ChatColor.AQUA  + "/ahome [decrease] [Player] [Amount]");
                sender.sendMessage(ChatColor.AQUA  + "/ahome [check] [Player]");
            }

            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ")  +ChatColor.RED + "This is a admin only command!");
            }

        }
        return true;
    }
}