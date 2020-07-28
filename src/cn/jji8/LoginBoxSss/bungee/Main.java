package cn.jji8.LoginBoxSss.bungee;

import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import net.md_5.bungee.event.EventHandler;

import java.io.File;
import java.io.IOException;


public class Main extends Plugin implements Listener {
    public static Main main;
    public static WrappedConfiguration WrappedConfiguration;
    @Override
    public void onEnable() {
        main = this;
        getLogger().info("启动！");
        WrappedConfiguration = new WrappedConfiguration();
        getProxy().getPluginManager().registerListener(this,this);
    }



    @EventHandler
    public void onPostLogin(PostLoginEvent event) {
        if(WrappedConfiguration.verbose){System.out.println("玩家"+event.getPlayer().getName()+"连接BC，准备连接到子服务器服务器");}
        File File = new File(WrappedConfiguration.workdir +"/登入状态", event.getPlayer().getName()+".yml");
        Configuration playerFile;
        try {
            playerFile = ConfigurationProvider.getProvider(YamlConfiguration.class).load(File);
        } catch (IOException e) {
            if(WrappedConfiguration.verbose){System.out.println("没有找到"+ WrappedConfiguration.workdir +"/登入状态/"+event.getPlayer().getName()+".yml文件，他一定是个新玩家吧！");}
            return;
        }
        if(playerFile.getBoolean("已登入")){
            playerFile.set("已登入",false);
            try {
                ConfigurationProvider.getProvider(YamlConfiguration.class).save(playerFile,File);
            } catch (IOException e) {
                e.printStackTrace();
                getLogger().warning("设置玩家已登入状态为false失败，这样会导致玩家不需要登入,请检查文件读写权限或磁盘空间。");
            }
        }
        if(WrappedConfiguration.verbose){
            System.out.println("已将玩家"+event.getPlayer().getName()+"的登入状态设为false");
            System.out.println("为玩家"+event.getPlayer().getName()+"连接子服务器");
        }
    }
}
