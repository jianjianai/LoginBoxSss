package cn.jji8.LoginBoxSss.login.util;

import cn.jji8.LoginBoxSss.login.controller.Controller;
import org.bukkit.entity.Player;

public class WrappedPlayer {
    private Player player;
    private Controller controller;
    private Password password;
    public WrappedPlayer(Player a){
        player = a;
        password = new Password(this);
        controller = password.duqumima(a.getName());
    }
    public WrappedPlayer(Player a, Controller b){
        controller = b;
        player = a;
        password = new Password(this);
        password.ziduqumima(a.getName());
    }
    public void onClick(int clickedSlot){
        controller.onClick(this, clickedSlot);
    }
    public void openChest(){
        controller.open(this);}

    public Player getPlayer() {
        return player;
    }

    public Password getPassword() {
        return password;
    }
}
