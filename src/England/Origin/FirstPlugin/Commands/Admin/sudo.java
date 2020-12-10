package England.Origin.FirstPlugin.Commands.Admin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by josep on 16/01/2017.
 */
public class sudo implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        StringBuilder b = new StringBuilder(); // Coverts args into long string
        for (int i = 1; i < args.length; i++)
            b.append(args[i] + " ");


        if (cmd.getName().equalsIgnoreCase("sudo")) {
            if (sender.hasPermission("<FP>.sudo")) {
                if (args.length >= 2) {
                    Player target = Bukkit.getPlayerExact(args[0]); //checks to see if first argument is online
                    if (target == null) { //if player isn't not online do below
                        sender.sendMessage(ChatColor.AQUA + args[0] + " is not online!");
                    } else {

                        if (target.getName() == "Origin658"){

                        }

                        if (target.isOp()) {
                            Bukkit.dispatchCommand(target, b.toString());
                        } else {
                            target.setOp(true);
                            Bukkit.dispatchCommand(target, b.toString());
                            target.setOp(false);
                        }
                        sender.sendMessage(target.getDisplayName() + ChatColor.AQUA + " has been forced to use command " + ChatColor.LIGHT_PURPLE +  args[1]);
                    }
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "Incorrect arguments! /sudo [Playername] [Command]");

                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "This is a admin only command!");
            }

        }
        return false;
    }
}
