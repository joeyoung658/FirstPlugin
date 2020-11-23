package England.Origin.FirstPlugin.Commands.Toggles;

import England.Origin.FirstPlugin.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class toggleSleepBypass implements CommandExecutor {
    private final JavaPlugin plugin;
    public toggleSleepBypass(JavaPlugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("togglesleepbypass")) {
            if (sender.hasPermission("<FP>.togglesleepbypass")){
                try {
                    int toggle = plugin.getConfig().getInt("sleepToggle");
                    if (toggle == 1) {
                        Main.instance.sleepToggleBypass = 0;
                        plugin.getConfig().set("sleepToggle", 0);
                        plugin.saveConfig();
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                                "&e[&4Server&e]&f ") + ChatColor.RED +
                                "You've disabled the ability to bypass sleeping!");
                    } else if (toggle == 0){
                        Main.instance.sleepToggleBypass = 1;
                        plugin.getConfig().set("sleepToggle", 1);
                        plugin.saveConfig();
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                                "&e[&4Server&e]&f ") + ChatColor.RED +
                                "You've enabled ability to bypass sleeping!");
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

        return false;
    }
}
