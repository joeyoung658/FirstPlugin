package England.Origin.FirstPlugin.Commands.Fun;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import net.minecraft.server.v1_16_R2.Item;
import net.minecraft.server.v1_16_R2.TileEntitySkull;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.Base64;
import java.util.UUID;

/**
 * Created by josep on 07/01/2017.
 */
public class skull implements CommandExecutor {


    //todo Fix the  below


    @SuppressWarnings( "deprecation" )
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("skull")) {
            if (sender.hasPermission("<FP>.skull")) {
                if (!(sender instanceof Player)) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +"This command can only be run by a player!");
                    return true;
                } else {
                    Player player = (Player) sender;
                    if (args.length == 1) {


                        Player target = Bukkit.getPlayerExact(args[0]);
                        ItemStack stack = new ItemStack(Material.PLAYER_HEAD,1 , (byte)3);
                        SkullMeta  meta = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.PLAYER_HEAD);


                        String playername;
                        if (target == null) {
                            playername = args[0];
                            OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(args[0]);
                            meta.setOwningPlayer(offlinePlayer);
                        } else {
                            playername = target.getDisplayName();
                            meta.setOwningPlayer(target);
                        }


                        stack.setItemMeta(meta);
                        player.getInventory().addItem(stack);

                        player.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You've stolen " + playername  + ChatColor.AQUA + "'s head " +  "and hidden it in your inventory!");
                        return true;
                    } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED  + "Incorrect arguments! /skull [PlayerName]");
                    }
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "This is a donator only command, use /donate to find out more!");
            }
        }
        return true;
    }


    //https://gist.githubusercontent.com/Jofkos/79af290e94acdc7d7d5b/raw/cd724528c931ac31b7a9bb31c5a6b399d444cca8/GameProfileBuilder.java



}