package England.Origin.FirstPlugin.Commands.Infomation;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;





public class Info implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("vote")) {
                sender.sendMessage(ChatColor.YELLOW + "=====================Voting!=====================");
                sender.sendMessage(ChatColor.GOLD + "You can vote on each website daily!");
                sender.sendMessage(ChatColor.DARK_PURPLE + "Vote Link 1" + ChatColor.GREEN + "- https://shorturl.at/uCDJ9");
                sender.sendMessage(ChatColor.DARK_PURPLE + "Vote Link 2" + ChatColor.GREEN + "- https://shorturl.at/txS17");
                sender.sendMessage(ChatColor.DARK_PURPLE + "Vote Link 3" + ChatColor.GREEN + "- https://shorturl.at/bxPV8");
                sender.sendMessage(ChatColor.YELLOW + "==================================================");

                return true;
        }
        if (cmd.getName().equalsIgnoreCase("colours")) {
                sender.sendMessage(ChatColor.AQUA + "Minecraft colour Codes - " + ChatColor.RED + "This is a donator only command, use /donate to find out more!");
                sender.sendMessage(ChatColor.BLACK + "&0," + ChatColor.DARK_BLUE + "&1," + ChatColor.DARK_GREEN + "&2," + ChatColor.DARK_AQUA + "&3");
                sender.sendMessage(ChatColor.DARK_RED + "&4," + ChatColor.DARK_PURPLE + "&5," + ChatColor.GOLD + "&6," + ChatColor.GRAY + "&7");
                sender.sendMessage(ChatColor.DARK_GRAY + "&8, " + ChatColor.BLUE + "&9," + ChatColor.GREEN + "&a," + ChatColor.AQUA + "&b");
                sender.sendMessage(ChatColor.RED + "&c," + ChatColor.LIGHT_PURPLE + "&d," + ChatColor.YELLOW + "&e," + ChatColor.WHITE + "&f");
                sender.sendMessage(ChatColor.BOLD + "Bold - &L" + ChatColor.RESET + "" + ChatColor.STRIKETHROUGH + "Strike thought - &m" + ChatColor.RESET + "Reset - &r");
                return true;

        }
        if (cmd.getName().equalsIgnoreCase("donate")) {
                sender.sendMessage("---------------" + ChatColor.YELLOW + "Donating!" + ChatColor.WHITE + "--------------------");
                sender.sendMessage(ChatColor.DARK_PURPLE + "Donation Packages" + ChatColor.GREEN + " - https://allace.tebex.io");
                sender.sendMessage(ChatColor.AQUA + "Click the link to find out more!");
                sender.sendMessage("-------------------------------------------------");
                return true;
        }
//        if (cmd.getName().equalsIgnoreCase("twitter")) {
//                sender.sendMessage(ChatColor.AQUA + "---------------------Twitter!---------------------");
//                sender.sendMessage(ChatColor.DARK_PURPLE + "See the latest news and updates!");
//                sender.sendMessage(ChatColor.DARK_PURPLE + "Follow us at - @ ");
//                sender.sendMessage(ChatColor.GREEN + "link - ");
//                sender.sendMessage(ChatColor.AQUA + "-------------------------------------------------");
//        }
//        if (cmd.getName().equalsIgnoreCase("build")) {
//                sender.sendMessage(ChatColor.AQUA + "--------------Build of the month!-----------------");
//                sender.sendMessage(ChatColor.DARK_PURPLE + "Join our build of the month competition!");
//                sender.sendMessage(ChatColor.DARK_PURPLE + "For a chance to be featured on our home page + MORE!");
//                sender.sendMessage(ChatColor.GREEN + "http://www.exhibit-minecraft.co.uk/forums/showthread.php?tid=93");
//                sender.sendMessage(ChatColor.AQUA + "-----------------------------------------------");
//        }
        if (cmd.getName().equalsIgnoreCase("discord")) {
                sender.sendMessage(ChatColor.LIGHT_PURPLE + "---------------------Discord!---------------------");
                sender.sendMessage(ChatColor.AQUA + "Join the chat and check out our discord!");
                sender.sendMessage(ChatColor.AQUA + "Join us at - https://discord.gg/7nAGXXV");
                sender.sendMessage(ChatColor.LIGHT_PURPLE + "-------------------------------------------------");
        }

        if (cmd.getName().equalsIgnoreCase("website")) {
            sender.sendMessage(ChatColor.LIGHT_PURPLE + "---------------------Website!---------------------");
            sender.sendMessage(ChatColor.AQUA + "Check out our website!");
            sender.sendMessage(ChatColor.AQUA + "Join us at - https://www.allace.co.uk");
            sender.sendMessage(ChatColor.LIGHT_PURPLE + "-------------------------------------------------");
        }

//        if (cmd.getName().equalsIgnoreCase("steam")) {
//            sender.sendMessage(ChatColor.LIGHT_PURPLE + "---------------------Steam!---------------------");
//            sender.sendMessage(ChatColor.AQUA + "Join the chat and check out our steam group!");
//            sender.sendMessage(ChatColor.AQUA + "http://steamcommunity.com/groups/exhibitMinecraft");
//            sender.sendMessage(ChatColor.LIGHT_PURPLE + "------------------------------------------------");
//        }
        return true;
    }

}







