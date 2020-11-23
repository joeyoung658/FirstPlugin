package England.Origin.FirstPlugin.Listeners;


import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;


public class ColourCodes implements Listener {
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        if (e.getPlayer().hasPermission("<FP>.ColourCodesChat")) {
                e.setMessage(ChatColor.translateAlternateColorCodes('&', e.getMessage().toString()));
        }
    }
    @EventHandler
    public void onSignChangeEvent(SignChangeEvent e) {
        if (e.getPlayer().hasPermission("<FP>.ColourCodesChat")) {
            for (int i = 0; i < 4; i++) {
                e.setLine(i, ChatColor.translateAlternateColorCodes('&', e.getLine(i)));
            }
        }
    }
}
