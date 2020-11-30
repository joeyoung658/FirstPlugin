package England.Origin.FirstPlugin.Player;

import England.Origin.FirstPlugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 * Created by Joes_room on 24/12/2016.
 */
public class Teleporting {



    public static void delay(Player player, String worldname, float x, float y, float z, float yaw, float pitch ) {



        Location telto = new Location(Bukkit.getWorld(worldname),x,y,z,yaw,pitch);


        Location checkblock = new Location(Bukkit.getWorld(worldname),x,y,z,yaw,pitch);

        checkblock.setY(checkblock.getBlockY() - 2);

        if (Bukkit.getWorld(worldname).getBlockAt(checkblock).isEmpty() ) {
           telto.setY(telto.getBlockY() + 2);
        }

        telto.setX(telto.getBlockX() + 0.5);
        telto.setZ(telto.getBlockZ() + 0.5);

        if (!(Bukkit.getWorld(worldname).getChunkAt(telto).isLoaded())){
            Bukkit.getWorld(worldname).getChunkAt(telto).load();
        }


        if (!(player.hasPermission("<FP>.BYPASS.TPCOOL"))) {
            player.sendMessage(ChatColor.AQUA + "You will be teleported in 5 seconds!" + ChatColor.RED + " Please do not move or your action will be terminated!");
            int a = player.getLocation().getBlockX() + player.getLocation().getBlockY() + player.getLocation().getBlockY();
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
                @Override
                public void run() {
                    int b = player.getLocation().getBlockX() + player.getLocation().getBlockY() + player.getLocation().getBlockY();
                    if (a == b) {
                        player.teleport(telto);
                        player.sendMessage(ChatColor.GRAY + "You have been teleported to your requested destination");
                    } else {
                        player.sendMessage(ChatColor.RED + "Due to you moving, the teleport request has been canceled.");
                    }
                }
            }, 20l * 5);
        } else {
            player.teleport(telto);
            player.sendMessage(ChatColor.GRAY + "You have been teleported to your requested destination!");
        }
    }

}
