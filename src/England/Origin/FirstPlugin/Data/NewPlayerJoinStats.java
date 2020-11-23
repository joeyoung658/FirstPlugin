//package England.Origin.FirstPlugin.Data;
//
//import England.Origin.FirstPlugin.Main;
//import org.bukkit.Bukkit;
//import org.bukkit.configuration.file.FileConfiguration;
//import org.bukkit.configuration.file.YamlConfiguration;
//
//import java.io.File;
//import java.io.IOException;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.logging.Level;
//
//import static England.Origin.FirstPlugin.Data.Stats.createStatsFolder;
//import static England.Origin.FirstPlugin.Data.Stats.getStatsData;
//import static England.Origin.FirstPlugin.Data.Stats.saveStatsData;
//
///**
// * Created by josep on 05/07/2017.
// */
//public class NewPlayerJoinStats {
//
//    public static void NewPlayerJoinStats(){
//
//        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
//        Date date = new Date();
//        String currentdate =  (dateFormat.format(date));
//
//        int CurrentNewPlayerJoinCount = getStatsData("NewPlayerJoin.yml", currentdate);
//
//        if (CurrentNewPlayerJoinCount == -1) {
//            createNewPlayerJoinFile(currentdate);
//            saveStatsData("NewPlayerJoin.yml", currentdate, 1);
//        } else {
//            saveStatsData("NewPlayerJoin.yml", currentdate, CurrentNewPlayerJoinCount + 1);
//        }
//    }
//
//
//
//    public static void createNewPlayerJoinFile(String cdate) {
//        createStatsFolder();
//        File PlayerFile = new File(Main.instance.getDataFolder() + File.separator + "Stats" + File.separator + "NewPlayerJoin.yml");//create a new file in the "chatrooms" directory with the room's name
//        //File PlayerFile = new File(getDataFolder()+ File.separator +  player.getUniqueId() +".yml"); //create a new file in the "chatrooms" directory with the room's name
//        FileConfiguration PlayerData;
//        if (!(PlayerFile.exists())) {
//            Main.instance.getLogger().log(Level.INFO, "Registering new NewPlayerJoin file");
//            try {
//                PlayerFile.createNewFile();
//                PlayerData = YamlConfiguration.loadConfiguration(PlayerFile);
//                PlayerData.set(cdate, 0);
//                try {
//                    PlayerData.save(PlayerFile);
//                } catch (IOException e) {
//                    Main.instance.getLogger().log(Level.SEVERE, "Could not save data file for  NewPlayerJoin file");
//                    e.printStackTrace();
//                }
//            } catch (IOException e) {
//                Main.instance.getLogger().log(Level.SEVERE, "Could not create new  NewPlayerJoin file");
//                e.printStackTrace();
//            }
//        }
//    }
//}