//package England.Origin.FirstPlugin.Listeners;
//
//import England.Origin.FirstPlugin.Main;
//import org.bukkit.*;
//import org.bukkit.block.Block;
//import org.bukkit.block.CreatureSpawner;
//import org.bukkit.entity.EntityType;
//import org.bukkit.event.EventHandler;
//import org.bukkit.event.Listener;
//import org.bukkit.event.block.Action;
//import org.bukkit.event.player.PlayerInteractEvent;
//import org.bukkit.inventory.ItemStack;
//
//
//public class SpawnerEggBlock implements Listener {
    //Prevent users from using spawn eggs on spanners without correct permission.
    //Using egg on spawner listener


   // private boolean blockCreative;
    //Config File
//    public void reloadConfiguration() { //Reloads config
//        Main.instance.saveDefaultConfig();
//        Main.instance.reloadConfig();
//
//        if (!Main.instance.getConfig().isSet("message") || !Main.instance.getConfig().isString("message")) {
//            Main.instance.getLogger().warning("\"message\" not set or invalid in config, resetting to default");
//            Main.instance.getConfig().set("message", "&cChanging spawners using mob eggs is disabled on this server!");
//            Main.instance.saveConfig();
//        }
//
//        if (!Main.instance.getConfig().isSet("block-creative") || !Main.instance.getConfig().isBoolean("block-creative")) {
//            getLogger().warning("\"block-creative\" not set or invalid in config, resetting to default");
//            getConfig().set("block-creative", false);
//            saveConfig();
//        }
//
//        this.message = getConfig().getString("message");
//        this.blockCreative = getConfig().getBoolean("block-creative");
//    }
//
//    private String message;
//    @EventHandler
//    public void onPlayerInteract(PlayerInteractEvent e)
//    {
//        message = "&cChanging spawners using mob eggs is disabled on this server";
//        if (e.getPlayer().getGameMode() == GameMode.CREATIVE)
//            return;
//
//        if (e.getPlayer().isOp() || e.getPlayer().hasPermission("mobegg.override"))
//            return;
//
//        if (e.getAction() != Action.RIGHT_CLICK_BLOCK && e.getAction() != Action.LEFT_CLICK_BLOCK)
//            return;
//
//        Block b = e.getClickedBlock();
//
//        if (b == null)
//            return;
//
//        if (b.getType() != Material.MOB_SPAWNER)
//            return;
//
//        ItemStack i = e.getItem();
//
//        if (i == null)
//            return;
//
//        if (i.getType() != Material.MONSTER_EGG && i.getType() != Material.MONSTER_EGGS)
//            return;
//
//        CreatureSpawner cs = (CreatureSpawner) b.getState();
//
//        final Location loc = cs.getLocation();
//        final EntityType type = cs.getSpawnedType();
//
//        if (message != null && !message.isEmpty())
//            e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', message));
//
//        e.setCancelled(true);
//
//        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
//        {
//            @Override
//            public void run()
//            {
//                Block b = loc.getBlock();
//
//                if (b == null || b.getType() != Material.MOB_SPAWNER)
//                    return;
//
//                CreatureSpawner cs = (CreatureSpawner) b.getState();
//
//                cs.setSpawnedType(type);
//            }
//        });
//    }
//
//    }






