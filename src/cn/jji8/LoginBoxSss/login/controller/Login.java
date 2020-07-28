package cn.jji8.LoginBoxSss.login.controller;

import cn.jji8.LoginBoxSss.login.controller.chest.LoginChest;
import cn.jji8.LoginBoxSss.login.util.WrappedPlayer;
import cn.jji8.LoginBoxSss.login.LoginManager;
import cn.jji8.LoginBoxSss.Main;
import cn.jji8.LoginBoxSss.event.LoginSuccessEvent;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Login implements Controller {
    LoginChest loginChest;
    public Login(Player a){
        if(Main.getWrappedConfiguration().spectatorBeforeLogin){
            a.getPlayer().setGameMode(GameMode.SPECTATOR);
        }
        loginChest = new LoginChest(a.getName());
        loginChest.createInventory(Main.getWrappedConfiguration().loginMessage);
        loginChest.openForPlayer(a);
    }
    @Override
    public void onClick(WrappedPlayer wrappedPlayer, int slotClicked) {
        if(slotClicked>=0&slotClicked<=35){
            wrappedPlayer.getPassword().doInput(slotClicked);
            loginChest.displayPassword(wrappedPlayer.getPassword());
        }else if(slotClicked==36){
            if(Main.getWrappedConfiguration().playSound){
                wrappedPlayer.getPlayer().playSound(wrappedPlayer.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL,30,2);
            }
            wrappedPlayer.getPassword().chongzimima();
            loginChest.createInventory(Main.getWrappedConfiguration().loginMessage);
            loginChest.displayPassword(wrappedPlayer.getPassword());
            loginChest.openForPlayer(wrappedPlayer.getPlayer());
        }else if(slotClicked==44){
            if(Main.getWrappedConfiguration().playSound){
                wrappedPlayer.getPlayer().playSound(wrappedPlayer.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL,30,2);
            }
            if(wrappedPlayer.getPassword().bijiaomima()){
                LoginSuccessEvent LoginSuccessEvent = new LoginSuccessEvent(wrappedPlayer.getPlayer());//处理事件
                Bukkit.getServer().getPluginManager().callEvent(LoginSuccessEvent);
                if(LoginSuccessEvent.isCancelled()) {
                    return; //事件被取消, 终止事件的处理
                }
                wrappedPlayer.getPlayer().closeInventory();
                LoginManager.setPlayerLoggedIn(wrappedPlayer.getPlayer().getName());
                wrappedPlayer.getPlayer().sendTitle(Main.getWrappedConfiguration().loginSuccess1.replaceAll("%玩家%",wrappedPlayer.getPlayer().getName()), Main.getWrappedConfiguration().loginSuccess2.replaceAll("%玩家%",wrappedPlayer.getPlayer().getName()),10,40,10);
                if(Main.getWrappedConfiguration().spectatorBeforeLogin){
                    wrappedPlayer.getPlayer().setGameMode(Main.getWrappedConfiguration().serverGameMode);
                }
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), Main.getWrappedConfiguration().commandAfterLogin.replaceAll("%玩家%",wrappedPlayer.getPlayer().getName()));
            }else {
                loginChest.createInventory(Main.getWrappedConfiguration().wrongPassword);
                loginChest.displayPassword(wrappedPlayer.getPassword());
                loginChest.openForPlayer(wrappedPlayer.getPlayer());
            }
        }
    }

    @Override
    public void open(WrappedPlayer a) {
        loginChest.openForPlayer(a.getPlayer());
    }
}
