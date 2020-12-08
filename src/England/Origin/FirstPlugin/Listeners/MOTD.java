package England.Origin.FirstPlugin.Listeners;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MOTD implements Listener {
        /**
        @motdl Arraylist of all the different MOTD messages that can display to the end user
                Spacing needs to be taken into consideration as it hugs to the left by default
         **/
        List<String> motdl = new ArrayList<String>(); {
        {
            motdl.add(ChatColor.GREEN + "     Vote " + ChatColor.AQUA + " for our server" + ChatColor.GREEN + " daily " + ChatColor.AQUA + "for great rewards!");
            motdl.add(ChatColor.AQUA + "Check out our" + ChatColor.GREEN + " Website! " + ChatColor.RED+" Type " +ChatColor.AQUA + "/website for more info!");
            motdl.add(ChatColor.AQUA + "   Join our" + ChatColor.GREEN + " Discord!" + ChatColor.RED+" Type " +ChatColor.AQUA + "/discord for more info!");
            //motdl.add(ChatColor.AQUA + "       Join the" + ChatColor.GREEN + " Builder Of The Month " + ChatColor.RED +"competition!");
            motdl.add(ChatColor.AQUA + "              All Ace is love. " + ChatColor.GREEN + "All Ace is life.");

            if (Bukkit.getServer().getVersion().contains("1.16.4")) {
            motdl.add(ChatColor.AQUA + "             AllAce is updated " + ChatColor.GREEN + "to 1.16.4!");
            }

            //motdl.add(ChatColor.AQUA + "        eM " + ChatColor.RED + "wishes you a very " + ChatColor.GREEN + "Merry Christmas! ");
        }}

    /**
     * When the client pings the server, displays a random message from an array
     * @param event
     */
    @EventHandler
    public void onServerListPing(ServerListPingEvent event) {
                Random rand = new Random();
                int  randomint = rand.nextInt(motdl.size()) + 0;
                event.setMotd(ChatColor.YELLOW + "                   -"+ChatColor.GREEN+"-"+ChatColor.RED+"-"+ChatColor.YELLOW+"-"+ChatColor.RED+
                        "All Ace"+ChatColor.GREEN+"-"+ChatColor.YELLOW+"-"+ChatColor.RED+"-"+ChatColor.GREEN+"-\n"+motdl.get(randomint));

        //event.setMotd(ChatColor.BLUE + "                       www.Exhibit-Minecraft.com\n"+motdl.get(randomint));

        }
}
