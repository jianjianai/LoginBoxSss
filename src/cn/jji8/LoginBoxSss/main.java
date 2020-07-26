package cn.jji8.LoginBoxSss;

import cn.jji8.LoginBoxSss.kongziqi.dengrukongzhiqi;
import cn.jji8.LoginBoxSss.kongziqi.wanjiakongzhiqi;
import cn.jji8.LoginBoxSss.ml.qxcxzc;
import cn.jji8.LoginBoxSss.ml.xgmm;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
    static main mian;
    static peizi peizi;
    public static main getMian() {
        return mian;
    }
    public static peizi getPeizi() {
        return peizi;
    }

    public void onEnable(){
        Bukkit.getLogger().info("[箱子登入X]:正在载入...");
        mian = this;
        peizi = new peizi();
        //注册玩家控制器
        wanjiakongzhiqi wanjiakongzhiqi = new wanjiakongzhiqi();
        Bukkit.getPluginManager().registerEvents(wanjiakongzhiqi ,this);
        //注册登入控制器
        dengrukongzhiqi dengrukongzhiqi  = new dengrukongzhiqi();
        Bukkit.getPluginManager().registerEvents(dengrukongzhiqi,this);
        //注册命令
        Bukkit.getPluginCommand("修改密码").setExecutor(new xgmm());
        Bukkit.getPluginCommand("强制玩家重新注册").setExecutor(new qxcxzc());

        Bukkit.getLogger().info("[箱子登入X]:载入完成");
    }
}
