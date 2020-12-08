package England.Origin.FirstPlugin.Data;

import England.Origin.FirstPlugin.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Created by Joes_room on 14/12/2016.
 */
public class GetData {

    public static Integer filegetdataint(Player player, String data) {

        File PlayerFile = new File(Main.instance.getDataFolder() + File.separator + "PlayerData" + File.separator + player.getUniqueId() + ".yml");
        if (!PlayerFile.exists()) {
            return null;
        } else {
            FileConfiguration PlayerData = YamlConfiguration.loadConfiguration(PlayerFile);
            if (PlayerData.getString(data) == null) {
                return null;
            } else {
                return (PlayerData.getInt(data));
            }
        }
    }

    public static String file_get_data_using_uuid_string(UUID uuid, String data) {
        File PlayerFile = new File(Main.instance.getDataFolder() + File.separator + "PlayerData" + File.separator + uuid + ".yml");
        if (!PlayerFile.exists()) {
            return null;
        } else {
            FileConfiguration PlayerData = YamlConfiguration.loadConfiguration(PlayerFile);
            if (PlayerData.getString(data) == null) {
                return null;
            } else {
                return (PlayerData.getString(data));
            }
        }
    }

    public static Integer file_get_data_using_uuid_int(UUID uuid, String data) {
        File PlayerFile = new File(Main.instance.getDataFolder() + File.separator + "PlayerData" + File.separator + uuid + ".yml");
        if (!PlayerFile.exists()) {
            return 0;
        } else {
            FileConfiguration PlayerData = YamlConfiguration.loadConfiguration(PlayerFile);
            if (PlayerData.getString(data) == null) {
                return 0;
            } else {
                return (PlayerData.getInt(data));
            }
        }
    }

    public static Integer file_get_data_using_uuid_long(UUID uuid, String data) {
        File PlayerFile = new File(Main.instance.getDataFolder() + File.separator + "PlayerData" + File.separator + uuid + ".yml");
        if (!PlayerFile.exists()) {
            return 0;
        } else {
            FileConfiguration PlayerData = YamlConfiguration.loadConfiguration(PlayerFile);
            if (PlayerData.getString(data) == null) {
                return 0;
            } else {
                return (PlayerData.getInt(data));
            }
        }
    }

    public static String filegetdatastring(Player player, String location) {
        File PlayerFile = new File(Main.instance.getDataFolder() + File.separator + "PlayerData" + File.separator + player.getUniqueId() + ".yml");
        if (!PlayerFile.exists()) {
            return null;
        } else {
            FileConfiguration PlayerData = YamlConfiguration.loadConfiguration(PlayerFile);
            if (PlayerData.getString(location) == null) {
                return null;
            } else {
                return (PlayerData.getString(location));
            }
        }
    }

    public static List filegetdatalist(Player player, String location) {

        File PlayerFile = new File(Main.instance.getDataFolder() + File.separator + "PlayerData" + File.separator + player.getUniqueId() + ".yml");
        if (!PlayerFile.exists()) {
            return null;
        } else {
            FileConfiguration PlayerData = YamlConfiguration.loadConfiguration(PlayerFile);
            if (PlayerData.getString(location) == null) {
                return null;
            } else {
                return (PlayerData.getList(location));
            }
        }
    }

    public static Set<String> filegetdataset(Player player, String location) {

        File PlayerFile = new File(Main.instance.getDataFolder() + File.separator + "PlayerData" + File.separator + player.getUniqueId() + ".yml");
        if (!PlayerFile.exists()) {
            return null;
        } else {
            FileConfiguration PlayerData = YamlConfiguration.loadConfiguration(PlayerFile);
            if (PlayerData.getString(location) == null) {
                return null;
            } else {
                return (PlayerData.getConfigurationSection(location).getKeys(false));
            }
        }
    }



}
