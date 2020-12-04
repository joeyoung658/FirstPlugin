package England.Origin.FirstPlugin.Commands.Infomation;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Rules implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        if (alias.equalsIgnoreCase("Rules")) {
                if (args.length == 0) { //Sender only typed '/rules' and nothing else
                    sender.sendMessage(ChatColor.YELLOW + "Type /rules [n] for n page of rules");
                    sender.sendMessage("---------------" + ChatColor.YELLOW + "Rules 1/3" + ChatColor.WHITE + "----------------------");
                    sender.sendMessage("[1]Do not harass another player");
                    sender.sendMessage("[2]No political debates");
                    sender.sendMessage("[3]No spamming");
                    sender.sendMessage("[4]English only in the main chat");
                    sender.sendMessage("[5]No Imitating other players");
                    sender.sendMessage("[6]No Griefing");
                    sender.sendMessage("[7]No Hacks or other non-visual modifications");
                } else { //if the user has typed more than rules
                    if (args[0].equalsIgnoreCase("2")) {
                        sender.sendMessage("---------------" + ChatColor.YELLOW + "Rules 2/3" + ChatColor.WHITE + "----------------------");
                        sender.sendMessage("[8]No PvP outside of the PvP Arena");
                        sender.sendMessage("[9]No glitch/bug exploitation");
                        sender.sendMessage("[10]No Ban Evading");
                        sender.sendMessage("[11]Only one account per player");
                        sender.sendMessage("[12]No VPNs");
                        sender.sendMessage("[13]No Advertising");
                        sender.sendMessage("[14]Tricking other players to do something with malicious intent is forbidden");

                    } else if (args[0].equalsIgnoreCase("3")) {
                        sender.sendMessage("---------------" + ChatColor.YELLOW + "Rules 3/3" + ChatColor.WHITE + "----------------------");
                        sender.sendMessage("[15]Generally disrupting the peace of the server is forbidden");
                        sender.sendMessage("[16]No Raiding");
                        sender.sendMessage(ChatColor.RED + "" + ChatColor.UNDERLINE + "More Information");
                        sender.sendMessage(ChatColor.RED + "For more information about the server rules head to " + ChatColor.GREEN + "https://shorturl.at/dhoD9");
                        sender.sendMessage(ChatColor.RED + "Please note this is highly recommended as the rules are explained in more depth.");
                    } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.DARK_RED + "Error:" + ChatColor.WHITE + " " + args[0] + " is an incorrect page number! Only pages 1-3 are valid");
                    }
                }
            return true;
        }
        return false;
    }
}





