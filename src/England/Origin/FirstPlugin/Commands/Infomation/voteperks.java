package England.Origin.FirstPlugin.Commands.Infomation;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by josep on 27/03/2017.
 */
public class voteperks implements CommandExecutor{


        @Override
        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            if (cmd.getName().equalsIgnoreCase("voteperks")) {
                sender.sendMessage(ChatColor.YELLOW + "------------------Voting Perks!------------------");
                sender.sendMessage(ChatColor.AQUA + "eCoins which allow you to buy perks in games");
                sender.sendMessage(ChatColor.YELLOW + "-------------------------------------------------");
                return true;
            }
            return true;
        }


}
