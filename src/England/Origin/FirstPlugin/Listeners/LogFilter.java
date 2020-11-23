//package England.Origin.FirstPlugin.Listeners;
//
//import England.Origin.FirstPlugin.Main;
//import org.bukkit.Bukkit;
//import org.bukkit.ChatColor;
//import sun.rmi.runtime.Log;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Filter;
//import java.util.logging.LogRecord;
//import java.util.logging.Logger;
//
///**
// * Created by josep on 10/06/2017.
// */
//public class LogFilter {
//
//    public static void DoNotLog() {
//        Filter f = new Filter() {
//            public boolean isLoggable(LogRecord line) {
//
//
//                List<String> cmds = new ArrayList<String>();
//                {
//                    {
//                        cmds.add("/msg");
//                        cmds.add("/m");
//                        cmds.add("/t");
//                        cmds.add("/w");
//                        cmds.add("/tell");
//                        cmds.add("/whisper");
//                        cmds.add("/pm");
//                        cmds.add("/reply");
//                        cmds.add("/r");
//                        cmds.add("/respond");
//                    }
//                }
//
//               // for (String command : cmds) {
//                    if (line.getMessage().toLowerCase().startsWith("/msg")) {
//                        return false;
//                    }
//                //}
//                return true;
//            }
//
//            public String doFilter(String arg0) {
//                return null;
//            }
//
//            public String doFilterUrl(String arg0) {
//                return null;
//            }};
//
//
//
//
//        Bukkit.getServer().getLogger().setFilter(f);
//
//
//    }
//}
