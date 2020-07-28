package cn.jji8.LoginBoxSss.login;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.*;

import java.util.ArrayList;

public class PlayerListener implements Listener {
    public static ArrayList<String> loggedinPlayer = new ArrayList<>();
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){//玩家移动时
        if(loggedinPlayer.contains(event.getPlayer().getName())){
            return;
        }
        event.setCancelled(true);
        LoginListener.setPlayerLoggedOut(event.getPlayer());
    }

    @EventHandler
    public void onPlayerBreakBlock(BlockBreakEvent event){//玩家破坏方块
        if(loggedinPlayer.contains(event.getPlayer().getName())){
            return;
        }
        event.setCancelled(true);
        LoginListener.setPlayerLoggedOut(event.getPlayer());
    }
    @EventHandler
    public void onPlayerPlaceBlock(BlockPlaceEvent event){//玩家放置方块
        if(loggedinPlayer.contains(event.getPlayer().getName())){
            return;
        }
        event.setCancelled(true);
        LoginListener.setPlayerLoggedOut(event.getPlayer());
    }
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event){//玩家聊天
        if(loggedinPlayer.contains(event.getPlayer().getName())){
            return;
        }
        event.setCancelled(true);
        LoginListener.setPlayerLoggedOut(event.getPlayer());
    }
    @EventHandler
    public void onPlayerExecuteCommand(PlayerCommandPreprocessEvent event){//玩家命令
        if(loggedinPlayer.contains(event.getPlayer().getName())){
            return;
        }
        event.setCancelled(true);
        LoginListener.setPlayerLoggedOut(event.getPlayer());
    }
    @EventHandler
    public void onPlayerPortal(PlayerPortalEvent event){//玩家被地狱们传送
        if(loggedinPlayer.contains(event.getPlayer().getName())){
            return;
        }
        event.setCancelled(true);
        LoginListener.setPlayerLoggedOut(event.getPlayer());
    }
    @EventHandler
    public void onPlayerSwapHandItem(PlayerSwapHandItemsEvent event){//玩家切换副手
        if(loggedinPlayer.contains(event.getPlayer().getName())){
            return;
        }
        event.setCancelled(true);
        LoginListener.setPlayerLoggedOut(event.getPlayer());
    }
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){//玩家与空气方块交互时
        if(loggedinPlayer.contains(event.getPlayer().getName())){
            return;
        }
        event.setCancelled(true);
        LoginListener.setPlayerLoggedOut(event.getPlayer());
    }
    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event){//玩家点击实体时
        if(loggedinPlayer.contains(event.getPlayer().getName())){
            return;
        }
        event.setCancelled(true);
        LoginListener.setPlayerLoggedOut(event.getPlayer());
    }
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){//玩家离开时删掉
        loggedinPlayer.remove(event.getPlayer().getName());
    }
}
