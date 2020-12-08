package England.Origin.FirstPlugin.Commands.Infomation;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Ping implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        //Player player = (Player) sender;
        StringBuilder b = new StringBuilder(); // Coverts args into long string
        for (int i = 0; i < args.length; i++)
            b.append(args[i] + " ");
        if (cmd.getName().equalsIgnoreCase("ping")) { //no permission needed to use /report
            if (args.length == 0) {
                String e = sender.getName();
                if (e.equalsIgnoreCase("monderp")) {
                    sender.sendMessage("You suck Hasan");
                } else if (e.equalsIgnoreCase("origin658")) {
                    sender.sendMessage("Hi " + sender.getName() + " yes, your internet is working!");
                } else if (e.equalsIgnoreCase("XploderB")) {
                    sender.sendMessage("Oi oi sexy potato");
                }
                else {
                    sender.sendMessage("Pong!");
                }
            } else {
                sender.sendMessage(b.toString());
            }
        } if (cmd.getName().equalsIgnoreCase("pong")) { //no permission needed to use /report
            if (args.length == 0) {
                String e = sender.getName();
                if (e.equalsIgnoreCase("monderp")) {
                    sender.sendMessage("You suck Hasan");
                }  else if (e.equalsIgnoreCase("origin658")) {
                    sender.sendMessage("Hi " + sender.getName());
                } else if (e.equalsIgnoreCase("XploderB")) {
                    sender.sendMessage("Sup Sexy");
                }
                else {
                    sender.sendMessage("Ping!");
                }
            } else {
                sender.sendMessage(b.toString());
            }
        } if (label.equalsIgnoreCase("clear") || label.equalsIgnoreCase("pardon")) {
            sender.sendMessage(ChatColor.DARK_RED + "Unknown Command. Type /commands for help!");
        }
        if (cmd.getName().equalsIgnoreCase("poke")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") + "Erm... " + sender.getName() +  " please can you not poke me! :(");
        }


        return true; //ends commands statement
    }
}
