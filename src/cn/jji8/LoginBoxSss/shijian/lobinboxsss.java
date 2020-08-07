package cn.jji8.LoginBoxSss.shijian;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class lobinboxsss extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    boolean isCancelled = false;
    Player Player;
    public Player getPlayer(){//获取登入成功的玩家
        return Player;
    }
    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        isCancelled = b;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList(){
        return handlers;
    }
}
