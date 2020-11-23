package England.Origin.FirstPlugin.Commands.Infomation;

import England.Origin.FirstPlugin.Data.PlayerNameData;
import England.Origin.FirstPlugin.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

import static England.Origin.FirstPlugin.Commands.Player.afk.afkplayers;

/**
 * Created by Joes_room on 18/12/2016.
 */
public class list implements CommandExecutor {
    private ArrayList<Player> onlineplayers = new ArrayList<>();
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("list")) {
            int max = Main.instance.getServer().getMaxPlayers();
            int current = Main.instance.getServer().getOnlinePlayers().size();
            int acurrent = current;
            if (current == 0) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "Currently there are no players online!");
                return false;
            }
            for(Player online : Main.instance.getServer().getOnlinePlayers()) {
                onlineplayers.add(online);
            }
            StringBuilder stringOnline = new StringBuilder();
            StringBuilder stringOnlinev = new StringBuilder();
            for (int i = 0; i < onlineplayers.size(); i++) {
                if (PlayerNameData.filegetdata(onlineplayers.get(i), "vanish") == null) {
                    stringOnline.append(onlineplayers.get(i).getDisplayName() + ", ");
                } else {
                    current -= 1;
                }

                if (afkplayers.contains(onlineplayers.get(i))) {
                    stringOnlinev.append(ChatColor.translateAlternateColorCodes('&', "&f[&7AFK&f]") +  onlineplayers.get(i).getDisplayName() + ", ");
                } else {
                    stringOnlinev.append(onlineplayers.get(i).getDisplayName() + ", ");
                }
            }

            if (sender.hasPermission("<FP>.vanish.see>")) {
                sender.sendMessage(ChatColor.AQUA + "There are currently, " + acurrent + "/" + max + " players online!");
                sender.sendMessage(ChatColor.YELLOW + "All online players: " + ChatColor.RESET + stringOnlinev.toString());
                sender.sendMessage(ChatColor.GRAY + "Type /staff to view all online staff!");
                onlineplayers.clear();
                return false;
            }

            if (current == 0){
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "There are no staff currently online!");
                onlineplayers.clear();
                return false;
            }
            sender.sendMessage(ChatColor.AQUA + "There are currently, " + current + "/" + max + "  players online!");
            sender.sendMessage(ChatColor.YELLOW + "All online players: " + ChatColor.RESET + stringOnline.toString());
            sender.sendMessage(ChatColor.GRAY + "Type /staff to view all online staff!");

            onlineplayers.clear();

        }
        return true;
    }
}
