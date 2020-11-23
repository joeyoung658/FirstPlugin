package England.Origin.FirstPlugin.Listeners;


import England.Origin.FirstPlugin.Commands.Admin.vanish;
import England.Origin.FirstPlugin.Data.ChangeData;
import England.Origin.FirstPlugin.Data.PlayerNameData;
import England.Origin.FirstPlugin.Main;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static England.Origin.FirstPlugin.Commands.Player.afk.afkcheck;
import static England.Origin.FirstPlugin.Commands.Player.afk.afkplayers;
import static England.Origin.FirstPlugin.Commands.Message.ignore.ignored;
import static England.Origin.FirstPlugin.Commands.Message.ignore.playerwhoingores;
import static England.Origin.FirstPlugin.Commands.Admin.vanish.vanishtoggle;


/**
 * Created by Joes_room on 11/12/2016.
 */
public class PlayerLeave implements Listener {
    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private Date date = new Date();


    //Hide user if they have vanished toggled.


    @EventHandler
    public void onPlayerQuitEvent(PlayerQuitEvent event) {
        if (!(PlayerNameData.filegetdata(event.getPlayer(), "vanish") == null)) {
            vanish.onvanish(event.getPlayer());
            vanishtoggle.remove(event.getPlayer());
            event.setQuitMessage(null);
        } else {
            event.setQuitMessage(ChatColor.translateAlternateColorCodes('&', "&7[&4-&7] ") + event.getPlayer().getDisplayName() + ChatColor.RED + " disconnected!");
        }
        if (!(PlayerNameData.filegetdata((event.getPlayer()), "god") == null)) {
            ChangeData.changedatac((event.getPlayer()), "god", null);
            event.getPlayer().setInvulnerable(false);
        }
        ChangeData.changedatac(event.getPlayer(), "logoutlocation.worldname", event.getPlayer().getLocation().getWorld().getName());
        ChangeData.changedataf(event.getPlayer(), "logoutlocation.x", event.getPlayer().getLocation().getBlockX());
        ChangeData.changedataf(event.getPlayer(), "logoutlocation.y", event.getPlayer().getLocation().getBlockY());
        ChangeData.changedataf(event.getPlayer(), "logoutlocation.z", event.getPlayer().getLocation().getBlockZ());
        ChangeData.changedataf(event.getPlayer(), "logoutlocation.yaw", event.getPlayer().getLocation().getYaw());
        ChangeData.changedataf(event.getPlayer(), "logoutlocation.pitch", event.getPlayer().getLocation().getPitch());


        ChangeData.changedatac(event.getPlayer(), "LastSeenDate", dateFormat.format(date));

        ignored.remove(event.getPlayer());
        playerwhoingores.remove(event.getPlayer());
        if (afkplayers.contains(event.getPlayer())) {afkplayers.remove(event.getPlayer());}
        if (afkcheck.containsKey(event.getPlayer())) {afkcheck.remove(event.getPlayer());}
       // if ((pvpeo.contains(event.getPlayer().getUniqueId()))) {event.getPlayer().getInventory().clear();
          //  Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "spawn " + event.getPlayer().getName()); pvpeo.remove(event.getPlayer().getUniqueId()); }


       // PlayTimeData.PlayTimeLS(event.getPlayer());

        if (Main.instance.pvptoggle.contains(event.getPlayer().getName())) {
            Main.instance.pvptoggle.remove(event.getPlayer().getName());
        }

    }

}
