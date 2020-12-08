package England.Origin.FirstPlugin.Runnables;

import England.Origin.FirstPlugin.Commands.Player.afk;
import England.Origin.FirstPlugin.Data.PlayerNameData;
import England.Origin.FirstPlugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import static England.Origin.FirstPlugin.Commands.Player.afk.afkplayers;

public class isPlayerAfkCheck extends BukkitRunnable {


    Main plugin;
    public isPlayerAfkCheck(Main plugin){
        this.plugin = plugin;
    }

    @Override
    public void run() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (!(afkplayers.contains(p))) {
                if (afk.afkcheck.containsKey(p)) {
                    if (p.getLocation().equals(afk.afkcheck.get(p))) {
                        afkplayers.add(p);
                        afk.afkcheck.remove(p);
                        if (PlayerNameData.filegetdata(p, "vanish") == null) {
                            Bukkit.broadcastMessage(ChatColor.GRAY + "* " + p.getDisplayName() + ChatColor.GRAY + " is now afk!");
                        }
                    } else {
                        afk.afkcheck.put(p, p.getLocation());
                    }
                } else {
                    afk.afkcheck.put(p, p.getLocation());
                }
            }
        }
    }
}
