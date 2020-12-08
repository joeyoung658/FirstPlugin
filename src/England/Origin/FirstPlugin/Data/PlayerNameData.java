package England.Origin.FirstPlugin.Data;

import England.Origin.FirstPlugin.Main;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

/**
 * Created by Joes_room on 03/12/2016.
 */
public class PlayerNameData {
    //public static Map<String, String> prefix = new HashMap<>();
    //public static Map<String, String> nick = new HashMap<>();
    public static String filegetdata(Player player, String data) {

        File PlayerFile = new File(Main.instance.getDataFolder() + File.separator + "PlayerData" + File.separator + player.getUniqueId() + ".yml");
        if (!PlayerFile.exists()) {
            return null;
        } else {
            FileConfiguration PlayerData = YamlConfiguration.loadConfiguration(PlayerFile);
                return (PlayerData.getString(data));
            }
    }
    public static Boolean changedata(Player player,String locaton, String data) {
        File PlayerFile = new File(Main.instance.getDataFolder() + File.separator + "PlayerData" + File.separator + player.getUniqueId() + ".yml");
        if (!PlayerFile.exists()) {
            return false;
        } else {
            FileConfiguration PlayerData = YamlConfiguration.loadConfiguration(PlayerFile);
            PlayerData.set(locaton, data);
            try
            {
                PlayerData.save(PlayerFile);
                YamlConfiguration.loadConfiguration(PlayerFile);
            } catch (IOException e) {
                Main.instance.getLogger().log(Level.SEVERE,"Could not update data for " + player.getName());
                e.printStackTrace();
            }
        }
        return true;
    }

     public static String checkforprefix(Player player) {
         if (PlayerNameData.filegetdata(player.getPlayer(), "prefix") == null) {
             return("&e");
         } else{
             return((PlayerNameData.filegetdata(player.getPlayer(), "prefix")));
         }
     }

    public static String checkfornick(Player player) {
        if (PlayerNameData.filegetdata(player.getPlayer(), "nick") == null) {
            return (player.getPlayer().getName().toString());
        } else {
            return (PlayerNameData.filegetdata(player.getPlayer(), "nick"));
        }
    }

    public static void namesetter(Player player){
        player.setDisplayName(ChatColor.translateAlternateColorCodes('&', checkforprefix(player.getPlayer())  +
                checkfornick(player.getPlayer()) + "&r"));
        player.setPlayerListName(ChatColor.translateAlternateColorCodes('&', checkforprefix(player.getPlayer())  +
                checkfornick(player.getPlayer()) + "&r"));
    }
}