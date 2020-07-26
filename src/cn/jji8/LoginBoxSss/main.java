package cn.jji8.LoginBoxSss;

import cn.jji8.LoginBoxSss.isstatic.peizi;
import cn.jji8.LoginBoxSss.kongziqi.dengrukongziqi;
import cn.jji8.LoginBoxSss.kongziqi.wanjiakongziqi;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
    static main mian;
    public static main getMian() {
        return mian;
    }

    public void onEnable(){
        mian = this;
        //加加载配置
        peizi.jiazai();
        //注册玩家控制器
        wanjiakongziqi wanjiakongziqi = new wanjiakongziqi();
        Bukkit.getPluginManager().registerEvents(wanjiakongziqi,this);
        //注册登入控制器
        dengrukongziqi dengrukongziqi = new dengrukongziqi();
        Bukkit.getPluginManager().registerEvents(dengrukongziqi,this);
    }
}
