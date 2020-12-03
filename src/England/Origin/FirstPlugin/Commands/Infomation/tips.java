//package England.Origin.FirstPlugin.Commands.Infomation;
//
//import England.Origin.FirstPlugin.Main;
//import org.bukkit.ChatColor;
//import org.bukkit.command.Command;
//import org.bukkit.command.CommandExecutor;
//import org.bukkit.command.CommandSender;
//
//import java.util.List;
//
//public class tips implements CommandExecutor {
//    @Override
//    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
//        if (alias.equalsIgnoreCase("tips")) {
//            List<String> Tip = Main.instance.getConfig().getStringList("tips");
//            if (args.length == 0) { //sender only typed /tips and nothing else (Can only have 9 lines display on screen)
//                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "Type /tips [n] for n page of tips");
//            } else if (args[0].equalsIgnoreCase("1")) {
//                sender.sendMessage(ChatColor.YELLOW + "Type /tips [n] for n page of tips");
//                sender.sendMessage("---------------" + ChatColor.YELLOW + "Tips 1/3" + ChatColor.WHITE + "----------------------");
//                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"1) " + Tip.get(0)));
//                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"2) " + Tip.get(1)));
//                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"3) " + Tip.get(2)));
//                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"4) " + Tip.get(3)));
//                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"5) " + Tip.get(4)));
//
//            } else if (args[0].equalsIgnoreCase("2")) {
//                sender.sendMessage("---------------" + ChatColor.YELLOW + "Tips 2/3" + ChatColor.WHITE + "----------------------");
//                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"6) " + Tip.get(5)));
//                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"7) " + Tip.get(6)));
//                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"8) " + Tip.get(7)));
//                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"9) " + Tip.get(8)));
//                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"10) " + Tip.get(9)));
//                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"11) " + Tip.get(10)));
//            } else if (args[0].equalsIgnoreCase("3")) {
//                sender.sendMessage("---------------" + ChatColor.YELLOW + "Tips 3/3" + ChatColor.WHITE + "----------------------");
//                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"12) " + Tip.get(11)));
//                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"13) " + Tip.get(12)));
//
//            } else {
//                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "Type /tips [n] for n page of tips");
//            }
//            return true;
//        }
//        return true;
//    }
//}
