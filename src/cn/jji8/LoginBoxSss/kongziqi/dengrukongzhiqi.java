package cn.jji8.LoginBoxSss.kongziqi;


import cn.jji8.LoginBoxSss.kongziqi.duixiang.wanjia;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;

import java.util.HashMap;

public class dengrukongzhiqi implements Listener {//我是一个监听器,用来监听事件啦啦啦啦

    HashMap<String, wanjia> biao = new HashMap<String, wanjia>();

    @EventHandler
    public void wanjiadianji(InventoryClickEvent a){//玩家点击时触发
        if(biao.containsKey(a.getWhoClicked().getName())){
            a.setCancelled(true);
            wanjia wanjia = biao.get(a.getWhoClicked().getName());
            wanjia.dianji(a.getRawSlot());
        }
    }




    @EventHandler
    public void wanjianjingru(PlayerJoinEvent dj){//玩家进入时创建一个wanjia对象
        if(biao.containsKey(dj.getPlayer().getName())){
            biao.put(dj.getPlayer().getName(),new wanjia(dj.getPlayer()));
        }
    }

    @EventHandler
    public void wanjialikai(PlayerQuitEvent a){//玩家离开时删掉，节约内存
        biao.remove(a.getPlayer().getName());
    }






    @EventHandler
    public void WanJiaYiDong(PlayerMoveEvent dj){//玩家移动时
        if(biao.containsKey(dj.getPlayer().getName())){
            dj.setCancelled(true);
        }
    }

    @EventHandler
    public void WanJiaPoHuaiFangKuai(BlockBreakEvent dj){//玩家破坏方块
        if(biao.containsKey(dj.getPlayer().getName())){
            dj.setCancelled(true);
        }
    }
    @EventHandler
    public void WanJiaFangZhiFangKuai(BlockPlaceEvent dj){//玩家放置方块
        if(biao.containsKey(dj.getPlayer().getName())){
            dj.setCancelled(true);
        }
    }

  //下方是没用的，限制没登入玩家的
    @EventHandler
    public void WanJianLiaoTian(AsyncPlayerChatEvent dj){//玩家聊天
        if(biao.containsKey(dj.getPlayer().getName())){
            dj.setCancelled(true);
        }
    }
    @EventHandler
    public void WanJiaMlingLi(PlayerCommandPreprocessEvent dj){//玩家命令
        if(biao.containsKey(dj.getPlayer().getName())){
            dj.setCancelled(true);
        }
    }
    @EventHandler
    public void WanJiaBeiDiYuMengChuanSong(PlayerPortalEvent dj){//玩家被地狱们传送
        if(biao.containsKey(dj.getPlayer().getName())){
            dj.setCancelled(true);
        }
    }
    @EventHandler
    public void WanJiaChuanSong(PlayerTeleportEvent dj){//玩家传送
        if(biao.containsKey(dj.getPlayer().getName())){
            dj.setCancelled(true);
        }
    }
    @EventHandler
    public void WanJIaQieHuanFuSou(PlayerSwapHandItemsEvent dj){//玩家切换副手
        if(biao.containsKey(dj.getPlayer().getName())){
            dj.setCancelled(true);
        }
    }
    @EventHandler
    public void  WanJiaJiaoHu(PlayerInteractEvent dj){//玩家与空气方块交互时
        if(biao.containsKey(dj.getPlayer().getName())){
            dj.setCancelled(true);
        }
    }
    @EventHandler
    public void WanJIaDianJiShiTi(PlayerInteractEntityEvent dj){//玩家点击实体时
        if(biao.containsKey(dj.getPlayer().getName())){
            dj.setCancelled(true);
        }
    }
}
