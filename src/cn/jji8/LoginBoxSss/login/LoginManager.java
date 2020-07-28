package cn.jji8.LoginBoxSss.login;

import cn.jji8.LoginBoxSss.login.util.WrappedPlayer;
import org.bukkit.entity.Player;

public class LoginManager {
    public static void setPlayerLoggedIn(String name){
        PlayerListener.loggedinPlayer.add(name);
        LoginListener.chestOpenedPlayer.remove(name);
    }
    public static void setPlayerLoggedOut(Player player){
        PlayerListener.loggedinPlayer.remove(player.getName());
        LoginListener.setPlayerLoggedOut(player);
    }
    public static void openChestForPlayer(WrappedPlayer wrappedPlayer){
        LoginListener.chestOpenedPlayer.put(wrappedPlayer.getPlayer().getName(), wrappedPlayer);
        PlayerListener.loggedinPlayer.remove(wrappedPlayer.getPlayer().getName());
    }
}
