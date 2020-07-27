package cn.jji8.LoginBoxSss.chaoshiguanli;

import cn.jji8.LoginBoxSss.kongziqi.wanjiakongzhiqi;
import cn.jji8.LoginBoxSss.main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class chaoshiguanli implements Listener {
    @EventHandler
    public void wanjianjingru(PlayerJoinEvent a){
        BukkitRunnable BukkitRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                if(wanjiakongzhiqi.biao.contains(a.getPlayer().getName())){
                    return;
                }
                a.getPlayer().kickPlayer(main.getPeizi().登入超时踢出玩家提示消息);
            }
        };
        BukkitRunnable.runTaskLater(main.getMian(),main.getPeizi().登入超时时间*20);
    }
}
