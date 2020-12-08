package England.Origin.FirstPlugin.Data;

import England.Origin.FirstPlugin.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

/**
 * Created by Joes_room on 22/12/2016.
 */
public class WarpData {
    public static void CreateWarpFile(String warpname) {
        File folder = new File(Main.instance.getDataFolder() + File.separator + "warps");
        if (!folder.exists()) {
            Main.instance.getLogger().log(Level.INFO, "Creating Warp Data Folder!");
            try {
                folder.mkdir();
            } catch (SecurityException e) {
                Main.instance.getLogger().log(Level.SEVERE, "Could not create new warp data folder");
                e.printStackTrace();
            }
        }
        File PlayerFile = new File(Main.instance.getDataFolder() + File.separator + "warps" + File.separator + warpname +".yml");
        if (!(PlayerFile.exists())) {
            Main.instance.getLogger().log(Level.INFO, "Registering new warp file for " + warpname + " warp");
            try {
                PlayerFile.createNewFile();
            } catch (IOException e) {
                Main.instance.getLogger().log(Level.SEVERE, "Could not create new warp file for !" + warpname);
                e.printStackTrace();
            }
        }

    }

    public static void RemoveWarpFile(String warpname) {


        File PlayerFile = new File(Main.instance.getDataFolder() + File.separator + "warps" + File.separator + warpname +".yml");
        if (!(PlayerFile.exists())) {
            Main.instance.getLogger().log(Level.INFO, "Removed " + warpname + " data file warp");
            PlayerFile.delete();
        } else {
            Main.instance.getLogger().log(Level.INFO, "Failed to remove " + warpname + " data file");
        }

    }



    public static void SetWarpDataFloat(String warpname, String location, Float data) {
        File PlayerFile = new File(Main.instance.getDataFolder() + File.separator + "warps" + File.separator + warpname + ".yml");
        if (!PlayerFile.exists()) {
            //CreateWarpFile(warpname);
            Main.instance.getLogger().log(Level.SEVERE,"Could not update data for " + warpname);
        } else {
            FileConfiguration PlayerData = YamlConfiguration.loadConfiguration(PlayerFile);
            PlayerData.set(location, data);
            try
            {
                PlayerData.save(PlayerFile);
            } catch (IOException e) {
                Main.instance.getLogger().log(Level.SEVERE,"Could not update data for " + warpname);
                e.printStackTrace();
            }
        }
    }
    public static void SetWarpDataString(String warpname, String location, String data) {
        File PlayerFile = new File(Main.instance.getDataFolder() + File.separator + "warps" + File.separator + warpname + ".yml");
        if (!PlayerFile.exists()) {
            //CreateWarpFile(warpname);
            Main.instance.getLogger().log(Level.SEVERE,"Could not update data for " + warpname);
        } else {
            FileConfiguration PlayerData = YamlConfiguration.loadConfiguration(PlayerFile);
            PlayerData.set(location, data);
            try
            {
                PlayerData.save(PlayerFile);
            } catch (IOException e) {
                Main.instance.getLogger().log(Level.SEVERE,"Could not update data for " + warpname);
                e.printStackTrace();
            }
        }
    }

    public static String filegetdatastring(String warpname, String worldname) {

        File PlayerFile = new File(Main.instance.getDataFolder() + File.separator + "warps" + File.separator + warpname + ".yml");
        if (!PlayerFile.exists()) {
            return null;
        } else {
            FileConfiguration PlayerData = YamlConfiguration.loadConfiguration(PlayerFile);
            if (PlayerData.getString(worldname) == null) {
                return null;
            } else {
                return (PlayerData.getString(worldname));
            }
        }
    }

    public static Integer filegetdataint(String warpname, String location) {

        File PlayerFile = new File(Main.instance.getDataFolder() + File.separator + "warps" + File.separator + warpname + ".yml");
        if (!PlayerFile.exists()) {
            return null;
        } else {
            FileConfiguration PlayerData = YamlConfiguration.loadConfiguration(PlayerFile);
            if (PlayerData.getString(location) == null) {
                return null;
            } else {
                return (PlayerData.getInt(location));
            }
        }
    }

}
