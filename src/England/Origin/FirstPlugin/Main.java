package England.Origin.FirstPlugin;


import England.Origin.FirstPlugin.Broadcasting.Broadcasting;
import England.Origin.FirstPlugin.Commands.Admin.*;
import England.Origin.FirstPlugin.Commands.Containers.enderchest;
import England.Origin.FirstPlugin.Commands.Containers.workbench;
import England.Origin.FirstPlugin.Commands.Fun.skull;
import England.Origin.FirstPlugin.Commands.Fun.reSpawn;
import England.Origin.FirstPlugin.Commands.Fun.tableflip;
import England.Origin.FirstPlugin.Commands.Fun.thor;
import England.Origin.FirstPlugin.Commands.Infomation.*;
import England.Origin.FirstPlugin.Commands.Message.*;
import England.Origin.FirstPlugin.Commands.Player.*;
import England.Origin.FirstPlugin.Commands.Teleporting.*;
import England.Origin.FirstPlugin.Commands.Toggles.*;
import England.Origin.FirstPlugin.Listeners.*;
import England.Origin.FirstPlugin.Player.Sleeping;
import England.Origin.FirstPlugin.Runnables.isPlayerAfkCheck;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.List;


public class Main extends JavaPlugin implements Listener {
   // public Broadcasting Broadcasting = new Broadcasting();
    public static Main instance;
    public List<String> pvptoggle = new ArrayList<>();
    public int sleepToggleBypass;
    @Override
    public void onEnable() {
        registercommands();
        registerlistners();
        instance = this;
        //Runs broadcast feature
        Broadcasting.voter();


        BukkitTask isPlayerAFKCheck =
                new isPlayerAfkCheck(this)
                        .runTaskTimerAsynchronously(this, 20l * 60 * 5, 20l * 60 * 5);


        saveDefaultConfig();//tes
        reloadConfig();

        sleepToggleBypass = this.getConfig().getInt("sleepToggle");
        getLogger().info("Sleep Toggle is set to " + sleepToggleBypass);
        getLogger().info("First-plugin has been enabled");
    }

    private void registercommands() {
        this.getCommand("vote").setExecutor(new Info());
        this.getCommand("donate").setExecutor(new Info());
        this.getCommand("colours").setExecutor(new Info());
        this.getCommand("discord").setExecutor(new Info());
        this.getCommand("website").setExecutor(new Info());
        this.getCommand("rules").setExecutor(new Rules());
        this.getCommand("prefix").setExecutor(new prefix());
        this.getCommand("sc").setExecutor(new GCommands());
        this.getCommand("dc").setExecutor(new GCommands());
        this.getCommand("bc").setExecutor(new GCommands());
        this.getCommand("spawn").setExecutor(new Spawn());
        this.getCommand("ask").setExecutor(new Ask());
        this.getCommand("answer").setExecutor(new Ask());
        this.getCommand("ping").setExecutor(new Ping());
        this.getCommand("pong").setExecutor(new Ping());
        this.getCommand("clear").setExecutor(new Ping());
        this.getCommand("poke").setExecutor(new Ping());
        this.getCommand("pardon").setExecutor(new Ping());
        this.getCommand("fp-reload").setExecutor(new reloadconfig());
        this.getCommand("respawn").setExecutor(new reSpawn());
        this.getCommand("nick").setExecutor(new nick());
        this.getCommand("removenick").setExecutor(new nick());
        this.getCommand("gamemode").setExecutor(new gamemodes());
        this.getCommand("fly").setExecutor(new fly());
        this.getCommand("vanish").setExecutor(new vanish());
        this.getCommand("god").setExecutor(new god());
        this.getCommand("pweather").setExecutor(new pweather());
        this.getCommand("heal").setExecutor(new heal());
        this.getCommand("workbench").setExecutor(new workbench());
        this.getCommand("enderchest").setExecutor(new enderchest());
        this.getCommand("list").setExecutor(new list());
        this.getCommand("staff").setExecutor(new onlinestaff());
        this.getCommand("ignore").setExecutor(new ignore());
        this.getCommand("clearinven").setExecutor(new clearinven());
        this.getCommand("invsee").setExecutor(new invsee());
        this.getCommand("warp").setExecutor(new warp());
        this.getCommand("setwarp").setExecutor(new setwarp());
        this.getCommand("delwarp").setExecutor(new delwarp());
        this.getCommand("getuuid").setExecutor(new getuuid());
        this.getCommand("skull").setExecutor(new skull());
        this.getCommand("me").setExecutor(new me());
        this.getCommand("togglekeepinven").setExecutor(new togglekeepinven());
        this.getCommand("togglekeepxp").setExecutor(new togglekeepxp());
        this.getCommand("fake").setExecutor(new fakejoinleave());
        this.getCommand("sudo").setExecutor(new sudo());
        this.getCommand("seen").setExecutor(new seen());
        this.getCommand("back").setExecutor(new back());
        this.getCommand("broadcast").setExecutor(new broadcast());
        this.getCommand("ignore").setExecutor(new ignore());
        this.getCommand("tpo").setExecutor(new tpo());
        this.getCommand("afk").setExecutor(new afk());
        this.getCommand("msg").setExecutor(new msg());
        this.getCommand("reply").setExecutor(new reply());
        this.getCommand("home").setExecutor(new home());
        this.getCommand("sethome").setExecutor(new sethome());
        this.getCommand("delhome").setExecutor(new delhome());
        this.getCommand("ahome").setExecutor(new ahome());
        this.getCommand("tpa").setExecutor(new tpa());
        this.getCommand("tpahere").setExecutor(new tpahere());
        this.getCommand("tpdeny").setExecutor(new tpdeny());
        this.getCommand("tptoggle").setExecutor(new tptoggle());
        this.getCommand("tpyes").setExecutor(new tpayes());
        this.getCommand("hat").setExecutor(new hat());
        this.getCommand("togglepvp").setExecutor(new pvptoggle());
        this.getCommand("voteperks").setExecutor(new voteperks());
        this.getCommand("thor").setExecutor(new thor());
        this.getCommand("tableflip").setExecutor(new tableflip());
        this.getCommand("unflip").setExecutor(new tableflip());
        this.getCommand("speed").setExecutor(new speed());
        this.getCommand("ptime").setExecutor(new ptime());
        this.getCommand("rtp").setExecutor(new rtp());
        this.getCommand("toggleendportal").setExecutor(new toggleEndPortal(this));
        this.getCommand("togglesleepbypass").setExecutor(new toggleSleepBypass(this));
        this.getCommand("getcords").setExecutor(new getPlayerLocation());
    }
    private void registerlistners(){
        getServer().getPluginManager().registerEvents(new DMessage(), this);
        Bukkit.getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new MOTD(), this);
        getServer().getPluginManager().registerEvents(new ColourCodes(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new PlayerLeave(), this);
        getServer().getPluginManager().registerEvents(new ignore(), this);
        getServer().getPluginManager().registerEvents(new afk(), this);
        getServer().getPluginManager().registerEvents(new pvptoggle(), this);
        getServer().getPluginManager().registerEvents(new ServerFull(), this);
        getServer().getPluginManager().registerEvents(new endPortal(this), this);
        getServer().getPluginManager().registerEvents(new Sleeping(), this);
        getServer().getPluginManager().registerEvents(new England.Origin.FirstPlugin.Listeners.reSpawn(), this);
    }
}