package England.Origin.FirstPlugin.Commands.Infomation;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;





public class Info implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("vote")) {
                sender.sendMessage(ChatColor.YELLOW + "=====================Voting!=====================");
                sender.sendMessage(ChatColor.GOLD + "You can vote on each website daily!");
                sender.sendMessage(ChatColor.DARK_PURPLE + "Vote Link 1" + ChatColor.GREEN + "- https://minecraft-server-list.com/server/469930/vote/");
                sender.sendMessage(ChatColor.DARK_PURPLE + "Vote Link 2" + ChatColor.GREEN + "- https://minecraftservers.org/server/599554");
                sender.sendMessage(ChatColor.DARK_PURPLE + "Vote Link 3" + ChatColor.GREEN + "- https://minecraft-mp.com/server-s273448");
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

        if (cmd.getName().equalsIgnoreCase("shophelp")){
            sender.sendMessage(ChatColor.LIGHT_PURPLE + "---------------------Website!---------------------");
            sender.sendMessage(ChatColor.AQUA + "For information on the rules and how to use the chest shops please see the link below!");
            sender.sendMessage(ChatColor.AQUA + "Join us at - https://docs.google.com/document/d/1M2z5NSIDmzBptudswPeYfXg7Fge02aDXlzmocnICuqY/edit?usp=sharing");
            sender.sendMessage(ChatColor.LIGHT_PURPLE + "-------------------------------------------------");
        }
        return true;
    }

}







