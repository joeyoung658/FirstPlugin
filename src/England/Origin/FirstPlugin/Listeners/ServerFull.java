package England.Origin.FirstPlugin.Listeners;

import England.Origin.FirstPlugin.Data.PlayerNameData;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

/**
 * Created by josep on 18/03/2017.
 */
public class ServerFull implements Listener {


    @EventHandler
    public void PlayerLoginEvent(PlayerLoginEvent event) {
        if (event.getResult() == PlayerLoginEvent.Result.KICK_FULL) {
            if (!(PlayerNameData.filegetdata(event.getPlayer(), "bypass") == null) || event.getPlayer().isOp()) {
                event.setResult(PlayerLoginEvent.Result.ALLOWED);
            } else {
                event.setKickMessage(ChatColor.RED + "The server is currently full!" + System.lineSeparator() +
                        ChatColor.AQUA + "Please try again later!" + System.lineSeparator() + ChatColor.GREEN + "To pass the time checkout our discord! - https://discord.gg/YgNU3Pr");
            }
        }
    }
}