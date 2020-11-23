package England.Origin.FirstPlugin.Commands.Player;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

/**
 * Created by josep on 13/02/2017.
 */
public class hat implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("hat")) {
                if (!(sender instanceof Player)) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +"This command can only be run by players!");
                    return true;
                }
                Player player = (Player) sender;
                if (player.hasPermission("<FP>.hat")) {
                    ItemStack hand = player.getInventory().getItemInMainHand();
                    player.getInventory().remove(hand);
                    if (!(player.getInventory().getHelmet() == null)) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "You've dropped your old hat on the floor.");
                        ItemStack head = player.getInventory().getHelmet();
                        player.getWorld().dropItemNaturally(player.getLocation(), head);
                    }
                    player.getInventory().setHelmet(hand);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.AQUA + "Honestly, I can't believe that even fit on your head!");
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ") +ChatColor.RED + "This is a donator only command, use /donate to find out more!");
                }

        }
        return false;
    }
}
