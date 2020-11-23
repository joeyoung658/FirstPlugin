package England.Origin.FirstPlugin.Commands.Chat;

import England.Origin.FirstPlugin.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by josep on 12/04/2017.
 */
public class Censor implements CommandExecutor, Listener {
    public static List<Player> censoron = new ArrayList<>();
    private static String message;


    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        //Player p = e.getPlayer();
        Boolean censor = false;
        message = e.getMessage();

        for(String cword : Main.instance.getConfig().getStringList("censor")){
            for(String mword : message.split(" ")){
                if(mword.toLowerCase().equalsIgnoreCase(cword.toLowerCase())) {
                    censor = true;

                    int starlength = cword.length();
                    StringBuilder stars = new StringBuilder();
                    for (int i = 0; i < starlength; i++)
                        stars.append("*");

                    //replace isn't working - needs to be debugged - not e.message as it only replaces the last censored word within the string

                    message.replace(mword, stars.toString());


                    Bukkit.broadcastMessage(message);



                    //e.setMessage(message);
                }
            }
        }

        if (censor) {
            for (Player player : censoron) {
                e.getRecipients().remove(player);
                player.sendMessage("<"+ e.getPlayer().getDisplayName() + "> " + message );
            }
        }
    }



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) { {


        if (label.equalsIgnoreCase("censor")) {

            if (censoron.contains(sender)) {
                sender.sendMessage("off");
                censoron.remove(sender);
                return true;
            }
            sender.sendMessage("on");
            censoron.add((Player) sender);
            return true;

        }
            return true;
        }
    }
}
