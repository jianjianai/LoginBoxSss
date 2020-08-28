package cn.jji8.LoginBoxSss;

import cn.jji8.LoginBoxSss.chaoshiguanli.chaoshiguanli;
import cn.jji8.LoginBoxSss.ip.ipxianzi;
import cn.jji8.LoginBoxSss.kongziqi.BCmoshi;
import cn.jji8.LoginBoxSss.kongziqi.dengrukongzhiqi;
import cn.jji8.LoginBoxSss.kongziqi.mingzixianzhi;
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
    Metrics Metrics;

    public void onEnable(){
        Bukkit.getLogger().info("[箱子登入X]:正在载入...");
        mian = this;
        peizi = new peizi();
        Metrics = new Metrics(this,8678);
        //注册玩家控制器
        wanjiakongzhiqi wanjiakongzhiqi = new wanjiakongzhiqi();
        Bukkit.getPluginManager().registerEvents(wanjiakongzhiqi ,this);
        //注册命令
        Bukkit.getPluginCommand("xgmm").setExecutor(new xgmm());
        Bukkit.getPluginCommand("qzwjcxzc").setExecutor(new qxcxzc());
        //超时管理
        if(peizi.登入超时踢出玩家){
            chaoshiguanli chaoshiguanli = new chaoshiguanli();
            Bukkit.getPluginManager().registerEvents(chaoshiguanli,this);
        }
        //ip限制
        if(peizi.ip管理器){
            ipxianzi ipxianzi = new ipxianzi();
            Bukkit.getPluginManager().registerEvents(ipxianzi,this);
        }
        //ip限制
        if(peizi.bc模式){
            Bukkit.getLogger().info("[箱子登入X]:BC模式开启，工作路径是："+peizi.工作路径);
            BCmoshi BCmoshi = new BCmoshi();
            Bukkit.getPluginManager().registerEvents(BCmoshi,this);
        }
        //名字限制
       if(peizi.名字限制){
            mingzixianzhi mingzixianzhi = new mingzixianzhi();
            Bukkit.getPluginManager().registerEvents(mingzixianzhi,this);
       }
        Bukkit.getLogger().info("[箱子登入X]:载入完成");
    }
}
