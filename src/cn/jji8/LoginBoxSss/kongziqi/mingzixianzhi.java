package cn.jji8.LoginBoxSss.kongziqi;

import cn.jji8.LoginBoxSss.main;
import cn.jji8.LoginBoxSss.shijian.drcg;
import cn.jji8.LoginBoxSss.shijian.lobinboxsss;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;

/*
* 名字限制
* */
public class mingzixianzhi implements Listener{
    @EventHandler
    public void wanjianjingru(PlayerJoinEvent a){
        Thread T = new Thread(){
            @Override
            public void run() {
                String wanjia = a.getPlayer().getName();
                if (!wanjia.matches(main.getPeizi().允许名字范围)){
                    BukkitRunnable R = new BukkitRunnable() {
                        @Override
                        public void run() {
                            a.getPlayer().kickPlayer("名字必修使用"+main.getPeizi().允许名字范围+"内的字符");
                        }
                    };
                    R.runTask(main.getMian());
                    return;
                }
                if(!main.getPeizi().同名大小不同禁止进入) {
                    return;
                }
                YamlConfiguration b;
                if(main.getPeizi().bc模式){
                    b = YamlConfiguration.loadConfiguration(new File(main.getPeizi().工作路径,"Playerlist/"+wanjia.toUpperCase()+".yml"));
                }else {
                    b = YamlConfiguration.loadConfiguration(new File(main.getMian().getDataFolder(),"Playerlist/"+wanjia.toUpperCase()+".yml"));
                }
                if(b.getString("name")==null){
                    return;
                }
                if(!b.getString("name").equals(wanjia)){
                    BukkitRunnable R = new BukkitRunnable() {
                        @Override
                        public void run() {
                            a.getPlayer().kickPlayer("你的名字是"+wanjia+"请使用"+b.getString("name")+"登入游戏");
                        }
                    };
                    R.runTask(main.getMian());
                    return;
                }
            }
        };
        T.start();
    }

    @EventHandler
    public void zccg(lobinboxsss a) {
        Thread T = new Thread() {
            @Override
            public void run() {
                String wanjia = a.getPlayer().getName();
                boolean b;
                File File;
                if (main.getPeizi().bc模式) {
                    b = (File = new File(main.getPeizi().工作路径, "Playerlist/" + wanjia.toUpperCase() + ".yml")).exists();
                } else {
                    b = (File = new File(main.getMian().getDataFolder(), "Playerlist/" + wanjia.toUpperCase() + ".yml")).exists();
                }
                if (b) {
                    return;
                }
                YamlConfiguration c = YamlConfiguration.loadConfiguration(File);
                c.set("name", wanjia);
                try {
                    c.save(File);
                } catch (IOException e) {
                    e.printStackTrace();
                    main.getMian().getLogger().warning("玩家列表保存失败");
                }
            }
        };
        T.start();
    }
}
