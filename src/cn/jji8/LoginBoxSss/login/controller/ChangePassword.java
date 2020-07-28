package cn.jji8.LoginBoxSss.login.controller;

import cn.jji8.LoginBoxSss.login.controller.chest.LoginChest;
import cn.jji8.LoginBoxSss.login.util.WrappedPlayer;
import cn.jji8.LoginBoxSss.login.LoginManager;
import cn.jji8.LoginBoxSss.Main;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class ChangePassword implements Controller {
    LoginChest LoginChest;
    boolean duplicated = false;
    boolean change = false;
    String password;
    boolean closed = false;
    public ChangePassword(Player a){
        if(Main.getWrappedConfiguration().spectatorBeforeLogin){
            a.getPlayer().setGameMode(GameMode.SPECTATOR);
        }
        LoginChest = new LoginChest(a.getName());
        LoginChest.createInventory(Main.getWrappedConfiguration().changePasswordTitle);
        LoginChest.openForPlayer(a);

        Thread T = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            closed = true;
        });
        T.start();
    }
    @Override
    public void onClick(WrappedPlayer wrappedPlayer, int dianjiweizi) {
        if(dianjiweizi>=0&dianjiweizi<=35){
            wrappedPlayer.getPassword().doInput(dianjiweizi);
            LoginChest.displayPassword(wrappedPlayer.getPassword());
        }else if(dianjiweizi==36){
            if(Main.getWrappedConfiguration().playSound){
                wrappedPlayer.getPlayer().playSound(wrappedPlayer.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL,30,2);
            }
            if(change){
                wrappedPlayer.getPassword().chongzimima();
                LoginChest.createInventory(Main.getWrappedConfiguration().changePasswordMessage);
                LoginChest.displayPassword(wrappedPlayer.getPassword());
                LoginChest.openForPlayer(wrappedPlayer.getPlayer());
                duplicated = false;
            }else {
                wrappedPlayer.getPassword().chongzimima();
                LoginChest.createInventory(Main.getWrappedConfiguration().changePasswordTitle);
                LoginChest.displayPassword(wrappedPlayer.getPassword());
                LoginChest.openForPlayer(wrappedPlayer.getPlayer());
            }
        }else if(dianjiweizi==44){
            if(Main.getWrappedConfiguration().playSound){
                wrappedPlayer.getPlayer().playSound(wrappedPlayer.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL,30,2);
            }
            if(change){
                if(!duplicated){
                    password = wrappedPlayer.getPassword().toString();
                    wrappedPlayer.getPassword().chongzimima();
                    LoginChest.createInventory(Main.getWrappedConfiguration().repeatMessage);
                    LoginChest.displayPassword(wrappedPlayer.getPassword());
                    LoginChest.openForPlayer(wrappedPlayer.getPlayer());
                    duplicated = true;
                }else {
                    if(password.equals(wrappedPlayer.getPassword().toString())){
                        wrappedPlayer.getPassword().baocunmima(wrappedPlayer.getPlayer().getName());
                        wrappedPlayer.getPlayer().closeInventory();
                        LoginManager.setPlayerLoggedIn(wrappedPlayer.getPlayer().getName());
                        wrappedPlayer.getPlayer().sendTitle(Main.getWrappedConfiguration().passwordChangeSuccessfully1.replaceAll("%玩家%", wrappedPlayer.getPlayer().getName()), Main.getWrappedConfiguration().passwordChangeSuccessfully2.replaceAll("%玩家%", wrappedPlayer.getPlayer().getName()),10,40,10);
                        if(Main.getWrappedConfiguration().spectatorBeforeLogin){
                            wrappedPlayer.getPlayer().setGameMode(Main.getWrappedConfiguration().serverGameMode);
                        }
                    }else {
                        wrappedPlayer.getPassword().chongzimima();
                        LoginChest.createInventory(Main.getWrappedConfiguration().notSamePassword);
                        LoginChest.displayPassword(wrappedPlayer.getPassword());
                        LoginChest.openForPlayer(wrappedPlayer.getPlayer());
                    }
                }
            }else if(wrappedPlayer.getPassword().bijiaomima()){
                wrappedPlayer.getPassword().chongzimima();
                LoginChest.createInventory(Main.getWrappedConfiguration().changePasswordMessage);
                LoginChest.displayPassword(wrappedPlayer.getPassword());
                LoginChest.openForPlayer(wrappedPlayer.getPlayer());
                change = true;
            }else {
                LoginChest.createInventory(Main.getWrappedConfiguration().wrongPassword);
                LoginChest.displayPassword(wrappedPlayer.getPassword());
                LoginChest.openForPlayer(wrappedPlayer.getPlayer());
            }


        }
    }
    @Override
    public void open(WrappedPlayer a) {
        if(closed){
            a.getPlayer().closeInventory();
            LoginManager.setPlayerLoggedIn(a.getPlayer().getName());
            a.getPlayer().sendTitle(Main.getWrappedConfiguration().cancelPasswordChanging1.replaceAll("%玩家%",a.getPlayer().getName()), Main.getWrappedConfiguration().cancelPasswordChanging2.replaceAll("%玩家%",a.getPlayer().getName()),10,40,10);
            if(Main.getWrappedConfiguration().spectatorBeforeLogin){
                a.getPlayer().setGameMode(Main.getWrappedConfiguration().serverGameMode);
            }
        }
    }
}
