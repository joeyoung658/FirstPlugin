package England.Origin.FirstPlugin.Commands.Admin;

import England.Origin.FirstPlugin.Main;
import England.Origin.FirstPlugin.utli.serverMessages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

/**
 * @author Joseph Young on 05/01/2021
 * @github https://github.com/joeyoung658
 */
public class setSpawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("setspawn")){
            if (!(sender instanceof Player)) return new serverMessages().sendPlayerOnlyError(sender);
            if (!sender.hasPermission("<FP>.setspawn")) return new serverMessages().sendPermError(sender);
            FileConfiguration configuration =  Main.instance.getConfig();
            configuration.set("spawn", ((Player) sender).getLocation());
            Main.instance.saveConfig();
            sender.sendMessage(new serverMessages().getServerPrefix() + "Spawn has been set successfully!");
        }
        return false;
    }
}
