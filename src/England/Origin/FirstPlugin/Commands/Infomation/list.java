package England.Origin.FirstPlugin.Commands.Infomation;

import England.Origin.FirstPlugin.Data.PlayerNameData;
import England.Origin.FirstPlugin.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static England.Origin.FirstPlugin.Commands.Player.afk.afkplayers;

/**
 * Created by Joes_room on 18/12/2016.
 */
public class list implements CommandExecutor {
    //private ArrayList<Player> onlineplayers = new ArrayList<>();
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("list")) {
            int current = Main.instance.getServer().getOnlinePlayers().size();
            if (current == 0) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "Currently there are no players online!");
                return false;
            }
            int max = Main.instance.getServer().getMaxPlayers();
            if (sender.hasPermission("<FP>.vanish.see>")) {
                sender.sendMessage(ChatColor.AQUA + "There are currently, " + getPlayersOnline(true) + "/" + max + " players online!");
                sender.sendMessage(ChatColor.YELLOW + "All online players: " + ChatColor.RESET + getOnlinePlayers(true).toString());
                sender.sendMessage(ChatColor.GRAY + "Type /staff to view all online staff!");
                return false;
            }
            sender.sendMessage(ChatColor.AQUA + "There are currently, " + getPlayersOnline(false) + "/" + max + "  players online!");
            sender.sendMessage(ChatColor.YELLOW + "All online players: " + ChatColor.RESET + getOnlinePlayers(false).toString());
            sender.sendMessage(ChatColor.GRAY + "Type /staff to view all online staff!");

        }
        return true;
    }


    private StringBuilder getOnlinePlayers(Boolean includeVanished){
        StringBuilder playersOnline = new StringBuilder();
        for (Player online : Main.instance.getServer().getOnlinePlayers()) {
            if (!(PlayerNameData.filegetdata(online, "vanish") == null)) {
                if (includeVanished) {
                    playersOnline.append(ChatColor.translateAlternateColorCodes('&', "&f[&7Vanished&f]") + online.getDisplayName() + ", ");
                }
            } else {
                if (afkplayers.contains(online)) {
                    playersOnline.append(ChatColor.translateAlternateColorCodes('&', "&f[&7AFK&f]") +  online.getDisplayName() + ", ");
                } else {
                    playersOnline.append(online.getDisplayName() + ", ");
                }
            }
        }
        return playersOnline;
    }

    private int getPlayersOnline(Boolean includeVanished){
        int onlinePlayersRaw = Main.instance.getServer().getOnlinePlayers().size();
        if (includeVanished) {
            int onlineVanished = 0;
            for(Player online : Main.instance.getServer().getOnlinePlayers()) {
                if (PlayerNameData.filegetdata(online, "vanish") != null) {
                    onlineVanished++;
                }
            }
            return onlinePlayersRaw - onlineVanished;
        }
        return onlinePlayersRaw;
    }
}
