//
//package England.Origin.FirstPlugin.Listeners;
//
////Prevents portal bug
//
//import org.bukkit.Bukkit;
//import org.bukkit.Material;
//import org.bukkit.block.BlockFace;
//import org.bukkit.event.EventHandler;
//import org.bukkit.event.Listener;
//import org.bukkit.event.player.PlayerJoinEvent;
//
//
//public class PSpawn implements Listener {
//
//    @EventHandler
//    public void onPlayerJoinEvent(PlayerJoinEvent event) {
//        if (event.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.OBSIDIAN) {
//            int x = (event.getPlayer().getLocation().getBlockX());
//            int y = (event.getPlayer().getLocation().getBlockY());
//            int z = (event.getPlayer().getLocation().getBlockZ());
//            String move = "tp " + event.getPlayer().getName() + " " + x + " " + y + " " + (z+3);
//            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), move);
//        }
//    }
//
//}
//
//
//
//
