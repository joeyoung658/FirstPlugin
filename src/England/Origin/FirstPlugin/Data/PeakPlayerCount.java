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
//import static England.Origin.FirstPlugin.Data.Stats.*;
//
///**
// * Created by josep on 02/06/2017.
// */
//public class PeakPlayerCount {
//
//
//
//
//    public static void PeakPlayers(){
//
//        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
//        Date date = new Date();
//        String currentdate =  (dateFormat.format(date));
//
//
//        int playercount = Bukkit.getServer().getOnlinePlayers().size();
//        int CurrentPeakCount = getStatsData("PeakPlayers.yml", currentdate);
//
//        if (CurrentPeakCount == -1) {
//            createPeakPlayerFile(currentdate);
//            saveStatsData("PeakPlayers.yml", currentdate, playercount);
//        } else if (playercount > CurrentPeakCount) {
//            saveStatsData("PeakPlayers.yml", currentdate, playercount);
//        }
//    }
//
//
//
//    private static void createPeakPlayerFile(String cdate) {
//        createStatsFolder();
//        File PlayerFile = new File(Main.instance.getDataFolder() + File.separator + "Stats" + File.separator + "PeakPlayers.yml");//create a new file in the "chatrooms" directory with the room's name
//        //File PlayerFile = new File(getDataFolder()+ File.separator +  player.getUniqueId() +".yml"); //create a new file in the "chatrooms" directory with the room's name
//        FileConfiguration PlayerData;
//        if (!(PlayerFile.exists())) {
//            Main.instance.getLogger().log(Level.INFO, "Registering new peakplayer file");
//            try {
//                PlayerFile.createNewFile();
//                PlayerData = YamlConfiguration.loadConfiguration(PlayerFile);
//                PlayerData.set(cdate, 0);
//                try {
//                    PlayerData.save(PlayerFile);
//                } catch (IOException e) {
//                    Main.instance.getLogger().log(Level.SEVERE, "Could not save data file for  peakplayer file");
//                    e.printStackTrace();
//                }
//            } catch (IOException e) {
//                Main.instance.getLogger().log(Level.SEVERE, "Could not create new  peakplayer file");
//                e.printStackTrace();
//            }
//        }
//    }
//}