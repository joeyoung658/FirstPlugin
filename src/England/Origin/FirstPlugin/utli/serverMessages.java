package England.Origin.FirstPlugin.utli;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.awt.*;

/**
 * @author Joseph Young on 05/01/2021
 * @github https://github.com/joeyoung658
 */
public class serverMessages {




    public String getServerPrefix(){
        return ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ");
    }

    public boolean sendPermError(CommandSender sender){
        sender.sendMessage(this.getServerPrefix() + ChatColor.RED + "You do not have permission todo this!");
        return false;
    }

    public boolean sendPlayerOnlyError(CommandSender sender){
        sender.sendMessage(this.getServerPrefix() + ChatColor.RED + "This command may only be used by a player!");
        return false;
    }

    public boolean sendPlayerNotOnlineError(CommandSender sender, String target){
        sender.sendMessage(this.getServerPrefix() + ChatColor.RED + target + " is not online!");
        return false;
    }

}
