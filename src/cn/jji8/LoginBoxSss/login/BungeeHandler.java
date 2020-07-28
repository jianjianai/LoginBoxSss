package cn.jji8.LoginBoxSss.login;

import cn.jji8.LoginBoxSss.Main;
import cn.jji8.LoginBoxSss.event.LoginSuccessEvent;
import cn.jji8.LoginBoxSss.event.PlayerRegisterSuccessEvent;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;
import java.io.IOException;

public class BungeeHandler implements Listener{
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent a){
        Thread T = new Thread(){
            @Override
            public void run() {
                File File = new File(Main.getWrappedConfiguration().workDir + "/登入状态/" + a.getPlayer().getName()+".yml");
                YamlConfiguration wanjiawenjian = YamlConfiguration.loadConfiguration(File);
                if(wanjiawenjian.getBoolean("已登入")){
                    LoginManager.setPlayerLoggedIn(a.getPlayer().getName());
                }
            }
        };
        T.start();
    }
    @EventHandler
    public void onPlayerLoginSuccessfully(LoginSuccessEvent a){
        setLoggedIn(a.getPlayer());
    }
    @EventHandler
    public void onPlayerJoin(PlayerRegisterSuccessEvent a){
        setLoggedIn(a.getPlayer());
    }
    public void setLoggedIn(Player p){
        Bukkit.getScheduler().runTaskAsynchronously(Main.getMain(), () -> {
            File File = new File(Main.getWrappedConfiguration().workDir + "/登入状态/" + p.getName()+".yml");
            YamlConfiguration wanjiawenjian = YamlConfiguration.loadConfiguration(File);
            wanjiawenjian.set("已登入",true);
            try {
                wanjiawenjian.save(File);
            } catch (IOException e) {
                e.printStackTrace();
                Bukkit.getLogger().warning("[箱子登入X]:登入状态保存失败，请检查文件权限和磁盘空间。");
            }
        });
    }
}
