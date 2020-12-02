package England.Origin.FirstPlugin.Runnables;

import England.Origin.FirstPlugin.Data.ChangeData;
import England.Origin.FirstPlugin.Data.PlayerData;
import England.Origin.FirstPlugin.Data.PlayerNameData;
import England.Origin.FirstPlugin.Main;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class updatePlayerFile extends BukkitRunnable {

    Player player;
    Main plugin;
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date date = new Date();
    public updatePlayerFile(Main plugin, Player player){
        this.plugin = plugin;
        this.player = player;
    }

    @Override
    public void run() {

        ChangeData.changedatac(player, "lastAccountName", player.getName());
        ChangeData.changedatac(player, "ipAddress", player.getAddress().getHostString());
        ChangeData.changedatac(player, "LastJoinDate", dateFormat.format(date));
    }
}
