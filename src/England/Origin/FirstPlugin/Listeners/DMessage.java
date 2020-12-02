
package England.Origin.FirstPlugin.Listeners;

//Creates red death message


import England.Origin.FirstPlugin.Data.Back;
import England.Origin.FirstPlugin.Data.PlayerNameData;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import static England.Origin.FirstPlugin.Player.SaveInven.SavePlayerInven;


public class DMessage implements Listener {
    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        event.setDeathMessage(ChatColor.RED + event.getDeathMessage());
        Player player = event.getEntity();
        SavePlayerInven(player);
        if (!(PlayerNameData.filegetdata(player, "keepinven") == null)) {
                event.setKeepInventory(true);
                event.getDrops().clear();
        }
        if (!(PlayerNameData.filegetdata(player, "keepxp") == null)) {
            event.setKeepLevel(true);
        }

        Back.backsave(player);
        if (player.hasPermission("<FP>.back")) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e[&4Server&e]&f ")
                    + ChatColor.AQUA + "Type " + ChatColor.GREEN + "/back " + ChatColor.AQUA + "to return to your death point!");
        }
        }
    }
