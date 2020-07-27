package cn.jji8.LoginBoxSss.kongziqi;

import cn.jji8.LoginBoxSss.main;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;

public class BCmoshi implements Listener{
    @EventHandler
    public void wanjianjingru(PlayerJoinEvent a){
        File File = new File(main.getPeizi().工作路径 + "/登入状态/" + a.getPlayer().getName()+".yml");
        YamlConfiguration wanjiawenjian = YamlConfiguration.loadConfiguration(File);
        if(wanjiawenjian.getBoolean("需要登入")){
            return;
        }else {
            wanjiasezi.setwanjiayidengru(a.getPlayer().getName());
        }
    }
}
