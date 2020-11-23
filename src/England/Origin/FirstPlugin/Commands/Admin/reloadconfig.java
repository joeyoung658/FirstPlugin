package England.Origin.FirstPlugin.Commands.Admin;



import England.Origin.FirstPlugin.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class reloadconfig implements CommandExecutor {



    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("fp-reload")) {
            if (!sender.hasPermission("fpreload.reload")) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f &cThis is an admin only command!"));
                return true;
            }
            //Main.instance.reloadConfiguration();
            //PlayTimeMove.PlayTimeMovem();
            Main.instance.saveDefaultConfig();
            Main.instance.reloadConfig();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.GREEN + "First Plugin config reloaded");
            return true;
        }
        return false;
    }
}
