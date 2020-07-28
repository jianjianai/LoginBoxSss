package cn.jji8.LoginBoxSss.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerRegisterSuccessEvent extends Event implements Cancellable {//注册成功
    private static final HandlerList handlers = new HandlerList();
    boolean isCancelled = false;
    Player Player;
    public PlayerRegisterSuccessEvent(Player a){
        Player = a;
    }

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
