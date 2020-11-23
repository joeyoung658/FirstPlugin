package England.Origin.FirstPlugin.Commands.Player;

import England.Origin.FirstPlugin.Data.StringToFloat;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;




/**
 * Created by josep on 01/06/2017.
 */
public class speed implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        String errormsg = (ChatColor.RED + "Error: Correct usage /speed [(10) - 10]");

        if (cmd.getName().equalsIgnoreCase("speed")) {

            if (args.length == 1) {
                if (!(sender instanceof Player)) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") + " This command can only be run by players!");
                    return true;
                }

                if (!(sender.hasPermission("<FP>.speed"))) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") + ChatColor.RED + " You do not have permission to use this command!");
                    return true;
                }

                Player player = ((Player) sender).getPlayer();
                float choosenSpeed = StringToFloat.String_To_Float_Convert(args[0]);
                if (choosenSpeed >= 11.0){
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") + errormsg);
                    return false;
                }

                if (choosenSpeed <= -11.0){
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") + errormsg);
                    return false;

                }

                choosenSpeed = choosenSpeed / 10;

                if (player.isFlying()) {
                    player.setFlySpeed(choosenSpeed);
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") + ChatColor.AQUA +  "Your flying speed has been set to " + choosenSpeed);
                    return false;
                } else {
                    player.setWalkSpeed(choosenSpeed);
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") + ChatColor.AQUA +  "Your walking speed has been set to " + choosenSpeed);
                    return false;
                }


            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") + errormsg);
            }
        }

    return true;
    }

    }



