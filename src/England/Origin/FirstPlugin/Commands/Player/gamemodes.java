package England.Origin.FirstPlugin.Commands.Player;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Joes_room on 07/12/2016.
 */
public class gamemodes implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("gamemode")) {
            if (args.length == 1) {
                if (!(sender instanceof Player)) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +"This command can only be run by a player!");
                    return true;
                } else {
                    Player player = (Player) sender;
                    if (args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("c") || args[0].equalsIgnoreCase("1")) {
                        if (sender.hasPermission("<FP>.gamemode.creative")) {
                            player.setGameMode(GameMode.CREATIVE);
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You are now in creative mode!");
                            return true;
                        } else {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "You do not have permission for this command!");
                            return true;
                        }
                    } else if (args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("s") || args[0].equalsIgnoreCase("0")) {
                        if (sender.hasPermission("<FP>.gamemode.survival")) {
                            player.setGameMode(GameMode.SURVIVAL);
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You are now in survival mode!");
                            return true;
                        } else {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "You do not have permission for this command!");
                            return true;
                        }
                    } else if (args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("a") || args[0].equalsIgnoreCase("2")) {
                        if (sender.hasPermission("<FP>.gamemode.adventure")) {
                            player.setGameMode(GameMode.ADVENTURE);
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You are now in adventure mode!");
                            return true;
                        } else {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "You do not have permission for this command!");
                            return true;
                        }
                    } else if (args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("spec") || args[0].equalsIgnoreCase("3")) {
                        if (sender.hasPermission("<FP>.gamemode.spectator")) {
                            player.setGameMode(GameMode.SPECTATOR);
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You are now in spectator mode!");
                            return true;
                        } else {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "You do not have permission for this command!");
                            return true;
                        }
                    } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "Incorrect arguments! /gamemode [Gamemode type] [PlayerName]");
                    }
                }
            } if (args.length == 2) {
                if (sender.hasPermission("<FP>.agamemode")) {
                    Player target = Bukkit.getPlayerExact(args[1]);
                    if (target == null) { //if player isnt online
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.DARK_RED + args[1] + " is not online!");
                        return false;
                    }
                    if (target.isOp()) {
                        sender.sendMessage("Go away");
                        return false;
                    }
                        if (args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("c")) {
                            target.setGameMode(GameMode.CREATIVE);
                            target.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "An admin has set you in creative mode!");
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +
                                    ChatColor.AQUA + "You have set " + target.getDisplayName() + ChatColor.AQUA + " to creative mode");
                            return true;
                        } else if (args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("s")) {
                            target.setGameMode(GameMode.SURVIVAL);
                            target.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "An admin has set you  in survival mode!");
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +
                                    ChatColor.AQUA + "You have set " + target.getDisplayName() + ChatColor.AQUA  + " to survival mode");
                            return true;
                        } else if (args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("a")) {
                            target.setGameMode(GameMode.ADVENTURE);
                            target.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "An admin has set you  in adventure mode!");
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +
                                    ChatColor.AQUA + "You have set " + target.getDisplayName() + ChatColor.AQUA + " to adventure mode");
                            return true;
                        } else if (args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("spec")) {
                            target.setGameMode(GameMode.SPECTATOR);
                            target.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "An admin has set you  in spectator mode!");
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +
                                    ChatColor.AQUA + "You have set " + target.getDisplayName() + ChatColor.AQUA + " to spectator mode");
                            return true;
                        } else {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "Incorrect arguments! /gamemode [Gamemode type] [PlayerName]");
                            return true;
                        }

                }
            }else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "Incorrect arguments! /gamemode [Gamemode type] [PlayerName]");
                return true;
            }
        }
        return true;
    }
}