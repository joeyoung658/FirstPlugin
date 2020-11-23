package England.Origin.FirstPlugin.Data;

import England.Origin.FirstPlugin.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;

/**
 * Created by Joes_room on 07/12/2016.
 */
public class ChangeData {

    public static Boolean changedatac(Player player, String locaton, String data) {
        File PlayerFile = new File(Main.instance.getDataFolder() + File.separator + "PlayerData" + File.separator + player.getUniqueId() + ".yml");
        if (!PlayerFile.exists()) {
            return false;
        } else {
            FileConfiguration PlayerData = YamlConfiguration.loadConfiguration(PlayerFile);
            PlayerData.set(locaton, data);
            try
            {
                PlayerData.save(PlayerFile);
            } catch (IOException e) {
                Main.instance.getLogger().log(Level.SEVERE,"Could not update data for " + player.getName());
                e.printStackTrace();
            }
        }
        return true;
    }
    public static Boolean singlestring(Player player, String locaton) {
        File PlayerFile = new File(Main.instance.getDataFolder() + File.separator + "PlayerData" + File.separator + player.getUniqueId() + ".yml");
        if (!PlayerFile.exists()) {
            return false;
        } else {
            FileConfiguration PlayerData = YamlConfiguration.loadConfiguration(PlayerFile);
            PlayerData.set(locaton, null);
            try
            {
                PlayerData.save(PlayerFile);
            } catch (IOException e) {
                Main.instance.getLogger().log(Level.SEVERE,"Could not update data for " + player.getName());
                e.printStackTrace();
            }
        }
        return true;
    }




    public static Boolean changedataf(Player player, String locaton, float data) {
        File PlayerFile = new File(Main.instance.getDataFolder() + File.separator + "PlayerData" + File.separator + player.getUniqueId() + ".yml");
        if (!PlayerFile.exists()) {
            return false;
        } else {
            FileConfiguration PlayerData = YamlConfiguration.loadConfiguration(PlayerFile);
            PlayerData.set(locaton, data);
            try
            {
                PlayerData.save(PlayerFile);
            } catch (IOException e) {
                Main.instance.getLogger().log(Level.SEVERE,"Could not update data for " + player.getName());
                e.printStackTrace();
            }
        }
        return true;
    }

    public static Boolean changedataint(Player player, String locaton, int data) {
        File PlayerFile = new File(Main.instance.getDataFolder() + File.separator + "PlayerData" + File.separator + player.getUniqueId() + ".yml");
        if (!PlayerFile.exists()) {
            return false;
        } else {
            FileConfiguration PlayerData = YamlConfiguration.loadConfiguration(PlayerFile);
            PlayerData.set(locaton, data);
            try
            {
                PlayerData.save(PlayerFile);
            } catch (IOException e) {
                Main.instance.getLogger().log(Level.SEVERE,"Could not update data for " + player.getName());
                e.printStackTrace();
            }
        }
        return true;
    }

    public static Boolean changedatalist(Player player, String locaton, List data) {
        File PlayerFile = new File(Main.instance.getDataFolder() + File.separator + "PlayerData" + File.separator + player.getUniqueId() + ".yml");
        if (!PlayerFile.exists()) {
            return false;
        } else {
            FileConfiguration PlayerData = YamlConfiguration.loadConfiguration(PlayerFile);
            PlayerData.set(locaton, data);
            try
            {
                PlayerData.save(PlayerFile);
            } catch (IOException e) {
                Main.instance.getLogger().log(Level.SEVERE,"Could not update data for " + player.getName());
                e.printStackTrace();
            }
        }
        return true;
    }


}
