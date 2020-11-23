package England.Origin.FirstPlugin.World;

import org.bukkit.World;

/**
 * Created by josep on 27/05/2017.
 */
public class SetDay {

    public static void setDayTime(World world){
        if(world.hasStorm()){
            world.setStorm(false);
        }
        if(world.isThundering()){
            world.setThundering(false);
        }
        long Relative_Time = 24000 - world.getTime();
        world.setFullTime(world.getFullTime() + Relative_Time);
    }
}
