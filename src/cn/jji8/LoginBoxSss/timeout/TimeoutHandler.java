package cn.jji8.LoginBoxSss.timeout;

import cn.jji8.LoginBoxSss.login.PlayerListener;
import cn.jji8.LoginBoxSss.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class TimeoutHandler implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent a){
        BukkitRunnable BukkitRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                if(PlayerListener.loggedinPlayer.contains(a.getPlayer().getName())){
                    return;
                }
                a.getPlayer().kickPlayer(Main.getWrappedConfiguration().timeOutMessage);
            }
        };
        BukkitRunnable.runTaskLater(Main.getMain(), Main.getWrappedConfiguration().timeout * 20);
    }
}
