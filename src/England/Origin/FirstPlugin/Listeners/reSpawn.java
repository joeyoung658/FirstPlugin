package England.Origin.FirstPlugin.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class reSpawn implements Listener {

    @EventHandler
    public void PlayerRespawnEvent(PlayerRespawnEvent event){
        //Location{world=CraftWorld{name=AllAce},x=-46.478002827041344,y=104.0,z=-125.63949231021408,pitch=6.449987,yaw=-0.097297676}
        if (!(event.isBedSpawn())){
            World world = Bukkit.getWorld("AllAce");
            Location spawn = new Location(world,  -46.478002827041344, 104.0, -125.63949231021408, 0, 6);
            event.setRespawnLocation(spawn);
        }
    }
}
