//package England.Origin.FirstPlugin.Commands;
//
//
//import org.bukkit.Bukkit;
//import org.bukkit.ChatColor;
//import org.bukkit.Material;
//import org.bukkit.command.Command;
//import org.bukkit.command.CommandExecutor;
//import org.bukkit.command.CommandSender;
//import org.bukkit.entity.Player;
//import org.bukkit.event.inventory.InventoryType;
//import org.bukkit.event.inventory.PrepareAnvilEvent;
//import org.bukkit.inventory.Inventory;
//import org.bukkit.inventory.InventoryHolder;
//import org.bukkit.inventory.InventoryView;
//import org.bukkit.inventory.ItemStack;
//import org.bukkit.scheduler.BukkitRunnable;
//
//
//import java.util.HashMap;
//
//
//
//
//public class Anvil implements CommandExecutor {
//    private Inventory inv;
//    public HashMap<String, Long> cooldowns = new HashMap<String, Long>();
//
//    @Override
//    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
//        Player player = (Player) sender;
//        int cooldownTime = 7200; // Get number of seconds from wherever you want
//        if (!(player.hasPermission("<FP>.BYPASST"))) {
//            if (cooldowns.containsKey(sender.getName())) {
//                long secondsLeft = ((cooldowns.get(sender.getName()) / 1000) + cooldownTime) - (System.currentTimeMillis() / 1000);
//                if (secondsLeft > 0) {
//                    // Still cooling down
//                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ")  +ChatColor.DARK_RED + "You cannot use /anvil for another " + secondsLeft + " seconds!");
//
//                    return true;
//                }
//
//            }
//        }
//        // No cooldown found or cooldown has expired, save new cooldown
//        cooldowns.put(sender.getName(), System.currentTimeMillis());
//        if (cmd.getName().equalsIgnoreCase("anvil")) {
//            if (args.length == 0) {
//
//                ItemStack stack = new ItemStack(Material.DIRT,1 , (byte)3);
//
//
//
//                try {
//                    //ItemStack itemstack = null;
//                    inv = Bukkit.getServer().createInventory(null, InventoryType.ANVIL);
//
//                    InventoryView viewer = player.openInventory(inv);
//
//                    PrepareAnvilEvent event = new PrepareAnvilEvent(viewer, stack);
//
//                    Bukkit.getServer().getPluginManager().callEvent(event);
//
//                } catch (Exception e){
//                    Bukkit.getLogger().info(e.toString());
//                }
//
//            } else {
//                player.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ")  +ChatColor.DARK_RED + "Incorrect arguments: /anvil");
//            }
//        }
//        return true;
//    }
//}
//
//
//
//
//
//
