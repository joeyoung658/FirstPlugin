package England.Origin.FirstPlugin.Commands.Toggles;

import England.Origin.FirstPlugin.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCombustByEntityEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by josep on 04/03/2017.
 */




public class pvptoggle implements CommandExecutor, Listener {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "This is a player only command!");
            //sender.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.notAPlayer")));
            return true;
        }

        Player p = (Player)sender;

        if (cmd.getName().equalsIgnoreCase("togglepvp")) {


//            if (!p.hasPermission("<FP>.pvp.toggle")) {
//                p.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.noPermission")));
//                return true;
//            }

            if (args.length == 0) {
                if (Main.instance.pvptoggle.contains(p.getName())) {
                    Main.instance.pvptoggle.remove(p.getName());
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You have disabled pvp mode!");
                    //p.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.noLongerPvPing")));
                    return true;
                }else if (!(Main.instance.pvptoggle.contains(p.getName()))) {
                    Main.instance.pvptoggle.add(p.getName());
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You have enabled pvp mode!");
                    //p.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.nowPvPing")));
                    return true;
                }
            } else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "There has been some form of error!");
                //p.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.argumentError")));
            }

        }
        return true;
    }

    @EventHandler(priority= EventPriority.HIGH)
    public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
        if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player))) {
            Player p = (Player)e.getEntity();
            Player k = (Player)e.getDamager();


            if (p == k){
                e.setCancelled(false);
                return;
            }

            if (k.isOp()) {
                e.setCancelled(false);
                return;
            }


            if (!(Main.instance.pvptoggle.contains(p.getName()))) {
                e.setCancelled(true);
                k.sendMessage( ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") + p.getDisplayName() + ChatColor.RED + " is not in PVP mode!");
                //k.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.targetNotInPvPMode").replace("%target%", p.getName())));
                return;
            }

            if (!(Main.instance.pvptoggle.contains(k.getName()))) {
                e.setCancelled(true);
                k.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +  ChatColor.RED  + "You are not in PVP mode! Type /togglepvp to enrol your self into PVP mode.");
                //k.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.youAreNotInPvPMode")));
                return;
            }

            if ((Main.instance.pvptoggle.contains(p.getName())) && (Main.instance.pvptoggle.contains(k))) {
                e.setCancelled(false);
                return;
            }
        }
    }

    @EventHandler
    public void onArrow(EntityDamageByEntityEvent e) {
        if((e.getEntity() instanceof Player) && (e.getDamager() instanceof Projectile)  && (((Projectile) e.getDamager()).getShooter() instanceof Player)) {
            Player p = (Player) e.getEntity();
            Player k = ((Player) ((Projectile) e.getDamager()).getShooter());

            if (p == k){
                e.setCancelled(false);
                return;
            }

            if (k.isOp()) {
                e.setCancelled(false);
                return;
            }

            if (!(Main.instance.pvptoggle.contains(p.getName()))) {
                e.setCancelled(true);
                k.sendMessage( ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") + p.getDisplayName() + ChatColor.RED + " is not in PVP mode!");
                //k.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.targetNotInPvPMode").replace("%target%", p.getName())));
                return;
            }

            if (!(Main.instance.pvptoggle.contains(k.getName()))) {
                e.setCancelled(true);
                k.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +  ChatColor.RED  + "You are not in PVP mode! Type /togglepvp to enrol your self into PVP mode.");
                //k.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.youAreNotInPvPMode")));
                return;
            }
        }
    }

    @EventHandler
    public void onFire(EntityCombustByEntityEvent e) {
        if((e.getEntity() instanceof Player)  && (e.getCombuster() instanceof Projectile)  && (((Projectile) e.getCombuster()).getShooter() instanceof Player)) {
            Player p = (Player) e.getEntity();
            Player k = ((Player) ((Projectile) e.getCombuster()).getShooter());

            if (p == k){
                e.setCancelled(false);
                return;
            }

            if (k.isOp()) {
                e.setCancelled(false);
                return;
            }

            if (!(Main.instance.pvptoggle.contains(p.getName()))) {
                e.setCancelled(true);
                return;
            }

            if (!(Main.instance.pvptoggle.contains(k.getName()))) {
                e.setCancelled(true);
                return;
            }
        }
    }




//    @EventHandler
//    public void onPlayerQuit(PlayerQuitEvent e) {
//        Player p = e.getPlayer();
//
//        if (Main.instance.pvptoggle.contains(p.getName())) {
//            Main.instance.pvptoggle.remove(p.getName());
//        }
//    }
}


