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
public class onlinestaff implements CommandExecutor {
    private ArrayList<Player> onlinestaff = new ArrayList<>();
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("staff")) {
            int max = Main.instance.getConfig().getInt("staffcount");

            //int current = Main.instance.getServer().getOnlinePlayers().size();

            for(Player online : Main.instance.getServer().getOnlinePlayers()) {
                if (online.hasPermission("<FP>.staff")) {
                    onlinestaff.add(online);
                }
            }

            int current = onlinestaff.size();
            int acurrent = current;



            StringBuilder staffonlinev = new StringBuilder();
            StringBuilder staffonlinenv = new StringBuilder();
            for (int i = 0; i < onlinestaff.size(); i++) {
                if (PlayerNameData.filegetdata(onlinestaff.get(i), "vanish") == null) {
                    staffonlinev.append(onlinestaff.get(i).getDisplayName() + ", ");
                } else {
                    current -= 1;
                }

                if (afkplayers.contains(onlinestaff.get(i))) {
                    staffonlinenv.append(ChatColor.translateAlternateColorCodes('&', "&f[&7AFK&f]") +  onlinestaff.get(i).getDisplayName() + ", ");
                } else {
                    staffonlinenv.append(onlinestaff.get(i).getDisplayName() + ", ");
                }


            }

            if (sender.hasPermission("<FP>.vanish.see>")) {
                sender.sendMessage(ChatColor.AQUA + "There are currently, " + acurrent + "/" + max + "  staff online!");
                sender.sendMessage(ChatColor.YELLOW + "All online staff: " + ChatColor.RESET + staffonlinenv.toString());
                sender.sendMessage(ChatColor.GRAY + "Type /online to view all online players!");
                onlinestaff.clear();
                return false;
            }

            if (current == 0){
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "There are no staff currently online!");
                onlinestaff.clear();
                return false;
            }

            sender.sendMessage(ChatColor.AQUA + "There are currently, " + current + "/" + max + "  staff online!");
            sender.sendMessage(ChatColor.YELLOW + "All online staff: " + ChatColor.RESET + staffonlinev.toString());
            sender.sendMessage(ChatColor.GRAY + "Type /online to view all online players!");

            onlinestaff.clear();

        }
        return true;
    }
}
