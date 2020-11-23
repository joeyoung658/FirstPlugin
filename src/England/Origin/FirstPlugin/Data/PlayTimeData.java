//package England.Origin.FirstPlugin.Data;
//
//import England.Origin.FirstPlugin.Listeners.PlayerJoin;
//import org.bukkit.entity.Player;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.UUID;
//
///**
// * Created by Joes_room on 14/12/2016.
// */
//public class PlayTimeData {
//    //private Map<UUID, Long> playerJoinTime;
//
////    public static PlayTimeData getInstance() {
////        return getInstance();
////    }
////    public PlayTimeData() {
////        this.playerJoinTime = new HashMap<UUID, Long>();
////    }
////
////   public void playerjoin(UUID id){
////       this.playerJoinTime.put(id, System.currentTimeMillis());
////   }
//
//    public static void PlayTimeLS(Player player) {
//
////        Long oldplaytime = GetData.filegetdatalong(player, "playtime");
////        Long jointimes = GetData.filegetdatalong(player, "jointimes");
////        Long leavetime = System.currentTimeMillis();
////
////        Long onserverplaytime = (leavetime - jointimes) + oldplaytime;
////
////        ChangeData.changedataf(player, "playtime", onserverplaytime);
//
//
//      //  long sessionTime = System.currentTimeMillis() - this.playerJoinTime.remove(player.getUniqueId());
//        long sessionTime = System.currentTimeMillis() - GetData.filegetdatalong(player, "jointimes");
//
//        //this.addPlayTime(id, sessionTime);
//
//        long currentTime = GetData.filegetdatalong(player, "playtime");
//        Long end = (currentTime + sessionTime);
//
//        ChangeData.changedataob(player, "playtime", end);
//
//    }
//
//
//
//
//
//
//
//    public static String formatTime(long time) {
//        int days = (int)((time /= 1000) / 86400);
//        int hours = (int)((time -= (long)(86400 * days)) / 3600);
//        int minutes = (int)((time -= (long)(3600 * hours)) / 60);
//        int seconds = (int)(time -= (long)(60 * minutes));
//        StringBuilder sb = new StringBuilder();
//        if (days != 0) {
//            sb.append(days).append(" day").append(days == 1 ? " " : "s ");
//        }
//        if (hours != 0) {
//            sb.append(hours).append(" hour").append(hours == 1 ? " " : "s ");
//        }
//        if (minutes != 0) {
//            sb.append(minutes).append(" minute").append(minutes == 1 ? " " : "s ");
//        }
//        if (seconds != 0) {
//            sb.append(seconds).append(" second").append(seconds == 1 ? "" : "s");
//        }
//        return sb.toString().trim();
//    }
//
//
//}
