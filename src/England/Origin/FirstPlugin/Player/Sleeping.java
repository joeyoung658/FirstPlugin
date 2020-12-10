package England.Origin.FirstPlugin.Player;

import England.Origin.FirstPlugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

import java.util.ArrayList;

import static England.Origin.FirstPlugin.Commands.Admin.vanish.vanishtoggle;
import static England.Origin.FirstPlugin.Commands.Player.afk.afkplayers;



/**
 * Created by josep on 27/05/2017.
 */
public class Sleeping implements Listener {


    private ArrayList<Player> sleepingplayers = new ArrayList<>();

    @EventHandler
    public void onPlayerSleep(PlayerBedEnterEvent event) {
        if (isDay()){
            return;
        }
        if (Main.instance.sleepToggleBypass == 0){
            return;
        }
        String playerWorld = event.getPlayer().getWorld().getName();
        if (playerWorld.contains("end") || playerWorld.contains("nether")) {
            return;
        }
        int onlinePlayers = Main.instance.getServer().getOnlinePlayers().size();

        if (afkplayers.size() != 0) {
            if (onlinePlayers == afkplayers.size()) {
                return;
            }
        }
        if (!(sleepingplayers.contains(event.getPlayer()))) {
            sleepingplayers.add(event.getPlayer());
        }
        int theAmountOfPlayersInBed = sleepingplayers.size();
        if (theAmountOfPlayersInBed == 0){
            return;
        }

        int theAmountOfPeopleRequiredToSleep =
                ((onlinePlayers
                        - (afkplayers.size() + vanishtoggle.size() + endAndNetherPlayers())) / 2);


        if (theAmountOfPlayersInBed >= theAmountOfPeopleRequiredToSleep){
            //The amount of "units" in a minecraft "day"
            long dayUnit = 24000;
            //Gets the server current time
            long time = Bukkit.getServer().getWorld("AllAce").getTime();
            //Gets the amount of "days" that have passed since the initial "day"
            long daysPassed = (time/dayUnit);
            //Get Next Day
            long nextDay = Math.round(daysPassed) + 1;
            long newTime = nextDay * dayUnit;
            Bukkit.getServer().getWorld("AllAce").setTime(newTime);
            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "At least 50%" +
                    " of the server was sleeping, so the night has passed.");
        } else {
            int x = (theAmountOfPeopleRequiredToSleep);
            int y = sleepingplayers.size();
            int xy = x - y;
            event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "There are not enough players" +
                    " currently in bed. " +  xy + " more players are needed in bed for night to pass.");
        }
    }

    @EventHandler
    public void onPlayerLeaveBed(PlayerBedLeaveEvent event) {
        if (sleepingplayers.contains(event.getPlayer())) {
            sleepingplayers.remove(event.getPlayer());
        }
    }

    public boolean isDay() {
        long time = Bukkit.getWorld("AllAce").getTime() % 24000;
        return time < 12300 || time > 23850;
    }

    private int endAndNetherPlayers() {
        int end = 0;
        int nether = 0;
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.getLocation().getWorld().getName().contains("end")){
                end = end + 1;
            }
            if (p.getLocation().getWorld().getName().contains("nether")){
                nether = nether + 1;
            }
        }
        return end + nether;
    }
}