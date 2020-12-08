package England.Origin.FirstPlugin.Commands.Toggles;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class toggleEndPortal implements CommandExecutor {
    private final JavaPlugin plugin;
    public toggleEndPortal(JavaPlugin plugin){
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("toggleendportal")) {
            if (sender.hasPermission("<FP>.toggleendportal")){
                    try {
                        int toggle = plugin.getConfig().getInt("endToggle");
                        if (toggle == 1) {
                            plugin.getConfig().set("endToggle", 0);
                            plugin.saveConfig();
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                                    "&e[&4Server&e]&f ") + ChatColor.RED +
                                    "You've disabled the servers end portal!");
                        } else if (toggle == 0){
                            plugin.getConfig().set("endToggle", 1);
                            plugin.saveConfig();
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                                    "&e[&4Server&e]&f ") + ChatColor.RED +
                                    "You've enabled the servers end portal!");
                        }
                    } catch (Exception e){
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                                "&e[&4Server&e]&f ") + ChatColor.RED +
                                e.toString());
                        return false;
                    }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        "&e[&4Server&e]&f ") + ChatColor.RED +
                        "This is an admin only command!");
                return false;
            }
        }
        return true;
    }
}
