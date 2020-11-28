package England.Origin.FirstPlugin.Listeners;


import England.Origin.FirstPlugin.Broadcasting.Broadcasting;
import England.Origin.FirstPlugin.Commands.Message.ignore;
import England.Origin.FirstPlugin.Commands.Admin.vanish;
import England.Origin.FirstPlugin.Data.*;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

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
        ChangeData.changedatac(event.getPlayer(), "lastAccountName", event.getPlayer().getName());
        ChangeData.changedatac(event.getPlayer(), "ipAddress", event.getPlayer().getAddress().getHostString());
        ChangeData.changedatac(event.getPlayer(), "LastJoinDate", dateFormat.format(date));
        if (PlayerNameData.filegetdata(event.getPlayer(), "homeamount") == null) {
            ChangeData.changedataf(event.getPlayer(), "homeamount", 3);
        }

        staffrank(event.getPlayer());
        PlayerNameData.namesetter(event.getPlayer());

        if (PlayerNameData.filegetdata(event.getPlayer(), "tiptoggle") == null) {Broadcasting.tiptoggle.add(event.getPlayer());}

        if (!event.getPlayer().hasPlayedBefore()) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.sendMessage(ChatColor.GREEN + event.getPlayer().getDisplayName() + ChatColor.GREEN +  " has joined the server for the first time!");
            }
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

        if (event.getPlayer().hasPermission("<FP>.bypass.playerlimit")) {
            ChangeData.changedatac(event.getPlayer(), "bypass", "true");
        } else {
            if (!(PlayerNameData.filegetdata(event.getPlayer(), "bypass") == null)) {
                ChangeData.changedatac(event.getPlayer(), "bypass", null);
            }
        }

        //PlayTimeData.getInstance().playerjoin(event.getPlayer().getUniqueId());


        ignore.ingorelistupdate(event.getPlayer());
        afkcheck.put(event.getPlayer(), event.getPlayer().getLocation());


        if (!(vanishtoggle.isEmpty())){
            for (Player p : vanishtoggle) {
                vanish.onvanish(p);
            }
        }

        //PeakPlayerCount.PeakPlayers();


    }


    public static boolean staffrank(Player player) {
        if (!(player.isOp())) {
            if (player.hasPermission("prefix.admin")) {
                PlayerNameData.changedata(player, "prefix", "&f[&4Admin&f]&a");
                //player.setPlayerListName(ChatColor.DARK_RED + player.getName());
                player.setPlayerListName(ChatColor.translateAlternateColorCodes('&', "&f[&4Admin&f]&a")  + ChatColor.RESET + player.getName());

                //player.setPlayerListName(player.getDisplayName());
                return true;
            }
            if (player.hasPermission("prefix.mod")) {
                PlayerNameData.changedata(player, "prefix", "&f[&bMod&f]&4");
                player.setPlayerListName(ChatColor.translateAlternateColorCodes('&', "&f[&bMod&f]&4")  + ChatColor.RESET + player.getName());
                //player.setPlayerListName(ChatColor.RED + player.getName());
                return true;
            }
            if (player.hasPermission("prefix.builder")) {
                PlayerNameData.changedata(player, "prefix", "&f[&6Builder&f]&6");
                player.setPlayerListName(ChatColor.translateAlternateColorCodes('&', "&f[&6Builder&f]&6")  + ChatColor.RESET + player.getName());
                //player.setPlayerListName(ChatColor.YELLOW + player.getName());
                return true;
            }

            if (player.hasPermission("prefix.youtube")) {
                PlayerNameData.changedata(player, "prefix", "&f[&cYouTube&f]&e");
                player.setPlayerListName(ChatColor.translateAlternateColorCodes('&', "&f[&cYouTube&f]&6")  + ChatColor.RESET + player.getName());
                //player.setPlayerListName(ChatColor.YELLOW + player.getName());
                return true;
            }

            if (player.hasPermission("prefix.twitch")) {
                PlayerNameData.changedata(player, "prefix", "&f[&5Twitch&f]&e");
                player.setPlayerListName(ChatColor.translateAlternateColorCodes('&', "&f[&5Twitch&f]&6")  + ChatColor.RESET + player.getName());
                //player.setPlayerListName(ChatColor.YELLOW + player.getName());
                return true;
            }

//            if (player.hasPermission("prefix.king")) {
//                //PlayerNameData.changedata(player, "prefix", "&f[&5King&f]&e");
//                player.setPlayerListName(ChatColor.translateAlternateColorCodes('&', "&f[&5King&f]&e")  + ChatColor.RESET + player.getName());
//                //player.setPlayerListName(ChatColor.YELLOW + player.getName());
//                return true;
//            }
//
//            if (player.hasPermission("prefix.queen")) {
//               // PlayerNameData.changedata(player, "prefix", "&f[&dQueen&f]&e");
//                player.setPlayerListName(ChatColor.translateAlternateColorCodes('&', "&f[&dQueen&f]&e")  + ChatColor.RESET + player.getName());
//                //player.setPlayerListName(ChatColor.YELLOW + player.getName());
//                return true;
//            }


        }

            if (player.getName().contains("Monderp")) {
                player.setPlayerListName(ChatColor.translateAlternateColorCodes('&', "&f[&aC.Manager&f]&b")  + ChatColor.RESET + player.getName());
                return true;
            }

            if (player.getName().contains("XploderB")) {
                player.setPlayerListName(ChatColor.translateAlternateColorCodes('&', "&f[&6S.Manager&f]&b")  + ChatColor.RESET + player.getName());
                return true;
            }

            if (player.getName().contains("Origin658")) {
                player.setPlayerListName(ChatColor.translateAlternateColorCodes('&', "&f[&4Dev&f]&b")  + ChatColor.RESET + player.getName());
                return true;
            }

        return false;
    }
//    public void donorrank(Player player ) {
//
//        if (PlayerNameData.filegetdata(player, "prefix") == null && !(player.isOp())) {
//            // return false;
//            if (player.hasPermission("prefix.two")) {
//                PlayerNameData.changedata(player, "prefix", "&f[&6Omega&f]&5");
//                player.setPlayerListName(ChatColor.translateAlternateColorCodes('&', "&f[&6Omega&f]&5")  + ChatColor.DARK_PURPLE + player.getName());
//                // return true;
//            } else
//            if (player.hasPermission("prefix.one")) {
//                PlayerNameData.changedata(player, "prefix", "&f[&bAlpha&f]&5");
//                player.setPlayerListName(ChatColor.translateAlternateColorCodes('&', "&f[&bAlpha&f]&5")  + ChatColor.DARK_PURPLE + player.getName());
//                // return true;
//            } else
//            if (player.hasPermission("prefix.botm")) {
//                PlayerNameData.changedata(player, "prefix", "&f[&5BOTM&f]&e");
//                //  return true;
//            } else
//            if (player.hasPermission("prefix.top_voter")) {
//                PlayerNameData.changedata(player, "prefix", "&f[&5Top_Voter&f&e");
//                // return true;
//            }
//        }
//        if (!(player.hasPermission("<FP>.staff"))) {
//            if (player.hasPermission("prefix.two") && !(player.isOp())) {
//                player.setPlayerListName(ChatColor.translateAlternateColorCodes('&', "&f[&6Omega&f]&5") + ChatColor.DARK_PURPLE + player.getName());
//            }
//
//            if (player.hasPermission("prefix.one") && !(player.isOp())) {
//                player.setPlayerListName(ChatColor.translateAlternateColorCodes('&', "&f[&bAlpha&f]&5") + ChatColor.DARK_PURPLE + player.getName());
//            }
//        }
//
////        else {
////            player.setPlayerListName(ChatColor.translateAlternateColorCodes('&', PlayerNameData.dicgetprefix(player))  + ChatColor.RESET + player.getName());
////        }
//        //return false;
//    }
}

