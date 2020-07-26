package cn.jji8.LoginBoxSss.kongziqi;

import cn.jji8.LoginBoxSss.duixiang.wanjia;
import cn.jji8.LoginBoxSss.isstatic.biao;
import cn.jji8.LoginBoxSss.isstatic.mimacaozuo;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/*
* 主要负责控制玩家的登入
* */
public class dengrukongziqi implements Listener {
    @EventHandler
    public void wanjianjingru(PlayerJoinEvent a){//玩家进入
        mimacaozuo.duqumima(biao.tianjia(a.getPlayer()));
    }
    @EventHandler
    public void wanjialikai(PlayerQuitEvent a) {//玩家离开时删掉，节约内存
        biao.shancu(a.getPlayer());
    }
    @EventHandler
    public void wanjiadianji(InventoryClickEvent a){//玩家点击时触发
        if(biao.ifwanjia(a.getWhoClicked().getName())){
            wanjia wanjia = biao.getwanjia(a.getWhoClicked().getName());
            wanjia.dianji(a.getRawSlot());
        }
    }
}
