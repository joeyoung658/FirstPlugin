package England.Origin.FirstPlugin.Listeners;


import England.Origin.FirstPlugin.Broadcasting.Broadcasting;
import England.Origin.FirstPlugin.Commands.Message.ignore;
import England.Origin.FirstPlugin.Commands.Admin.vanish;
import England.Origin.FirstPlugin.Data.*;

import England.Origin.FirstPlugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitTask;
import England.Origin.FirstPlugin.Runnables.updatePlayerFile;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static England.Origin.FirstPlugin.Commands.Player.afk.afkcheck;
import static England.Origin.FirstPlugin.Commands.Admin.vanish.vanishtoggle;


public class PlayerJoin implements Listener {
    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private Date date = new Date();

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        PlayerData.PlayerDatac(event.getPlayer());
        BukkitTask updatePlayerFile = new updatePlayerFile(Main.instance, event.getPlayer()).runTaskAsynchronously(Main.instance);

        PlayerNameData.namesetter(event.getPlayer());
        tabWriting(event.getPlayer());

        if (!event.getPlayer().hasPlayedBefore()) {
            ChangeData.changedataf(event.getPlayer(), "homeamount", 3);
            Bukkit.broadcastMessage(ChatColor.GREEN + event.getPlayer().getDisplayName() + ChatColor.GREEN +  " has joined the server for the first time!");
            ChangeData.changedatac(event.getPlayer(), "FirstJoinDate", dateFormat.format(date));
            event.getPlayer().sendMessage(ChatColor.AQUA + " Welcome to All Ace!");
            event.getPlayer().teleport(new Location(Bukkit.getWorld("AllAce"),  -46, 104, -124, 2, 0));
            event.getPlayer().sendMessage(ChatColor.GOLD + "Start voting in order to start earning eCoins! Use /votes for more information.");
        } else {
            event.getPlayer().sendMessage(ChatColor.AQUA + "Welcome back " + event.getPlayer().getDisplayName() + ChatColor.AQUA + ", we've missed you!!");
        }


        if (!(PlayerNameData.filegetdata(event.getPlayer(), "vanish") == null)) {
            vanish.onvanish(event.getPlayer());
            vanishtoggle.add(event.getPlayer());
            event.setJoinMessage(null);
        } else {
            event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', "&7[&a+&7] ")+  event.getPlayer().getDisplayName() + ChatColor.GREEN + " joined!");
        }


        //What is the purpose of this?
        if (event.getPlayer().hasPermission("<FP>.bypass.playerlimit")) {
            ChangeData.changedatac(event.getPlayer(), "bypass", "true");
        } else {
            if (!(PlayerNameData.filegetdata(event.getPlayer(), "bypass") == null)) {
                ChangeData.changedatac(event.getPlayer(), "bypass", null);
            }
        }

        //For when players are ./ignoring each other
        ignore.ingorelistupdate(event.getPlayer());

        afkcheck.put(event.getPlayer(), event.getPlayer().getLocation());
        if (!(vanishtoggle.isEmpty())){
            for (Player p : vanishtoggle) {
                vanish.onvanish(p);
            }
        }
    }


    private void tabWriting(Player player){
        player.setPlayerListHeader(ChatColor.BOLD + "" + ChatColor.RED +  "play.allace.co.uk" +
                System.lineSeparator() + ChatColor.BLUE + "/website" + "     " + "/discord");
        player.setPlayerListFooter(ChatColor.AQUA + "Type /vote to earn great rewards!");
    }

}

