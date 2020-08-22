package cn.jji8.LoginBoxSss.kongziqi;


import cn.jji8.LoginBoxSss.kongziqi.duixiang.wanjia;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;

import java.util.HashMap;

public class dengrukongzhiqi{//我是一个监听器,用来监听事件啦啦啦啦

    public static HashMap<String, wanjia> biao = new HashMap<String, wanjia>();

    public static void wanjiadianji(InventoryClickEvent a){//玩家点击时触发
        if(biao.containsKey(a.getWhoClicked().getName())){
            a.setCancelled(true);
            wanjia wanjia = biao.get(a.getWhoClicked().getName());
            wanjia.dianji(a.getRawSlot());
        }
    }

    public static void wanjialikai(PlayerQuitEvent a){//玩家离开时删掉，节约内存
        biao.remove(a.getPlayer().getName());
    }

    public static void shjian(Player wanjia){
        if(biao.containsKey(wanjia.getName())){
            biao.get(wanjia.getName()).dakai();
            return;
        }
        biao.put(wanjia.getName(),new wanjia(wanjia.getPlayer()));
    }
}
