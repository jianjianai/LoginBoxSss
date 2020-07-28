package cn.jji8.LoginBoxSss.login.controller;

import cn.jji8.LoginBoxSss.login.controller.chest.LoginChest;
import cn.jji8.LoginBoxSss.login.util.WrappedPlayer;
import cn.jji8.LoginBoxSss.login.LoginManager;
import cn.jji8.LoginBoxSss.Main;
import cn.jji8.LoginBoxSss.event.PlayerRegisterSuccessEvent;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Register implements Controller {
    LoginChest LoginChest;
    boolean duplicated = false;
    String pasasword;
    public Register(Player player){
        if(Main.getWrappedConfiguration().spectatorBeforeLogin){
            player.setGameMode(GameMode.SPECTATOR);
        }
        LoginChest = new LoginChest(player.getName());
        LoginChest.createInventory(Main.getWrappedConfiguration().registerMessage);
        LoginChest.openForPlayer(player);
    }
    @Override
    public void onClick(WrappedPlayer wrappedPlayer, int clickedSlot) {
        if(clickedSlot>=0&clickedSlot<=35){
            wrappedPlayer.getPassword().doInput(clickedSlot);
            LoginChest.displayPassword(wrappedPlayer.getPassword());
        }else if(clickedSlot==36){
            if(Main.getWrappedConfiguration().playSound){
                wrappedPlayer.getPlayer().playSound(wrappedPlayer.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL,30,2);
            }
            wrappedPlayer.getPassword().chongzimima();
            LoginChest.createInventory(Main.getWrappedConfiguration().registerMessage);
            LoginChest.displayPassword(wrappedPlayer.getPassword());
            LoginChest.openForPlayer(wrappedPlayer.getPlayer());
            duplicated = false;
        }else if(clickedSlot==44){
            if(Main.getWrappedConfiguration().playSound){
                wrappedPlayer.getPlayer().playSound(wrappedPlayer.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL,30,2);
            }
            if(!duplicated){
                pasasword = wrappedPlayer.getPassword().toString();
                wrappedPlayer.getPassword().chongzimima();
                LoginChest.createInventory(Main.getWrappedConfiguration().repeatMessage);
                LoginChest.displayPassword(wrappedPlayer.getPassword());
                LoginChest.openForPlayer(wrappedPlayer.getPlayer());
                duplicated = true;
            }else {
                if(pasasword.equals(wrappedPlayer.getPassword().toString())){
                    PlayerRegisterSuccessEvent PlayerRegisterSuccessEvent = new PlayerRegisterSuccessEvent(wrappedPlayer.getPlayer());//处理事件
                    Bukkit.getServer().getPluginManager().callEvent(PlayerRegisterSuccessEvent);
                    if(PlayerRegisterSuccessEvent.isCancelled()) {
                        return; //事件被取消, 终止事件的处理
                    }

                    wrappedPlayer.getPlayer().closeInventory();
                    LoginManager.setPlayerLoggedIn(wrappedPlayer.getPlayer().getName());
                    wrappedPlayer.getPlayer().sendTitle(Main.getWrappedConfiguration().registerSuccess1.replaceAll("%玩家%", wrappedPlayer.getPlayer().getName()), Main.getWrappedConfiguration().registerSuccess2.replaceAll("%玩家%", wrappedPlayer.getPlayer().getName()),10,40,10);
                    if(Main.getWrappedConfiguration().spectatorBeforeLogin){
                        wrappedPlayer.getPlayer().setGameMode(Main.getWrappedConfiguration().serverGameMode);
                    }
                    Bukkit.getScheduler().runTaskAsynchronously(Main.getMain(), () -> {
                        System.out.println("[箱子登入]:异步保存玩家密码中..");
                        wrappedPlayer.getPassword().baocunmima(wrappedPlayer.getPlayer().getName());
                        System.out.println("[箱子登入]:保存完成..");
                    });
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), Main.getWrappedConfiguration().commandAfterRegisteration.replaceAll("%玩家%", wrappedPlayer.getPlayer().getName()));
                }else {
                    wrappedPlayer.getPassword().chongzimima();
                    LoginChest.createInventory(Main.getWrappedConfiguration().notSamePassword);
                    LoginChest.displayPassword(wrappedPlayer.getPassword());
                    LoginChest.openForPlayer(wrappedPlayer.getPlayer());
                }
            }
        }
    }
    @Override
    public void open(WrappedPlayer a) {
        LoginChest.openForPlayer(a.getPlayer());
    }
}
