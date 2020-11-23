package England.Origin.FirstPlugin.Commands;

//import England.Origin.FirstPlugin.Main;
//import com.google.common.io.ByteArrayDataOutput;
//import com.google.common.io.ByteStreams;
//import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by josep on 30/08/2017.
 */
public class hub implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("hub")) {
            if (!(sender instanceof Player)){
                sender.sendMessage("This command can only be run by a player");
                return true;
            } else {
                sender.sendMessage("This command is currently disabled");
            }
//            ByteArrayDataOutput out = ByteStreams.newDataOutput();
//
//            out.writeUTF("Connect");
//            out.writeUTF("Hub");
//
//            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") + ChatColor.AQUA + "You are being sent to the Hub!");
//            ((Player) sender).sendPluginMessage(Main.instance, "BungeeCord", out.toByteArray());

        }

        return true;
    }
}
