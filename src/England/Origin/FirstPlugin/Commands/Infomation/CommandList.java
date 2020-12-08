package England.Origin.FirstPlugin.Commands.Infomation;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

//Todo make it build the pages it's self

public class CommandList implements CommandExecutor {

    List<String> normal = new ArrayList<String>(); {
        {
			normal.add(ChatColor.AQUA + "/rules - View the rules list.");
			normal.add(ChatColor.AQUA + "/vote - View the links to voting websites.");
			normal.add(ChatColor.AQUA + "/spawn - Teleport to the spawn.");
			normal.add(ChatColor.AQUA + "/warps - View the list of warps.");
			normal.add(ChatColor.AQUA + "/warp [warp] - Warp to a set location.");
			normal.add(ChatColor.AQUA + "/rtp - Teleports you to a random location");
			normal.add(ChatColor.AQUA + "/sethome [Name] - Set a teleport location that only you can use.");
			normal.add(ChatColor.AQUA + "/homes - View a list of your homes.");
			normal.add(ChatColor.AQUA + "/home [Name] - Teleport to a home you've already set.");
			normal.add(ChatColor.AQUA + "/delhome [Name] - Delete an existing home teleport.");
			normal.add(ChatColor.AQUA + "/tpa [Player Name] - Send a request to teleport to a player. ");
			normal.add(ChatColor.AQUA + "/tpahere [Player Name] - Send a request to teleport a player to you.");
			normal.add(ChatColor.AQUA + "/tpyes - Accept the most recent teleport request.");
			normal.add(ChatColor.AQUA + "/tpno - Deny the most recent teleport request.");
			normal.add(ChatColor.AQUA + "/tptoggle - Turns off TPA requests.");
            normal.add(ChatColor.AQUA + "/report - Send a private message to all Admins online.");
			normal.add(ChatColor.AQUA + "/respawn - Sets your health to zero, respawning you.");
            normal.add(ChatColor.AQUA + "/admins - See available Admins online.");
            normal.add(ChatColor.AQUA + "/ask - Asks an online helper a question.");
			normal.add(ChatColor.AQUA + "/website - Sends you a link to the All Ace Website");
			normal.add(ChatColor.AQUA + "/discord - Sends you a link to the All Ace Discord");
			normal.add(ChatColor.AQUA + "/claimbook - Gives you the Claim Book, a guide on how to claim land.");
			normal.add(ChatColor.AQUA + "/pm [Player's Name] [message] - Privately message a player.");
			normal.add(ChatColor.AQUA + "/r [message] - Reply to the most recent person that Private Messaged you. ");
			normal.add(ChatColor.AQUA + "/ping - Test how much you're lagging.");
			normal.add(ChatColor.AQUA + "/ignore [Player's Name] - Block incoming messages from a certain player.");
			normal.add(ChatColor.AQUA + "/afk - Alert everyone that you are AFK.");
			normal.add(ChatColor.AQUA + "/chips - Check how many chips you have");
			normal.add(ChatColor.AQUA + "/store help - See the list of things you can purchase using your chips.");
			normal.add(ChatColor.AQUA + "/buy - Open a pop-up to see what packages are available to buy.");
			normal.add(ChatColor.AQUA + "/tableflip - Flip a table and show your anger!");
			normal.add(ChatColor.AQUA + "/unflip - Fix the damage you have caused!");
        }}

    List<String> queenRank = new ArrayList<String>(); {
        {
            queenRank.add(ChatColor.AQUA + "/colours - View the list of colours you can use in chat.");
			queenRank.add(ChatColor.AQUA + "/nick [nick] - Allows you to assign a nickname to yourself. /Colours are compatible.");
			queenRank.add(ChatColor.AQUA + "/removenick - Returns your name back to your in-game name.");
			queenRank.add(ChatColor.AQUA + "/prefix - Shows how you can change/restore/remove your prefix.");
			queenRank.add(ChatColor.AQUA + "/dc - Allows you to talk in the Donor Chat.");
			queenRank.add(ChatColor.AQUA + "/hat - Allows you to place the currently equiped item on your head.");
			queenRank.add(ChatColor.AQUA + "/togglekeepxp - Allows you to toggle if you want to keep your XP on death.");
			queenRank.add(ChatColor.AQUA + "/pweather ['Clear'/'Rain'/'Reset'] - Allows you to set the local weather. (Only affects you).");
			queenRank.add(ChatColor.AQUA + "/ptime [Time/'Reset'] - Allows you to set the local weather. Only affects you).");
			queenRank.add(ChatColor.AQUA + "/skull [Player's Name] - Allows you to take the head of a player, onlien or not.");
			queenRank.add(ChatColor.AQUA + "/ct - Access your virtual crafting table.");

        }}

    List<String> kingRank = new ArrayList<String>(); {
        {
            kingRank.add(ChatColor.AQUA + "/enderchest - Access your virtual ender chest.");
			kingRank.add(ChatColor.AQUA + "/togglekeepinven - Allows you to toggle if you want to keep your inventory on death.");
			kingRank.add(ChatColor.AQUA + "/back - Teleport back to the location you just teleported from or died at.");
        }}


    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        if (alias.equalsIgnoreCase("commands")) {
                if (args.length == 0) { //Sender only typed '/commands' and nothing else
                    sender.sendMessage(ChatColor.YELLOW + "Type /commands [n] for n page of commands");
                    sender.sendMessage("---------------" + ChatColor.YELLOW + "Commands 1/7" + ChatColor.WHITE + "----------------------");
                    sender.sendMessage(ChatColor.GRAY + "♦" + normal.get(0));
                    sender.sendMessage(ChatColor.GRAY + "♦" + normal.get(1));
                    sender.sendMessage(ChatColor.GRAY + "♦"  + normal.get(2));
                    sender.sendMessage(ChatColor.GRAY + "♦" + normal.get(3));
                    sender.sendMessage(ChatColor.GRAY + "♦" + normal.get(4) );
                    sender.sendMessage(ChatColor.GRAY + "♦" + normal.get(5) );
                } else { //Sender typed more then 1 argument, so args[0] can't be null.
                    if (args[0].equalsIgnoreCase("2")) { //Sender typed 'commands 2'
                        sender.sendMessage("---------------" + ChatColor.YELLOW + "Commands 2/7" + ChatColor.WHITE + "----------------------");
                        sender.sendMessage(ChatColor.GRAY + "♦" + normal.get(6) );
                        sender.sendMessage(ChatColor.GRAY + "♦" + normal.get(7) );
                        sender.sendMessage(ChatColor.GRAY + "♦" + normal.get(8) );
                        sender.sendMessage(ChatColor.GRAY + "♦" + normal.get(9) );
                        sender.sendMessage(ChatColor.GRAY + "♦" + normal.get(10) );
                        sender.sendMessage(ChatColor.GRAY + "♦" + normal.get(11) );
                        sender.sendMessage(ChatColor.GRAY + "♦" + normal.get(12) );
                        sender.sendMessage(ChatColor.GRAY + "♦" + normal.get(13) );
                    } else if (args[0].equalsIgnoreCase("3")) { //if sender typed commands 3
                        sender.sendMessage("---------------" + ChatColor.YELLOW + "Commands 3/7" + ChatColor.WHITE + "----------------------");
                        sender.sendMessage(ChatColor.GRAY + "♦" + normal.get(14) );
                        sender.sendMessage(ChatColor.GRAY + "♦" + normal.get(15) );
                        sender.sendMessage(ChatColor.GRAY + "♦" + normal.get(16) );
                        sender.sendMessage(ChatColor.GRAY + "♦" + normal.get(17) );
                        sender.sendMessage(ChatColor.GRAY + "♦" + normal.get(18) );
                        sender.sendMessage(ChatColor.GRAY + "♦" + normal.get(19) );
                        sender.sendMessage(ChatColor.GRAY + "♦" + normal.get(20) );
                        //sender.sendMessage(ChatColor.RED + "" + ChatColor.UNDERLINE + "Party Chat commands");
                    } else if (args[0].equalsIgnoreCase("4")) { //if sender typed commands 4
                        sender.sendMessage("---------------" + ChatColor.YELLOW + "Commands 4/7" + ChatColor.WHITE + "----------------------");
                        sender.sendMessage(ChatColor.GRAY + "♦" + normal.get(21) );
                        sender.sendMessage(ChatColor.GRAY + "♦" + normal.get(22) );
                        sender.sendMessage(ChatColor.GRAY + "♦" + normal.get(23) );
                        sender.sendMessage(ChatColor.GRAY + "♦" + normal.get(24) );
                        sender.sendMessage(ChatColor.GRAY + "♦" + queenRank.get(0));
                        sender.sendMessage(ChatColor.GRAY + "♦" + queenRank.get(1));
                        sender.sendMessage(ChatColor.GRAY + "♦" + queenRank.get(2));
                        sender.sendMessage(ChatColor.GRAY + "♦" + queenRank.get(3));
                    } else if (args[0].equalsIgnoreCase("5")) {
                        sender.sendMessage("---------------" + ChatColor.YELLOW + "Commands 5/7" + ChatColor.WHITE + "----------------------");
                        sender.sendMessage(ChatColor.GRAY + "♦" + queenRank.get(4));
                        sender.sendMessage(ChatColor.GRAY + "♦" + queenRank.get(5) );
                        sender.sendMessage(ChatColor.GRAY + "♦" + queenRank.get(6));
                        sender.sendMessage(ChatColor.GRAY + "♦" +  queenRank.get(7));
                        sender.sendMessage(ChatColor.GRAY + "♦" + queenRank.get(8));
                        sender.sendMessage(ChatColor.GRAY + "♦" + queenRank.get(9));
                        sender.sendMessage(ChatColor.GRAY + "♦" + queenRank.get(10) );
                        sender.sendMessage(ChatColor.GRAY + "♦" +  queenRank.get(11));
                    } else if (args[0].equalsIgnoreCase("6")) {
                        sender.sendMessage("---------------" + ChatColor.YELLOW + "Commands 6/7" + ChatColor.WHITE + "----------------------");
                        sender.sendMessage(ChatColor.GRAY + "♦" +  queenRank.get(12));
                        sender.sendMessage(ChatColor.GRAY + "♦" +  kingRank.get(0) );
                        sender.sendMessage(ChatColor.GRAY + "♦" + kingRank.get(1));
                        sender.sendMessage(ChatColor.GRAY + "♦" + kingRank.get(2) );
                        sender.sendMessage(ChatColor.GRAY + "♦" + kingRank.get(3) );
                        sender.sendMessage(ChatColor.GRAY + "♦" +  kingRank.get(4));
                        sender.sendMessage(ChatColor.GRAY + "♦" +  kingRank.get(5) );

                    } else if (args[0].equalsIgnoreCase("7")) {
                        sender.sendMessage("---------------" + ChatColor.YELLOW + "Commands 7/7" + ChatColor.WHITE + "----------------------");
                        sender.sendMessage(ChatColor.GRAY + "♦" + kingRank.get(6));
                        sender.sendMessage(ChatColor.GRAY + "♦" + kingRank.get(7) );
                        sender.sendMessage(ChatColor.GRAY + "♦" + kingRank.get(8) );
                        sender.sendMessage(ChatColor.GRAY + "♦" +  kingRank.get(9));
                        sender.sendMessage(ChatColor.GRAY + "♦" + kingRank.get(10) );


                    }  else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.DARK_RED + "Error:" + ChatColor.WHITE + " " + args[0] + " is an incorrect page number! Only pages 1-7 are valid");

                    }
                    return true;
                }
                return true;

        }

        return true;



    }

}

