package cn.jji8.LoginBoxSss.BC;

import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import net.md_5.bungee.event.EventHandler;

import java.io.File;
import java.io.IOException;


public class main extends Plugin implements Listener {
    public static main main;
    public static peizhi peizhi;
    @Override
    public void onEnable() {
        main = this;
        getLogger().info("[箱子登入X]:启动！");
        peizhi = new peizhi();
        getProxy().getPluginManager().registerListener(this,this);
    }



    @EventHandler
    public void onPostLogin(PostLoginEvent event) {
        if(peizhi.后台更多信息){System.out.println("[箱子登入X]:玩家"+event.getPlayer().getName()+"连接BC，准备连接到子服务器服务器");}
        File File = new File(peizhi.工作路径+"/登入状态", event.getPlayer().getName()+".yml");
        Configuration wanjiawenjian;
        try {
            wanjiawenjian = ConfigurationProvider.getProvider(YamlConfiguration.class).load(File);
        } catch (IOException e) {
            if(peizhi.后台更多信息){System.out.println("[箱子登入X]:没有找到"+peizhi.工作路径+"/登入状态/"+event.getPlayer().getName()+".yml文件，他一定是个新玩家吧！");}
            return;
        }
        if(wanjiawenjian.getBoolean("已登入")){
            wanjiawenjian.set("已登入",false);
            try {
                ConfigurationProvider.getProvider(YamlConfiguration.class).save(wanjiawenjian,File);
            } catch (IOException e) {
                e.printStackTrace();
                getLogger().warning("[箱子登入X]:设置玩家已登入状态为false失败，这样会导致玩家不需要登入,请检查文件读写权限或磁盘空间。");
            }
        }
        if(peizhi.后台更多信息){
            System.out.println("[箱子登入X]:已将玩家"+event.getPlayer().getName()+"的登入状态设为false");
            System.out.println("[箱子登入X]:为玩家"+event.getPlayer().getName()+"连接子服务器");
        }
    }
}
