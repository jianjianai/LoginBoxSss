package cn.jji8.LoginBoxSss.kongziqi;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.*;

import java.util.ArrayList;

public class wanjiakongzhiqi implements Listener {
    public static ArrayList biao = new ArrayList();
    @EventHandler
    public void WanJiaYiDong(PlayerMoveEvent dj){//玩家移动时
        if(biao.contains(dj.getPlayer().getName())){
            return;
        }
        dj.setCancelled(true);
        dengrukongzhiqi.shjian(dj.getPlayer());
    }

    @EventHandler
    public void WanJiaPoHuaiFangKuai(BlockBreakEvent dj){//玩家破坏方块
        if(biao.contains(dj.getPlayer().getName())){
            return;
        }
        dj.setCancelled(true);
        dengrukongzhiqi.shjian(dj.getPlayer());
    }
    @EventHandler
    public void WanJiaFangZhiFangKuai(BlockPlaceEvent dj){//玩家放置方块
        if(biao.contains(dj.getPlayer().getName())){
            return;
        }
        dj.setCancelled(true);
        dengrukongzhiqi.shjian(dj.getPlayer());
    }
    @EventHandler
    public void WanJianLiaoTian(AsyncPlayerChatEvent dj){//玩家聊天
        if(biao.contains(dj.getPlayer().getName())){
            return;
        }
        dj.setCancelled(true);
        dengrukongzhiqi.shjian(dj.getPlayer());
    }
    @EventHandler
    public void WanJiaMlingLi(PlayerCommandPreprocessEvent dj){//玩家命令
        if(biao.contains(dj.getPlayer().getName())){
            return;
        }
        dj.setCancelled(true);
        dengrukongzhiqi.shjian(dj.getPlayer());
    }
    @EventHandler
    public void WanJiaBeiDiYuMengChuanSong(PlayerPortalEvent dj){//玩家被地狱们传送
        if(biao.contains(dj.getPlayer().getName())){
            return;
        }
        dj.setCancelled(true);
        dengrukongzhiqi.shjian(dj.getPlayer());
    }
    @EventHandler
    public void WanJIaQieHuanFuSou(PlayerSwapHandItemsEvent dj){//玩家切换副手
        if(biao.contains(dj.getPlayer().getName())){
            return;
        }
        dj.setCancelled(true);
        dengrukongzhiqi.shjian(dj.getPlayer());
    }
    @EventHandler
    public void  WanJiaJiaoHu(PlayerInteractEvent dj){//玩家与空气方块交互时
        if(biao.contains(dj.getPlayer().getName())){
            return;
        }
        dj.setCancelled(true);
        dengrukongzhiqi.shjian(dj.getPlayer());
    }
    @EventHandler
    public void WanJIaDianJiShiTi(PlayerInteractEntityEvent dj){//玩家点击实体时
        if(biao.contains(dj.getPlayer().getName())){
            return;
        }
        dj.setCancelled(true);
        dengrukongzhiqi.shjian(dj.getPlayer());
    }
    @EventHandler
    public void wanjialikai(PlayerQuitEvent a){//玩家离开时删掉
        biao.remove(a.getPlayer().getName());
    }
}
