package cn.jji8.LoginBoxSss.login;


import cn.jji8.LoginBoxSss.login.util.WrappedPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;

import java.util.HashMap;

public class LoginListener implements Listener {//我是一个监听器,用来监听事件啦啦啦啦

    public static HashMap<String, WrappedPlayer> chestOpenedPlayer = new HashMap<>();

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){//玩家点击时触发
        if(chestOpenedPlayer.containsKey(event.getWhoClicked().getName())){
            event.setCancelled(true);
            WrappedPlayer wrappedPlayer = chestOpenedPlayer.get(event.getWhoClicked().getName());
            wrappedPlayer.onClick(event.getRawSlot());
        }
    }
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent a){//玩家离开时删掉，节约内存
        chestOpenedPlayer.remove(a.getPlayer().getName());
    }
    public static void setPlayerLoggedOut(Player player){
        if(chestOpenedPlayer.containsKey(player.getName())){
            chestOpenedPlayer.get(player.getName()).openChest();
            return;
        }
        chestOpenedPlayer.put(player.getName(),new WrappedPlayer(player));
    }
}
