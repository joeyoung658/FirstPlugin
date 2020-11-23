package England.Origin.FirstPlugin.Commands.Message;

import England.Origin.FirstPlugin.Data.ChangeData;
import England.Origin.FirstPlugin.Data.GetData;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;


import java.util.*;

/**
 * Created by Joes_room on 18/12/2016.
 */
public class ignore implements CommandExecutor, Listener {
    public static List<Player> playerwhoingores = new ArrayList<>();
    public static Map<Player, List> ignored = new HashMap<>();

        @EventHandler
        public void onPlayerChat(AsyncPlayerChatEvent event) {
            for (Player Player: playerwhoingores) {
                if (Player.isOnline()) {
                    List<String> pi = ignored.get(Player);
                    //event.getPlayer().sendMessage(pi + "");
                    for (String p : pi) {
                        Player target = Bukkit.getPlayerExact(p);
                        if (!(target == null)) {
                            if (target == event.getPlayer()) {
                                event.getRecipients().remove(Player);

                            }
                        }
                    }
                }
            }

        }

        @Override
        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            if (cmd.getName().equalsIgnoreCase("ignore")) {
                if (!(sender instanceof Player)) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +"This is a player only command!");
                    return false;
                }
                List<String> pignored;
                pignored = GetData.filegetdatalist(((Player) sender), "ignored");
                if (pignored == null) {
                    pignored = new ArrayList<>();
                }
                if (args.length == 0){
                    if (pignored.isEmpty()){
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "Currently you are ignoring no one!");
                        return false;
                    } else {
                        sender.sendMessage(ChatColor.AQUA + "You are ignoring;");
                        StringBuilder ignoreing = new StringBuilder();
                        for (int i = 0; i < pignored.size(); i++) {

                            ignoreing.append(pignored.get(i) + ", ");
                            //sender.sendMessage(i + "");
                        }
                        sender.sendMessage(ignoreing.toString());
                        sender.sendMessage(ChatColor.AQUA + "");
                        pignored.clear();
                        return false;
                    }
                } else if (args.length == 1) {
                    Player target = Bukkit.getPlayerExact(args[0]);

                    if (pignored == null) {
                        pignored = new ArrayList<>();
                    }
                    if (pignored.contains(args[0])) {
                        String playername;
                        if (target == null) {
                            playername = args[0];
                        } else {
                            playername = target.getDisplayName();
                        }
                        pignored.remove(args[0]);
                        ChangeData.changedatalist(((Player) sender), "ignored", pignored);
                        pignored.clear();
                        ingorelistupdate(((Player) sender));
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You are no longer ignoring " + playername + "!");
                        return false;
                    } else {
                        if (target == null) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "You may not ignore an offline player!");
                            return false;
                        }
                        if (target.hasPermission("<FP>.staff") || args[0].equalsIgnoreCase("Origin658") || args[0].equalsIgnoreCase(sender.getName())) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.DARK_RED + "You may not ignore this person!");
                            pignored.clear();
                            return false;
                        }
                        pignored.add(target.getName());
                        ChangeData.changedatalist(((Player) sender), "ignored", pignored);
                        pignored.clear();
                        ingorelistupdate(((Player) sender));
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You are now ignoring " + target.getDisplayName() + "!");
                    }
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "Incorrect arguments! /ignore [playername]");
                }
            }
return false;
}
    public static void ingorelistupdate(Player player) {
        List<String> lignored = GetData.filegetdatalist(player, "ignored");
        if (lignored == null) {
            lignored = new ArrayList<>();
        }
            if (playerwhoingores.contains(player)) {
                ignored.remove(player);
                ignored.put(player, lignored);
            } else {
                playerwhoingores.add(player);
                ignored.put(player, lignored);
            }
    }
}