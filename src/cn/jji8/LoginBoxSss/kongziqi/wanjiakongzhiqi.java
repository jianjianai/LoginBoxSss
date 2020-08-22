package cn.jji8.LoginBoxSss.kongziqi;

import cn.jji8.LoginBoxSss.main;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class wanjiakongzhiqi implements Listener {
    public static ArrayList<String> biao = new ArrayList<String>();
    @EventHandler
    public void wanjia(PlayerMoveEvent dj){//玩家移动时
        panduandengru(dj, dj.getPlayer());
    }
    @EventHandler
    public void wanjia(BlockBreakEvent dj){//玩家破坏方块
        panduandengru(dj, dj.getPlayer());
    }
    @EventHandler
    public void wanjia(BlockPlaceEvent dj){//玩家放置方块
        panduandengru(dj, dj.getPlayer());
    }
    @EventHandler
    public void wanjia(AsyncPlayerChatEvent dj){//玩家聊天
        panduandengru(dj, dj.getPlayer());
    }
    @EventHandler
    public void wanjia(PlayerCommandPreprocessEvent dj){//玩家命令
        panduandengru(dj, dj.getPlayer());
    }
    @EventHandler
    public void wanjia(PlayerPortalEvent dj){//玩家被地狱们传送
        panduandengru(dj, dj.getPlayer());
    }
    @EventHandler
    public void wanjia(PlayerSwapHandItemsEvent dj){//玩家切换副手
        panduandengru(dj, dj.getPlayer());
    }
    @EventHandler
    public void  wanjia(PlayerInteractEvent dj) {//玩家与空气方块交互时
        panduandengru(dj, dj.getPlayer());
    }
    @EventHandler
    public void wanjia(PlayerInteractEntityEvent dj){//玩家点击实体时
        panduandengru(dj, dj.getPlayer());
    }
    @EventHandler
    public void wanjia(PlayerTeleportEvent dj){//玩家传送事件
        panduandengru(dj, dj.getPlayer());
    }
    @EventHandler
    public void wanjia(PlayerDropItemEvent dj){//玩家丢弃物品时
        panduandengru(dj, dj.getPlayer());
    }
    @EventHandler
    public void wanjia(InventoryClickEvent dj){//玩家点击
        if(biao.contains(dj.getWhoClicked().getName())){
            return;
        }
        dengrukongzhiqi.wanjiadianji(dj);
    }
    /**
     * 用于判断玩家是否登入，未当然则取消事件
     * */
    public void panduandengru(Cancellable dj,Player wanjia){
        if(biao.contains(wanjia.getName())){
            return;
        }
        dj.setCancelled(true);
        dengrukongzhiqi.shjian(wanjia);
    }
    @EventHandler
    public void wanjia(PlayerJoinEvent dj){//玩家进入服务器事件.
        BukkitRunnable BukkitRunnable = new BukkitRunnable(){
            @Override
            public void run() {
                dengrukongzhiqi.shjian(dj.getPlayer());
            }
        };
        BukkitRunnable.runTask(main.getMian());
    }
    @EventHandler
    public void wanjialikai(PlayerQuitEvent a){//玩家离开时删掉
        dengrukongzhiqi.wanjialikai(a);
        biao.remove(a.getPlayer().getName());
    }
}
