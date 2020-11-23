package England.Origin.FirstPlugin.Broadcasting;


import England.Origin.FirstPlugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Broadcasting {
    public static List<Player> tiptoggle = new ArrayList<>();
    public static void Broad() {
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
            @Override
            public void run() {
                List<String> Tip = Main.instance.getConfig().getStringList("tips");
                if (Tip == null)
                {
                    return;
                }
                Random rand = new Random();
                int  TipC = rand.nextInt(Tip.size()) + 0;
                for (Player p : Bukkit.getOnlinePlayers()) { //gets all online players
                    if (!(tiptoggle.contains(p))) { //check if they have certain permission
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "[&4Tip&f] " + Tip.get(TipC))); //sends the message to the user
                    }
                }
                Broad();
            }
        }, 20l * 60 * 30);
    }
    public static void voter() {
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage(ChatColor.AQUA + "-=-=-=-=-=-=-=-=-=-=-=-" + ChatColor.RED + "AllAce" + ChatColor.AQUA + "-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                Bukkit.broadcastMessage(ChatColor.GOLD + "                          Don't forget to vote today!"  );
                Bukkit.broadcastMessage("          If you enjoy playing on our server, please vote now.");
                Bukkit.broadcastMessage("             Vote by typing " + ChatColor.GREEN + "/vote" + ChatColor.RESET + " and following the links."  );
                Bukkit.broadcastMessage(ChatColor.AQUA + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                voter();
            }
        }, 20l * 60 * 25 );

    }

}


