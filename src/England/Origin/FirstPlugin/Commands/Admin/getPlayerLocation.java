package England.Origin.FirstPlugin.Commands.Admin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class getPlayerLocation implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("getcords")) {
              //Checks how many arguments have been given
               if (args.length == 0) {
                   /**
                    * Only run if the sender is a player
                    */
                   if (!(sender instanceof Player)) {
                       sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e[&4Server&e]&f ") + "This command can only be run by players!");
                       return true;
                   }
                   //Gets the players location & sends it to the sender
                   Location location = ((Player) sender).getLocation();
                   sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e[&4Server&e]&f ")
                           + ChatColor.AQUA + "Your location is: " + location.toString());
                   return true;
               } else if (args.length == 1){
                   try {
                       Player target = Bukkit.getPlayerExact(args[0]);
                       if (target == null){
                           throw new Exception("Player is not online!");
                       } else {
                           Location targetLocation = target.getLocation();
                           sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e[&4Server&e]&f ")
                                   + ChatColor.AQUA + target.getDisplayName()  + " location is " + targetLocation.toString());
                       }
                   }catch (Exception E){
                       sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e[&4Server&e]&f ") + ChatColor.RED + "ERROR: Correct usage /getcords [Playername] - The player must be online!");
                       return true;
                   }
               }
        }
        return true;
    }
}
