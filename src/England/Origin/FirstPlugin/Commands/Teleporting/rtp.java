package England.Origin.FirstPlugin.Commands.Teleporting;

import England.Origin.FirstPlugin.Main;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * Created by josep on 06/09/2017.
 */
public class rtp implements CommandExecutor {

    public static Map<UUID, Long> rtpdelay = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        if (alias.equalsIgnoreCase("rtp")) {

            if (!(sender instanceof Player)){
                return true;
            }

            Player player = (Player) sender;
            if (player.getLocation().getWorld().getName().endsWith("_nether"))
            {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "Sorry this command is currently disabled within the nether");
                return true;
            }
            if (player.getLocation().getWorld().getName().endsWith("_end"))
            {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "Sorry this command is currently disabled within the end");
                return true;
            }

            long lastuse;
            if (rtpdelay.containsKey(player.getUniqueId())) {
                lastuse = rtpdelay.get(player.getUniqueId());
            } else {
                lastuse = 0;
            }


            if (!(lastuse == 0)){

            long remaining = (System.currentTimeMillis() - lastuse)/1000;

            if (!(player.isOp())) {
                if (remaining >= 3600) {
                    rtpdelay.put(player.getUniqueId(), System.currentTimeMillis());
                } else {
                    long mins = (3600 - remaining)/60;
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") + ChatColor.AQUA + "Please wait " + mins + " minutes before using rtp again!");
                    return true;
                }
            }
            } else {
                rtpdelay.put(player.getUniqueId(), System.currentTimeMillis());
            }

            getRTPLocation(player, result -> {
                if (result == null){
                    sender.sendMessage("Error");
                    return;
                }
                player.teleport(result);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") + ChatColor.AQUA + "You have been randomly teleported!");
            });
        }
        return true;
    }


    public interface RTPLocationCallBack {
        void onQueryDone(Location result);
    }


    public static void getRTPLocation(final Player player,
                                      final RTPLocationCallBack callback){
        Bukkit.getScheduler().runTaskAsynchronously(Main.instance, new Runnable() {
            @Override
            public void run() {
                int x;
                int z;
                Location rtp = null;
                while (true) {
                    while (rtp == null) {
                        x = randomValue(20000);
                        z = randomValue(20000);
                        rtp = getAboveGroundLoc(player.getWorld(), x, z);

                    }
                    if (liqSafe(rtp)==true){
                        break;
                    } else {
                        rtp = null;
                    }
                }
                rtp.setY(rtp.getBlockY()+7);
                rtp.setX(rtp.getBlockX()+0.5);
                rtp.setZ(rtp.getBlockZ()+0.5);
                Location finalRtp = rtp;
                Bukkit.getScheduler().runTask(Main.instance, new Runnable() {
                    @Override
                    public void run() {
                        callback.onQueryDone(finalRtp);
                    }
                });
            }
        });
    }


    private static int randomValue(int bound){
        Random random = new Random();
        int ran = random.nextInt(bound);
        return ran;
    }



    private static Location getAboveGroundLoc(World world, int x, int z){
        Location possibleLocation = new Location(world, x, 0, z);
        for(int i = 60; i <= 120; i++){
            possibleLocation.setY(i);
            if (isLocationAirBlock(possibleLocation)){
                possibleLocation.setY(possibleLocation.getBlockY()+10);
                if (isLocationAirBlock(possibleLocation)){
                    possibleLocation.setY(possibleLocation.getBlockY()+2);
                    if (isLocationAirBlock(possibleLocation)){
                      possibleLocation.setY(possibleLocation.getBlockY()-12);
                        return possibleLocation;
                    }
                }
            }
        }
        return null;
    }

    private static boolean isLocationAirBlock(Location location){
        if (location.getBlock().getType() == Material.AIR){
            return true;
        } else {
            return false;
        }
    }

    private static boolean liqSafe(Location location){
        if (location == null){
            return false;
        }
        for(int i = location.getBlockY(); i <= location.getBlockY()+10; i++) {
            location.setY(location.getBlockY()-1);
            if (location.getBlock().getType() == Material.WATER) {
                return false;
            }
            if (location.getBlock().getType() == Material.LAVA) {
                return false;
            }
            if (location.getBlock().getType() == Material.LAVA) {
                return false;
            }
        }
        return true;
    }

    private static void storeLocation(Location location){
        //Todo save cords and prevent other players from ending up in the same palce
    }
}