package England.Origin.FirstPlugin.Player;

import England.Origin.FirstPlugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.util.BoundingBox;

import java.util.ArrayList;
import java.util.Collection;

import static England.Origin.FirstPlugin.Commands.Admin.vanish.vanishtoggle;
import static England.Origin.FirstPlugin.Commands.Player.afk.afkplayers;



/**
 * Created by josep on 01/10/2020.
 */
public class Sleeping implements Listener {
    private ArrayList<Player> sleepingplayers = new ArrayList<>();
    @EventHandler
    public void onPlayerSleep(PlayerBedEnterEvent event) {
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
        if (onlinePlayers == 1){
            return;
        }
        if (isMonstersNearBy(event.getPlayer())){
            return;
        }
        if (!(sleepingplayers.contains(event.getPlayer()))) {
            sleepingplayers.add(event.getPlayer());
        }
        int theAmountOfPlayersInBed = sleepingplayers.size();
        if (theAmountOfPlayersInBed == 0){
            return;
        }

        int theAmountOfPeopleRequiredToSleep =
                ((onlinePlayers - afkplayers.size() - vanishtoggle.size() - endAndNetherPlayers()) / 2);
        World world = event.getPlayer().getWorld();


        if (world.isThundering()) {
            if (!(isDay())) {
                if (theAmountOfPlayersInBed >= theAmountOfPeopleRequiredToSleep) {
                    passStorm(world, false);
                    setDay();
                    debugLogEvent(onlinePlayers, theAmountOfPeopleRequiredToSleep);
                    return;
                } else {
                    final int x = (theAmountOfPeopleRequiredToSleep);
                    final int y = sleepingplayers.size();
                    final int xy = x - y;
                    event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', "&e[&4Server&e]&f ") + ChatColor.AQUA + "There are not enough players" +
                            " currently in bed. " + xy + " more players are needed in bed for the night and storm to pass.");
                    return;
                }
            }
        }
        
        if (world.isThundering()){
            if (theAmountOfPlayersInBed >= theAmountOfPeopleRequiredToSleep){
                passStorm(world, true);
                debugLogEvent(onlinePlayers,theAmountOfPeopleRequiredToSleep);
                return;
            } else {
                final int x = (theAmountOfPeopleRequiredToSleep);
                final int y = sleepingplayers.size();
                final int xy = x - y;
                event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "There are not enough players" +
                        " currently in bed. " +  xy + " more players are needed in bed for the storm to pass.");
            }
        }

        if(isDay()){
            return;
        } else {
            if (theAmountOfPlayersInBed >= theAmountOfPeopleRequiredToSleep){
                setDay();
                debugLogEvent(onlinePlayers,theAmountOfPeopleRequiredToSleep);
                return;
            } else {
                final int x = (theAmountOfPeopleRequiredToSleep);
                final int y = sleepingplayers.size();
                final int xy = x - y;
                event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "There are not enough players" +
                        " currently in bed. " +  xy + " more players are needed in bed for the night to pass.");
            }
        }
    }

    @EventHandler
    public void onPlayerLeaveBed(PlayerBedLeaveEvent event) {
        if (sleepingplayers.contains(event.getPlayer())) {
            sleepingplayers.remove(event.getPlayer());
        }
    }

    private void passStorm(World world, boolean sendMsg){
        world.setThundering(false);
        world.setStorm(false);
        if (sendMsg) {
            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e[&4Server&e]&f ") + ChatColor.AQUA + "At least 50%" +
                    " of the server was sleeping, so the storm has passed.");
        }
    }

    private void setDay(){
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
    }

    public boolean isDay() {
        long time = Bukkit.getWorld("AllAce").getTime() % 24000;
        return time < 12300 || time > 23850;
    }

    private void debugLogEvent(int onlinePlayers, int theAmountOfPeopleRequiredToSleep){
        Main.instance.getLogger().info("onlinePlayers" + onlinePlayers);
        Main.instance.getLogger().info("afktoggle" + afkplayers.size());
        Main.instance.getLogger().info("vanishtoggle" + vanishtoggle.size());
        Main.instance.getLogger().info("endAndNetherPlayers" + endAndNetherPlayers());
        Main.instance.getLogger().info("theAmountOfPeopleRequiredToSleep - " + theAmountOfPeopleRequiredToSleep);
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

    private boolean isMonstersNearBy(Player player){
        double x = player.getLocation().getX();
        double y = player.getLocation().getY();
        double z = player.getLocation().getBlockZ();
        BoundingBox box = new BoundingBox(x-8, y-4, z-8, x+8, y+4, z+8);
        Collection<Entity> entitiesAroundPlayerLoc =  player.getWorld().getNearbyEntities(box);
        for (Entity en : entitiesAroundPlayerLoc) {
            if (en instanceof Monster){
                return true;
            }
        }
        return false;
    }
}
