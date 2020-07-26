package cn.jji8.LoginBoxSss.kongziqi;


import cn.jji8.LoginBoxSss.isstatic.biao;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.*;

/*
* 主要负责控制玩家的行为
* */
public class wanjiakongziqi implements Listener {
    @EventHandler
    public void WanJiaPoHuaiFangKuai(BlockBreakEvent dj){//玩家破坏方块
        if(biao.ifwanjia(dj.getPlayer())){
            dj.setCancelled(true);
        }
    }
    @EventHandler
    public void WanJiaFangZhiFangKuai(BlockPlaceEvent dj){//玩家放置方块
        if(biao.ifwanjia(dj.getPlayer())){
            dj.setCancelled(true);
        }
    }
    @EventHandler
    public void WanJianLiaoTian(AsyncPlayerChatEvent dj){//玩家聊天
        if(biao.ifwanjia(dj.getPlayer())){
            dj.setCancelled(true);
        }
    }
    @EventHandler
    public void WanJiaMlingLi(PlayerCommandPreprocessEvent dj){//玩家命令
        if(biao.ifwanjia(dj.getPlayer())){
            dj.setCancelled(true);
        }
    }
    @EventHandler
    public void WanJiaDiuWuPing(PlayerDropItemEvent dj){//玩家丢物品
        if(biao.ifwanjia(dj.getPlayer())){
            dj.setCancelled(true);
        }
    }
    @EventHandler
    public void WanJiaBeiDiYuMengChuanSong(PlayerPortalEvent dj){//玩家被地狱们传送
        if(biao.ifwanjia(dj.getPlayer())){
            dj.setCancelled(true);
        }
    }
    @EventHandler
    public void WanJiaChuanSong(PlayerTeleportEvent dj){//玩家传送
        if(biao.ifwanjia(dj.getPlayer())){
            dj.setCancelled(true);
        }
    }
    @EventHandler
    public void WanJIaQieHuanFuSou(PlayerSwapHandItemsEvent dj){//玩家切换副手
        if(biao.ifwanjia(dj.getPlayer())){
            dj.setCancelled(true);
        }
    }
    @EventHandler
    public void WanJIaDianJiShiTi(PlayerInteractEntityEvent dj){//玩家点击实体时
        if(biao.ifwanjia(dj.getPlayer())){
            dj.setCancelled(true);
        }
    }
}
