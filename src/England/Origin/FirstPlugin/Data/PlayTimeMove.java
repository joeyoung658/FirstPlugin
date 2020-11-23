//package England.Origin.FirstPlugin.Data;
//
//import England.Origin.FirstPlugin.Main;
//import org.bukkit.Bukkit;
//import org.bukkit.configuration.file.FileConfiguration;
//import org.bukkit.configuration.file.YamlConfiguration;
//import org.bukkit.entity.Player;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import java.util.logging.Level;
//
///**
// * Created by Joes_room on 14/12/2016.
// */
//public class PlayTimeMove {
//
//    public static void PlayTimeMovem() {
//
//
//        File playtime = new File(Main.instance.getDataFolder() + File.separator + "playtime.yml");
//
//        FileConfiguration PlayerData;
//
//
//            PlayerData = YamlConfiguration.loadConfiguration(playtime);
//            Set<String> stuff = PlayerData.getConfigurationSection("time").getKeys(false);
//           for (String i : stuff){
//                    //Bukkit.broadcastMessage(i);
//                    updateplayerfile(i, PlayerData.getInt("time." + i));
//                    PlayerData.set("time."+i, null);
//           }
//                try {
//                    PlayerData.save(playtime);
//                } catch (IOException e) {
//                  //  Main.instance.getLogger().log(Level.SEVERE, "Could not save data file for " + player.getName());
//                    e.printStackTrace();
//                }
//
//
//    }
//    public static Boolean updateplayerfile(String i, Integer data) {
//
//        File PlayerFile = new File(Main.instance.getDataFolder() + File.separator + "PlayerData" + File.separator + i + ".yml");
//        FileConfiguration PlayerData = YamlConfiguration.loadConfiguration(PlayerFile);
//
//        if (!PlayerFile.exists()) {
//
//
//            File p = new File(Main.instance.getDataFolder() + File.separator + "PlayerData" + File.separator + i +".yml"); //create a new file in the "chatrooms" directory with the room's name
//            //File PlayerFile = new File(getDataFolder()+ File.separator +  player.getUniqueId() +".yml"); //create a new file in the "chatrooms" directory with the room's name
//            FileConfiguration pd;
//            if (!( p.exists())) {
//                Main.instance.getLogger().log(Level.INFO, "Registering new PlayerData file for" + i);
//                try {
//                    p.createNewFile();
//                    PlayerData = YamlConfiguration.loadConfiguration(PlayerFile);
//                    PlayerData.set("playtime", data);
//                    try {
//                        PlayerData.save(p);
//                    } catch (IOException e) {
//                        Main.instance.getLogger().log(Level.SEVERE, "Could not save data file for " + i);
//                        e.printStackTrace();
//                    }
//                } catch (IOException e) {
//                    Main.instance.getLogger().log(Level.SEVERE, "Could not create new PlayerData file for !" + i);
//                    e.printStackTrace();
//
//
//                }
//            }
//
//
//        } else {
//
//            PlayerData.set("playtime", data);
//            try
//            {
//                PlayerData.save(PlayerFile);
//            } catch (IOException e) {
//                Main.instance.getLogger().log(Level.SEVERE,"Could not update data for " + i);
//                e.printStackTrace();
//            }
//        }
//        return true;
//    }
//
//}
//
//
//
//
//
