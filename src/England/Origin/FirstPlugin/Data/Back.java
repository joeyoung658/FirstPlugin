package England.Origin.FirstPlugin.Data;

import org.bukkit.entity.Player;

/**
 * Created by josep on 19/01/2017.
 */
public class Back {
    public static void backsave(Player player){
        ChangeData.changedatac(player, "back.worldname", player.getLocation().getWorld().getName());
        ChangeData.changedataf(player, "back.x", player.getLocation().getBlockX());
        ChangeData.changedataf(player, "back.y", player.getLocation().getBlockY());
        ChangeData.changedataf(player, "back.z", player.getLocation().getBlockZ());
        ChangeData.changedataf(player, "back.yaw", player.getLocation().getYaw());
        ChangeData.changedataf(player, "back.pitch", player.getLocation().getPitch());
    }
}
