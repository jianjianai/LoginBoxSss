package cn.jji8.LoginBoxSss.kongziqi;

import cn.jji8.LoginBoxSss.main;
import cn.jji8.LoginBoxSss.shijian.drcg;
import cn.jji8.LoginBoxSss.shijian.zccg;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;
import java.io.IOException;

public class BCmoshi implements Listener{
    @EventHandler
    public void wanjianjingru(PlayerJoinEvent a){
        Thread T = new Thread(){
            @Override
            public void run() {
                File File = new File(main.getPeizi().工作路径 + "/登入状态/" + a.getPlayer().getName()+".yml");
                YamlConfiguration wanjiawenjian = YamlConfiguration.loadConfiguration(File);
                if(wanjiawenjian.getBoolean("已登入")){
                    wanjiasezi.setwanjiayidengru(a.getPlayer().getName());
                }
            }
        };
        T.start();
    }
    @EventHandler
    public void wanjianjingru(drcg a){
        yidenru(a.getPlayer());
    }
    @EventHandler
    public void wanjianjingru(zccg  a){
        yidenru(a.getPlayer());
    }
    public void yidenru(Player a){
        Thread T = new Thread(){
            @Override
            public void run() {
                File File = new File(main.getPeizi().工作路径 + "/登入状态/" + a.getName()+".yml");
                YamlConfiguration wanjiawenjian = YamlConfiguration.loadConfiguration(File);
                wanjiawenjian.set("已登入",true);
                try {
                    wanjiawenjian.save(File);
                } catch (IOException e) {
                    e.printStackTrace();
                    Bukkit.getLogger().warning("[箱子登入X]:登入状态保存失败，请检查文件权限和磁盘空间。");
                }
            }
        };
        T.start();
    }
}
