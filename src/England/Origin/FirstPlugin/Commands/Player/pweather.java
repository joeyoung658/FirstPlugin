package England.Origin.FirstPlugin.Commands.Player;

import org.bukkit.ChatColor;
import org.bukkit.WeatherType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Joes_room on 13/12/2016.
 */
public class pweather implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("pweather")) { //Enables user to set a custom prefix
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +"This command can only be run by a player!");
                return true;
            } else {
                if (sender.hasPermission("<FP>.pweather")){
                    if (args.length == 1) {
                        Player player = (Player) sender;
                        if (args[0].equalsIgnoreCase("clear") || (args[0].equalsIgnoreCase("sun"))) {
                            if (player.getPlayerWeather() == WeatherType.CLEAR) {
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "It is already clear!");
                                return true;
                            }
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You have set the weather to Clear!");
                            player.setPlayerWeather(WeatherType.CLEAR);
                            return true;
                        } else if (args[0].equalsIgnoreCase("rain")) {
                            if (player.getPlayerWeather() == WeatherType.DOWNFALL) {
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "It is already Raining!");
                                return true;
                            }
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You have set the weather to Rain!");
                            player.setPlayerWeather(WeatherType.DOWNFALL);
                            return true;
                        } else if (args[0].equalsIgnoreCase("reset")) {
                            player.resetPlayerWeather();
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You have re-synced your weather with the servers weather!");
                            return true;
                        } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "Incorrent arguments /pweather [Clear/Rain/Reset]");
                    }
                        } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "Incorrent arguments /pweather [Clear/Rain/Reset]");
                    }

                    } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "You do not have permission to do this!");
                }
                }
            }
        return true;
        }

    }


