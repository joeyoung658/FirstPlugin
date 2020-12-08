package England.Origin.FirstPlugin.Data;

/**
 * Created by josep on 11/02/2017.
 */

import England.Origin.FirstPlugin.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;



/**
 * Created by Joes_room on 03/12/2016.
 */
public class HomeData {

    public static void SetHomeDataFloat(Player player, String homename, String location, Float data) {
        File PlayerFile = new File(Main.instance.getDataFolder() + File.separator + "PlayerData" + File.separator + player.getUniqueId() + ".yml");
        if (!PlayerFile.exists()) {
            //CreateWarpFile(warpname);
            Main.instance.getLogger().log(Level.SEVERE,"Could not update data for " + homename);
        } else {
            FileConfiguration PlayerData = YamlConfiguration.loadConfiguration(PlayerFile);
            PlayerData.set("homes." + homename + "." + location, data);
            try
            {
                PlayerData.save(PlayerFile);
            } catch (IOException e) {
                Main.instance.getLogger().log(Level.SEVERE,"Could not update data for " + homename);
                e.printStackTrace();
            }
        }
    }
    public static void SetHomeDataString(Player player, String homename, String location, String data) {
        File PlayerFile = new File(Main.instance.getDataFolder() + File.separator + "PlayerData" + File.separator + player.getUniqueId() + ".yml");
        if (!PlayerFile.exists()) {
            //CreateWarpFile(warpname);
            Main.instance.getLogger().log(Level.SEVERE,"Could not update data for " + homename);
        } else {
            FileConfiguration PlayerData = YamlConfiguration.loadConfiguration(PlayerFile);
            PlayerData.set("homes." + homename + "." + location, data);
            try
            {
                PlayerData.save(PlayerFile);
            } catch (IOException e) {
                Main.instance.getLogger().log(Level.SEVERE,"Could not update data for " + homename);
                e.printStackTrace();
            }
        }
    }



    public static String filegetdatastring(Player player, String homename) {

        File PlayerFile = new File(Main.instance.getDataFolder() + File.separator + "PlayerData" + File.separator + player.getUniqueId() + ".yml");
        if (!PlayerFile.exists()) {
            return null;
        } else {
            FileConfiguration PlayerData = YamlConfiguration.loadConfiguration(PlayerFile);
            if (PlayerData.getString("homes." + homename + ".world") == null) {
                return null;
            } else {
                return (PlayerData.getString("homes." + homename + ".world"));
            }
        }
    }

    public static Integer filegetdataint(Player player, String homename, String location) {

        File PlayerFile = new File(Main.instance.getDataFolder() + File.separator + "PlayerData" + File.separator + player.getUniqueId() + ".yml");
        if (!PlayerFile.exists()) {
            return null;
        } else {
            FileConfiguration PlayerData = YamlConfiguration.loadConfiguration(PlayerFile);
            if (PlayerData.getString("homes."+homename + "." + location) == null) {
                return null;
            } else {
                return (PlayerData.getInt("homes."+homename + "." + location));
            }
        }
    }
    public static void RemoveHome(Player player, String homename) {
        File PlayerFile = new File(Main.instance.getDataFolder() + File.separator + "PlayerData" + File.separator + player.getUniqueId() + ".yml");
        if (!PlayerFile.exists()) {
            Main.instance.getLogger().log(Level.SEVERE,"Could not update data for " + player.getName());
        } else {
            FileConfiguration PlayerData = YamlConfiguration.loadConfiguration(PlayerFile);
            PlayerData.set("homes." + homename, null);
            try
            {
                PlayerData.save(PlayerFile);
            } catch (IOException e) {
                Main.instance.getLogger().log(Level.SEVERE,"Could not update data for " + player.getName());
                e.printStackTrace();
            }
        }
    }


}