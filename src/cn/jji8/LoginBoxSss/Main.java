package cn.jji8.LoginBoxSss;

import cn.jji8.LoginBoxSss.timeout.TimeoutHandler;
import cn.jji8.LoginBoxSss.ip.IpManager;
import cn.jji8.LoginBoxSss.login.BungeeHandler;
import cn.jji8.LoginBoxSss.login.LoginListener;
import cn.jji8.LoginBoxSss.login.PlayerListener;
import cn.jji8.LoginBoxSss.command.ForceUnregisterCommand;
import cn.jji8.LoginBoxSss.command.ChangePasswordCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    static Main main;
    static WrappedConfiguration WrappedConfiguration;
    public static Main getMain() {
        return main;
    }
    public static WrappedConfiguration getWrappedConfiguration() {
        return WrappedConfiguration;
    }

    public void onEnable(){
        Bukkit.getLogger().info("[箱子登入X]:正在载入...");
        main = this;
        saveDefaultConfig();
        WrappedConfiguration = new WrappedConfiguration();
        //注册玩家控制器
        PlayerListener playerListener = new PlayerListener();
        Bukkit.getPluginManager().registerEvents(playerListener,this);
        //注册登入控制器
        LoginListener LoginListener = new LoginListener();
        Bukkit.getPluginManager().registerEvents(LoginListener,this);
        //注册命令
        Bukkit.getPluginCommand("xgmm").setExecutor(new ChangePasswordCommand());
        Bukkit.getPluginCommand("qzwjcxzc").setExecutor(new ForceUnregisterCommand());
        //超时管理
        if(WrappedConfiguration.kickPlayerOnTimeout){
            TimeoutHandler TimeoutHandler = new TimeoutHandler();
            Bukkit.getPluginManager().registerEvents(TimeoutHandler,this);
        }
        //ip限制
        if(WrappedConfiguration.ipManager){
            IpManager ipManager = new IpManager();
            Bukkit.getPluginManager().registerEvents(ipManager,this);
        }
        //ip限制
        if(WrappedConfiguration.bungeeMode){
            Bukkit.getLogger().info("[箱子登入X]:BC模式开启，工作路径是："+ WrappedConfiguration.workDir);
            BungeeHandler bungeeHandler = new BungeeHandler();
            Bukkit.getPluginManager().registerEvents(bungeeHandler,this);
        }
        Bukkit.getLogger().info("[箱子登入X]:载入完成");
    }
}
