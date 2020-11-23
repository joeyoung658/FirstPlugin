package England.Origin.FirstPlugin;



import England.Origin.FirstPlugin.Broadcasting.Broadcasting;
import England.Origin.FirstPlugin.Commands.Admin.*;
import England.Origin.FirstPlugin.Commands.Containers.enderchest;
import England.Origin.FirstPlugin.Commands.Containers.workbench;
import England.Origin.FirstPlugin.Commands.Fun.skull;
import England.Origin.FirstPlugin.Commands.Fun.suicide;
import England.Origin.FirstPlugin.Commands.Fun.tableflip;
import England.Origin.FirstPlugin.Commands.Fun.thor;
import England.Origin.FirstPlugin.Commands.Infomation.*;
import England.Origin.FirstPlugin.Commands.Message.*;
import England.Origin.FirstPlugin.Commands.Player.*;
import England.Origin.FirstPlugin.Commands.Teleporting.*;
import England.Origin.FirstPlugin.Commands.Toggles.*;
import England.Origin.FirstPlugin.Listeners.*;

import England.Origin.FirstPlugin.Player.Sleeping;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;


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
        afk.isafk();
        //creates/reloads config
        saveDefaultConfig();//test
        reloadConfig();
        //this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        sleepToggleBypass = this.getConfig().getInt("sleepToggle");
        getLogger().info("Sleep Toggle is set to " + sleepToggleBypass);
        getLogger().info("First-plugin has been enabled");
    }

    private void registercommands() {
        this.getCommand("vote").setExecutor(new Info());
        this.getCommand("donate").setExecutor(new Info());
        this.getCommand("colours").setExecutor(new Info());
        //this.getCommand("twitter").setExecutor(new Info());
       // this.getCommand("build").setExecutor(new Info());
        this.getCommand("discord").setExecutor(new Info());
        this.getCommand("website").setExecutor(new Info());
       // this.getCommand("steam").setExecutor(new Info());
        //Help with Commands
        //this.getCommand("commands").setExecutor(new CommandList());
        //Server Rules
        this.getCommand("rules").setExecutor(new Rules());
        //Prefix Commands
        this.getCommand("prefix").setExecutor(new prefix());
        //Add or remove member from land
        //Group Chat Commands
        this.getCommand("sc").setExecutor(new GCommands());
        this.getCommand("dc").setExecutor(new GCommands());
        this.getCommand("bc").setExecutor(new GCommands());
        //Spawn Command
        this.getCommand("spawn").setExecutor(new Spawn());
        //Chat Command
        //this.getCommand("chat").setExecutor(new DisableC());
        //BroadCasting
        this.getCommand("tips").setExecutor(new tips());
        //ask
        this.getCommand("ask").setExecutor(new Ask());
        this.getCommand("answer").setExecutor(new Ask());
        //ping
        this.getCommand("ping").setExecutor(new Ping());
        this.getCommand("pong").setExecutor(new Ping());
        this.getCommand("clear").setExecutor(new Ping());
        this.getCommand("poke").setExecutor(new Ping());
        this.getCommand("pardon").setExecutor(new Ping());
        //reloadconfig
        this.getCommand("fp-reload").setExecutor(new reloadconfig());
        //suicide
        this.getCommand("suicide").setExecutor(new suicide());
        //nick
        this.getCommand("nick").setExecutor(new nick());
        this.getCommand("removenick").setExecutor(new nick());
        //gamemodes
        this.getCommand("gamemode").setExecutor(new gamemodes());
        //fly
        this.getCommand("fly").setExecutor(new fly());
        //vanish
        this.getCommand("vanish").setExecutor(new vanish());
        //god
        this.getCommand("god").setExecutor(new god());
        //pweather
        this.getCommand("pweather").setExecutor(new pweather());
        //heal
        this.getCommand("heal").setExecutor(new heal());
        //CraftingTable
        this.getCommand("workbench").setExecutor(new workbench());
        //enderchest
        this.getCommand("enderchest").setExecutor(new enderchest());
        //list
        this.getCommand("list").setExecutor(new list());
        this.getCommand("staff").setExecutor(new onlinestaff());
        //ignore
        this.getCommand("ignore").setExecutor(new ignore());
        //clearinven
        this.getCommand("clearinven").setExecutor(new clearinven());
        //invesee
        this.getCommand("invsee").setExecutor(new invsee());
        //warp
        this.getCommand("warp").setExecutor(new warp());
        this.getCommand("setwarp").setExecutor(new setwarp());
        this.getCommand("delwarp").setExecutor(new delwarp());
        //getuuid
        this.getCommand("getuuid").setExecutor(new getuuid());
        //skull
        this.getCommand("skull").setExecutor(new skull());
        //me
        this.getCommand("me").setExecutor(new me());
        //keepinven
        this.getCommand("togglekeepinven").setExecutor(new togglekeepinven());
        this.getCommand("togglekeepxp").setExecutor(new togglekeepxp());
        //fake
        this.getCommand("fake").setExecutor(new fakejoinleave());
        //sudo
        this.getCommand("sudo").setExecutor(new sudo());
        //seen
        this.getCommand("seen").setExecutor(new seen());
        //back
        this.getCommand("back").setExecutor(new back());
        //broadcast
        this.getCommand("broadcast").setExecutor(new broadcast());
        //ingore
        this.getCommand("ignore").setExecutor(new ignore());
        //tpo
        this.getCommand("tpo").setExecutor(new tpo());
        //afk
        this.getCommand("afk").setExecutor(new afk());
        //msg
        this.getCommand("msg").setExecutor(new msg());
        this.getCommand("reply").setExecutor(new reply());
        //home
        this.getCommand("home").setExecutor(new home());
        this.getCommand("sethome").setExecutor(new sethome());
        this.getCommand("delhome").setExecutor(new delhome());
        this.getCommand("ahome").setExecutor(new ahome());
        //tpa
        this.getCommand("tpa").setExecutor(new tpa());
        this.getCommand("tpahere").setExecutor(new tpahere());
        this.getCommand("tpdeny").setExecutor(new tpdeny());
        this.getCommand("tptoggle").setExecutor(new tptoggle());
        this.getCommand("tpyes").setExecutor(new tpayes());
        //hat
        this.getCommand("hat").setExecutor(new hat());
        //pvp toggle
        this.getCommand("togglepvp").setExecutor(new pvptoggle());
        //tiptoggle
        //this.getCommand("tiptoggle").setExecutor(new tiptoggle());
        //voteperks
        this.getCommand("voteperks").setExecutor(new voteperks());
        //censor
        //this.getCommand("censor").setExecutor(new Censor());
        //thor
        this.getCommand("thor").setExecutor(new thor());
        //tableflip
        this.getCommand("tableflip").setExecutor(new tableflip());
        this.getCommand("unflip").setExecutor(new tableflip());
        //speed
        this.getCommand("speed").setExecutor(new speed());
        //restoreinve
        this.getCommand("restoreinven").setExecutor(new restoreInven());
        //ptime
        this.getCommand("ptime").setExecutor(new ptime());
        //serverconnections
//        this.getCommand("smp").setExecutor(new smp());
//        this.getCommand("hub").setExecutor(new hub());
//        this.getCommand("factions").setExecutor(new factions());
        //rtp
        this.getCommand("rtp").setExecutor(new rtp());

        this.getCommand("toggleendportal").setExecutor(new toggleEndPortal(this));

        this.getCommand("togglesleepbypass").setExecutor(new toggleSleepBypass(this));

        this.getCommand("getcords").setExecutor(new getPlayerLocation());


    }
    private void registerlistners(){
        getServer().getPluginManager().registerEvents(new DMessage(), this);
        Bukkit.getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new MOTD(), this);
        //getServer().getPluginManager().registerEvents(new SpawnerEggBlock(), this);
        getServer().getPluginManager().registerEvents(new ColourCodes(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new PlayerLeave(), this);
        getServer().getPluginManager().registerEvents(new ignore(), this);
        getServer().getPluginManager().registerEvents(new afk(), this);
        getServer().getPluginManager().registerEvents(new pvptoggle(), this);
        getServer().getPluginManager().registerEvents(new ServerFull(), this);
        getServer().getPluginManager().registerEvents(new endPortal(this), this);
        getServer().getPluginManager().registerEvents(new Sleeping(), this);
        getServer().getPluginManager().registerEvents(new reSpawn(), this);
        //getServer().getPluginManager().registerEvents(new DenyBlockBreak(), this);
    }
}