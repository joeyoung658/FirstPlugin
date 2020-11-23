package England.Origin.FirstPlugin.Commands.Teleporting;
//Spawn Command
import England.Origin.FirstPlugin.Listeners.Back;
import England.Origin.FirstPlugin.Player.Teleporting;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class Spawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("spawn")) {
            if (args.length == 0) {
                if (!(sender instanceof Player)) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +"This command can only be run by players!");
                    return true;
                }
                Back.backsave(((Player) sender).getPlayer());
                Teleporting.delay(((Player) sender), "AllAce",  -46, 104, -124, 2, 0);
            } else if (args.length == 1) {
                if (sender.hasPermission("<FP>.SPAWN")) {
                    Player target = Bukkit.getPlayerExact(args[0]); //checks to see if first argument is online
                    if (target == null) { //if player isn't not online do below
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + args[0] + " is not online!");
                    } else {
                        Back.backsave(target);
                        target.teleport(new Location(Bukkit.getWorld("AllAce"),  -46, 104, -124, 2, 0));
                        target.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.GRAY + "An admin has teleported you to spawn.");
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.GRAY + args[0] + " has been teleported to spawn!");
                    }
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.DARK_RED + "Incorrect arguments. /spawn");
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.DARK_RED + "Incorrect arguments. /spawn");
            }
        }
        return false;
    }
}
//4275.5 67.00 -4894.5