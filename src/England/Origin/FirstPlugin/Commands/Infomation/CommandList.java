package England.Origin.FirstPlugin.Commands;

//Help commands for user.

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;


public class CommandList implements CommandExecutor {


    List<String> normal = new ArrayList<String>(); {
        {
            normal.add(ChatColor.AQUA + "/lock - Locks any lockable item.");
            normal.add(ChatColor.AQUA + "/unlock - Unlocks your locked item.");
            normal.add(ChatColor.AQUA + "/cdonation - Create a donation chest that other players can only give items.");
            normal.add(ChatColor.AQUA + "/cmodify [PlayerName]/[-Playername] - Ability to add/remove a player onto a locked item.");
            normal.add(ChatColor.AQUA + "/report - Send a private message to all Admins online.");
            normal.add(ChatColor.AQUA + "/Admins - See available Admins online.");
            normal.add(ChatColor.AQUA + "/rules - Displays the rules to the user");
            normal.add(ChatColor.AQUA + "/Forum - Displays the forum link.");
            normal.add(ChatColor.AQUA + "/vote - Displays the voting links.");
            normal.add(ChatColor.AQUA + "/warp - View the warps.");
            normal.add(ChatColor.AQUA + "/warp <Warp name> - Teleports player to warp.");
            normal.add(ChatColor.AQUA + "/tpa <Player Name> - Sends a teleport request to another player.");
            normal.add(ChatColor.AQUA + "/sethome <name> - Sets a home.");
            normal.add( ChatColor.AQUA + "/home - View all homes created.");
            normal.add(ChatColor.AQUA + "/home <Home name> - Teleports to a home");
            normal.add(ChatColor.AQUA + "/suicide - Makes player commit suicide");
            normal.add(ChatColor.AQUA + "/twitter - View the servers twitter");
            normal.add(ChatColor.AQUA + "/tips - View the servers tips");
            normal.add( ChatColor.AQUA + "/build - View information about BOTM");
            normal.add(ChatColor.AQUA + "/tptoggle - Turns off TPA requests.");
            normal.add(ChatColor.AQUA + "/ask - Asks an online helper a question.");
            normal.add(ChatColor.AQUA + "/Party Create - Creates a party for the user");
            normal.add( ChatColor.AQUA + "/Party invite - invite party members to your party");
            normal.add(ChatColor.AQUA + "/Party leave - leaves the party");
            normal.add(ChatColor.AQUA + "/rtp - Teleports you to a random location");




        }}

    List<String> Alpha = new ArrayList<String>(); {
        {
            Alpha.add(ChatColor.AQUA + "/nick - Abilty to set a nick name, colour codes apply.");
            Alpha.add(ChatColor.AQUA + "/mobgrief [on/off] - Turns on/off mob greif on land");
            Alpha.add(ChatColor.AQUA + "/back - Return to death place/last teleport.");
            Alpha.add(ChatColor.AQUA + "/togglepvp - Enables you to toggle PVP mode");
            Alpha.add(ChatColor.AQUA + "/preifx - Displays all the prefix commands");
            Alpha.add(ChatColor.AQUA + "/tableflip - Enables you to flip a table in a spite of rage");
            Alpha.add(ChatColor.AQUA + "/unflip - Enables you to unflip a table");

        }}



    List<String> Omega = new ArrayList<String>(); {
        {
            Omega.add(ChatColor.AQUA + "/Enderchest - Able to open enderchest anywhere.");
            Omega.add(ChatColor.AQUA + "/skull - Allows you to give a skull of any player.");
            Omega.add(ChatColor.AQUA + "/pweather clear - Stops the rain for your player.");
            Omega.add(ChatColor.AQUA + "/workbench - Able to open a crafting table anywhere.");
            Omega.add(ChatColor.AQUA + "/hat - Wear any block as a hat.");
            Omega.add(ChatColor.AQUA + "/togglekeepinven - Toggles if you keep items on death");
            Omega.add(ChatColor.AQUA + "/togglekeepxp - Toggles if you keep XP on death");
            Omega.add(ChatColor.AQUA + "/togglekeepinven - Toggles if you keep items on death");
            Omega.add(ChatColor.AQUA + "/voteperks - View vote perks");
            Omega.add(ChatColor.AQUA + "/tiptoggle - Toggles if you see tips within chat");
            Omega.add(ChatColor.AQUA + "/removenick - Removes a player nick name");
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
                        sender.sendMessage(ChatColor.GRAY + "♦" + Alpha.get(0));
                        sender.sendMessage(ChatColor.GRAY + "♦" + Alpha.get(1));
                        sender.sendMessage(ChatColor.GRAY + "♦" + Alpha.get(2));
                        sender.sendMessage(ChatColor.GRAY + "♦" + Alpha.get(3));
                    } else if (args[0].equalsIgnoreCase("5")) {
                        sender.sendMessage("---------------" + ChatColor.YELLOW + "Commands 5/7" + ChatColor.WHITE + "----------------------");
                        sender.sendMessage(ChatColor.GRAY + "♦" + Alpha.get(4));
                        sender.sendMessage(ChatColor.GRAY + "♦" + Alpha.get(5) );
                        sender.sendMessage(ChatColor.GRAY + "♦" + Alpha.get(6));
                        sender.sendMessage(ChatColor.GRAY + "♦" +  Alpha.get(7));
                        sender.sendMessage(ChatColor.GRAY + "♦" + Alpha.get(8));
                        sender.sendMessage(ChatColor.GRAY + "♦" + Alpha.get(9));
                        sender.sendMessage(ChatColor.GRAY + "♦" +Alpha.get(10) );
                        sender.sendMessage(ChatColor.GRAY + "♦" +  Alpha.get(11));
                    } else if (args[0].equalsIgnoreCase("6")) {
                        sender.sendMessage("---------------" + ChatColor.YELLOW + "Commands 6/7" + ChatColor.WHITE + "----------------------");
                        sender.sendMessage(ChatColor.GRAY + "♦" +  Alpha.get(12));
                        sender.sendMessage(ChatColor.GRAY + "♦" +  Omega.get(0) );
                        sender.sendMessage(ChatColor.GRAY + "♦" + Omega.get(1));
                        sender.sendMessage(ChatColor.GRAY + "♦" + Omega.get(2) );
                        sender.sendMessage(ChatColor.GRAY + "♦" + Omega.get(3) );
                        sender.sendMessage(ChatColor.GRAY + "♦" +  Omega.get(4));
                        sender.sendMessage(ChatColor.GRAY + "♦" +  Omega.get(5) );

                    } else if (args[0].equalsIgnoreCase("7")) {
                        sender.sendMessage("---------------" + ChatColor.YELLOW + "Commands 7/7" + ChatColor.WHITE + "----------------------");
                        sender.sendMessage(ChatColor.GRAY + "♦" + Omega.get(6));
                        sender.sendMessage(ChatColor.GRAY + "♦" + Omega.get(7) );
                        sender.sendMessage(ChatColor.GRAY + "♦" + Omega.get(8) );
                        sender.sendMessage(ChatColor.GRAY + "♦" +  Omega.get(9));
                        sender.sendMessage(ChatColor.GRAY + "♦" + Omega.get(10) );


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

