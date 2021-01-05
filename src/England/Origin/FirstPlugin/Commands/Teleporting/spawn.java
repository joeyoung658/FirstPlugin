package England.Origin.FirstPlugin.Commands.Teleporting;
//Spawn Command
import England.Origin.FirstPlugin.Data.Back;
import England.Origin.FirstPlugin.Main;
import England.Origin.FirstPlugin.Player.Teleporting;
import England.Origin.FirstPlugin.utli.serverMessages;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;




public class spawn implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("spawn")) {
            FileConfiguration fileConfiguration = Main.instance.getConfig();
            Location spawnLoc = fileConfiguration.getLocation("spawn");
            if (spawnLoc == null){
                sender.sendMessage(new serverMessages().getServerPrefix() + "Spawn has not been set!");
                return false;
            }

            if (args.length == 0) {
                if (!(sender instanceof Player)) return new serverMessages().sendPlayerOnlyError(sender);
                Back.backsave(((Player) sender).getPlayer());
                Teleporting.delay(((Player) sender), spawnLoc.getWorld().getName(),
                        spawnLoc.getBlockX(),
                        spawnLoc.getBlockY(),
                        spawnLoc.getBlockZ(),
                        spawnLoc.getYaw(),
                        spawnLoc.getPitch());
                return false;
            }
            if (args.length == 1) {
                if (!(sender.hasPermission("<FP>.SPAWN"))) return new serverMessages().sendPermError(sender);
                    Player target = Bukkit.getPlayerExact(args[0]); //checks to see if first argument is online
                    if (target == null) return new serverMessages().sendPlayerNotOnlineError(sender, args[0]);
                    Back.backsave(target);
                    target.teleport(spawnLoc);
                    target.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.GRAY + "An admin has teleported you to spawn.");
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.GRAY + args[0] + " has been teleported to spawn!");
                    return false;
            }
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.DARK_RED + "Incorrect arguments. /spawn");
        }
        return false;
    }
}