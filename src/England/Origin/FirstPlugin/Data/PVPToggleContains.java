package England.Origin.FirstPlugin.Data;

import England.Origin.FirstPlugin.Main;
import org.bukkit.entity.Player;

/**
 * Created by josep on 19/06/2017.
 */
public class PVPToggleContains {

    public static boolean PVPtoggle(String player){

        if (Main.instance.pvptoggle.contains(player)){
            return true;
        } else {
            return false;
        }
    }
}
