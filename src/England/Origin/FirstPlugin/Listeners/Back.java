package England.Origin.FirstPlugin.Listeners;

import England.Origin.FirstPlugin.Data.ChangeData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.server.ServerListPingEvent;

/**
 * Created by josep on 19/01/2017.
 */
public class Back {

//    @EventHandler
//    public void onTelportEvent(PlayerTeleportEvent  event)
//    {
//        backsave(event.getPlayer());
//    }

    public static void backsave(Player player){

        ChangeData.changedatac(player, "back.worldname", player.getLocation().getWorld().getName());
        ChangeData.changedataf(player, "back.x", player.getLocation().getBlockX());
        ChangeData.changedataf(player, "back.y", player.getLocation().getBlockY());
        ChangeData.changedataf(player, "back.z", player.getLocation().getBlockZ());
        ChangeData.changedataf(player, "back.yaw", player.getLocation().getYaw());
        ChangeData.changedataf(player, "back.pitch", player.getLocation().getPitch());


    }



}
