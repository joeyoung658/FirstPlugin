package England.Origin.FirstPlugin.Data;

import England.Origin.FirstPlugin.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

/**
 * Created by Joes_room on 06/12/2016.
 */
public class PlayerData {

    public static void PlayerDatac(Player player) {


        File folder = new File(Main.instance.getDataFolder() + File.separator + "PlayerData");
        if (!folder.exists()) {
            Main.instance.getLogger().log(Level.INFO, "Creating PlaterData Folder!");
            try {
                folder.mkdir();
            } catch (SecurityException e) {
                Main.instance.getLogger().log(Level.SEVERE, "Could not create new PlayerData folder");
                e.printStackTrace();
            }
        }

            File PlayerFile = new File(Main.instance.getDataFolder() + File.separator + "PlayerData" + File.separator + player.getUniqueId() +".yml"); //create a new file in the "chatrooms" directory with the room's name
            //File PlayerFile = new File(getDataFolder()+ File.separator +  player.getUniqueId() +".yml"); //create a new file in the "chatrooms" directory with the room's name
            FileConfiguration PlayerData;
            if (!(PlayerFile.exists())) {
                Main.instance.getLogger().log(Level.INFO, "Registering new PlayerData file for " + player.getName());
                try {
                    PlayerFile.createNewFile();
                    PlayerData = YamlConfiguration.loadConfiguration(PlayerFile);
                    PlayerData.set("lastAccountName", player.getName());
                    try
                    {
                        PlayerData.save(PlayerFile);
                    } catch (IOException e) {
                        Main.instance.getLogger().log(Level.SEVERE,"Could not save data file for " + player.getName());
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    Main.instance.getLogger().log(Level.SEVERE, "Could not create new PlayerData file for !" + player.getName());
                    e.printStackTrace();
                }
            }
            return;
        }
    }