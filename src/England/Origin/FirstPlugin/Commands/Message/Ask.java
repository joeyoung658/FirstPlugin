package England.Origin.FirstPlugin.Commands.Message;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Ask implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        StringBuilder b = new StringBuilder(); // Coverts args into long string
        for (int i = 0; i < args.length; i++)
            b.append(args[i] + " ");
        if (cmd.getName().equalsIgnoreCase("ask")) { //no permission needed to use /report
            if (args.length == 0){
                player.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ")  +ChatColor.DARK_RED + "Incorrect Usage - /ask [Question]"); //if user does not add a question into the end
            }  else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ")  +ChatColor.AQUA + "Your question has been sent to online staff!"); //sends user a message telling them that their question has been sent
                    for (Player p : Bukkit.getOnlinePlayers()) { //same as above
                        if (p.hasPermission("<FP>.REPORT.R")) {
                            p.sendMessage(ChatColor.WHITE + "[" + ChatColor.AQUA + "Question" + ChatColor.WHITE + "] " + player.getDisplayName() + ": " + b.toString());

                        }
                    }
            }
        } if (cmd.getName().equalsIgnoreCase("answer")) { //no permission needed to use /report
            if (args.length == 0){
                player.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ")  +ChatColor.DARK_RED + "Incorrect Usage - /answer [Player Name] [Answer]"); //if user does not add a question into the end
            } else if (args.length == 1) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ")  +ChatColor.DARK_RED + "Incorrect Usage - /answer [Player Name] [Answer]"); //if user does not add a question into the end
            } else {
                Player target = Bukkit.getPlayerExact(args[0]); //checks to see if first argument is online
                if (target == null) { //if player isnt not online do below
                    player.sendMessage(ChatColor.AQUA + args[0] + " is not online!");
                } else { //if player is online do below
                    String message = "";
                    for(int i = 1; i != args.length; i++)
                        message += args[i] + " ";
                    Player m = Bukkit.getPlayer(args[0]);
                    //player.sendMessage(ChatColor.AQUA + "Your response has been sent to " + m.getDisplayName()); //sends user a message telling them that their report has been sent
                    m.sendMessage(ChatColor.WHITE + "[" + ChatColor.AQUA + "Question Answer" + ChatColor.WHITE + "] " +  ": " + message);
                    for (Player p : Bukkit.getOnlinePlayers()) { //gets all online players
                        if (p.hasPermission("<FP>.REPORT.R")) { //check if they have certain permission
                            p.sendMessage(ChatColor.WHITE + "[" + ChatColor.AQUA + "Question Answered" + ChatColor.WHITE + "] " +  ": " + m.getDisplayName() + " question answered by "
                                    + player.getDisplayName() + ChatColor.AQUA +" Message: " + ChatColor.WHITE + message ); //sends the message to the user
                        }
                    }

                }
            }
        }
        return true; //ends commands statement
    }
}