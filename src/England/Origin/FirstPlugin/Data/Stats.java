//package England.Origin.FirstPlugin.Data;
//
//import England.Origin.FirstPlugin.Main;
//import org.bukkit.configuration.file.FileConfiguration;
//import org.bukkit.configuration.file.YamlConfiguration;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.logging.Level;
//
///**
// * Created by josep on 05/07/2017.
// */
//public class Stats {
//
//    public static void createStatsFolder(){
//        File folder = new File(Main.instance.getDataFolder() + File.separator + "Stats");
//        if (!folder.exists()) {
//            Main.instance.getLogger().log(Level.INFO, "Creating Stats Folder!");
//            try {
//                folder.mkdir();
//            } catch (SecurityException e) {
//                Main.instance.getLogger().log(Level.SEVERE, "Could not create new Stats folder");
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public static Boolean saveStatsData(String filename, String date, Integer amount){
//
//        File PlayerFile = new File(Main.instance.getDataFolder() + File.separator + "Stats" + File.separator + filename);
//        if (!PlayerFile.exists()) {
//            return false;
//        } else {
//            FileConfiguration PlayerData = YamlConfiguration.loadConfiguration(PlayerFile);
//            PlayerData.set(date, amount);
//            try
//            {
//                PlayerData.save(PlayerFile);
//            } catch (IOException e) {
//                Main.instance.getLogger().log(Level.SEVERE,"Could not update data for" + filename);
//                e.printStackTrace();
//            }
//        }
//        return true;
//    }
//
//    public static Integer getStatsData(String filename, String cdate){
//        File Stats = new File(Main.instance.getDataFolder() + File.separator + "Stats" + File.separator + filename );
//        if (!Stats.exists()) {
//            return -1;
//        } else {
//            FileConfiguration StatsData = YamlConfiguration.loadConfiguration(Stats);
//            if (StatsData.getString(cdate) == null) {
//                return -1;
//            } else {
//                return (StatsData.getInt(cdate));
//            }
//        }
//    }
//
//}
