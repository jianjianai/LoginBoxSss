package cn.jji8.LoginBoxSss;

import cn.jji8.LoginBoxSss.kongziqi.dengrukongzhiqi;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
    static main mian;
    static peizi peizi;
    public static main getMian() {
        return mian;
    }

    public void onEnable(){
        mian = this;
        peizi = new peizi();
        //注册玩家控制器
        System.out.println("登入控制器注册");
        dengrukongzhiqi dengrukongzhiqi  = new dengrukongzhiqi ();
        Bukkit.getPluginManager().registerEvents(dengrukongzhiqi,this);
    }
}
