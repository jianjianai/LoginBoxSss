package cn.jji8.LoginBoxSss.ip;

import cn.jji8.LoginBoxSss.main;
import cn.jji8.LoginBoxSss.shijian.drcg;
import cn.jji8.LoginBoxSss.shijian.zccg;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.bukkit.Bukkit.broadcastMessage;

public class ipxianzi implements Listener {

    int 单个ip最大进入玩家数量,单个ip最大注册玩家数量;
    String 玩家进入时广播消息,玩家登入成功时广播消息,玩家离开服务器时广播消息,超过ip限制被踢时显示消息,超过单个ip最大注册玩家数量显示消息,超过单个ip最大注册玩家数量显示消息1;

    File 玩家ip;
    FileConfiguration ip管理配置;
    FileConfiguration 玩家ip配置;
    Player wj;
    ipdengruwanjia ip = new ipdengruwanjia();



    public ipxianzi(){
        System.out.println("[箱子登入：ip管理]§a开始加载配置文件");
        main.getMian().saveResource("ipguanli.yml",false);
        玩家ip = new File(main.getMian().getDataFolder(),"ip/ipguanli.yml");
        ip管理配置 = YamlConfiguration.loadConfiguration(new File(main.getMian().getDataFolder(),"ipguanli.yml"));
        玩家ip配置 = YamlConfiguration.loadConfiguration(玩家ip);
        try {
            玩家进入时广播消息 = ip管理配置.getString("玩家进入时广播消息");
        }catch (Throwable ssss){
            System.out.println("[箱子登入：ip管理]§c玩家进入时广播消息配置文件错误，请检查配置文件");
        }
        try {
            玩家登入成功时广播消息 = ip管理配置.getString("玩家登入成功时广播消息");
        }catch (Throwable ssss){
            System.out.println("[箱子登入：ip管理]§c玩家登入成功时广播消息配置文件错误，请检查配置文件");
        }
        try {
            单个ip最大进入玩家数量 = ip管理配置.getInt("单个ip最大进入玩家数量");
        }catch (Throwable ssss){
            System.out.println("[箱子登入：ip管理]§c单个ip最大进入玩家数量配置文件错误，请检查配置文件");
        }
        try {
            单个ip最大注册玩家数量 = ip管理配置.getInt("单个ip最大注册玩家数量");
        }catch (Throwable ssss){
            System.out.println("[箱子登入：ip管理]§c单个ip最大注册玩家数量配置文件错误，请检查配置文件");
        }
        try {
            玩家离开服务器时广播消息 = ip管理配置.getString("玩家离开服务器时广播消息");
        }catch (Throwable ssss){
            System.out.println("[箱子登入：ip管理]§c玩家离开服务器时广播消息配置文件错误，请检查配置文件");
        }
        try {
            超过ip限制被踢时显示消息 = ip管理配置.getString("超过ip限制被踢时显示消息");
        }catch (Throwable ssss){
            System.out.println("[箱子登入：ip管理]§c超过ip限制被踢时显示消息配置文件错误，请检查配置文件");
        }
        try {
            超过单个ip最大注册玩家数量显示消息 = ip管理配置.getString("超过单个ip最大注册玩家数量显示消息");
        }catch (Throwable ssss){
            System.out.println("[箱子登入：ip管理]§c超过单个ip最大注册玩家数量显示消息配置文件错误，请检查配置文件");
        }
        try {
            超过单个ip最大注册玩家数量显示消息1 = ip管理配置.getString("超过单个ip最大注册玩家数量显示消息1");
        }catch (Throwable ssss){
            System.out.println("[箱子登入：ip管理]§c超过单个ip最大注册玩家数量显示消息1配置文件错误，请检查配置文件");
        }
        System.out.println("[箱子登入：ip管理]§a配置文件加载完成");
    }
    @EventHandler
    public void 玩家进入(PlayerJoinEvent p){
        if(ip.if是否超过ip玩家数量限制(p.getPlayer().getPlayer().getAddress().getHostString(),单个ip最大进入玩家数量)){
            p.getPlayer().kickPlayer(超过ip限制被踢时显示消息.replaceAll("%玩家%",p.getPlayer().getName()));
            return;
        }
        ip.add(p.getPlayer().getPlayer().getAddress().getHostString(),p.getPlayer().getName());
        p.setJoinMessage(玩家进入时广播消息.replaceAll("%玩家%",p.getPlayer().getName()));
    }
    @EventHandler
    public void 玩家离开服务器(PlayerQuitEvent dj){
        ip.删除(dj.getPlayer().getPlayer().getAddress().getHostString(),dj.getPlayer().getName());
        dj.setQuitMessage(玩家离开服务器时广播消息.replaceAll("%玩家%",dj.getPlayer().getName()));
    }
    @EventHandler(priority= EventPriority.HIGHEST)
    public void 玩家成功登入(drcg dj){
        if(dj.isCancelled()){
            return;
        }
        broadcastMessage(玩家登入成功时广播消息.replaceAll("%玩家%",dj.getPlayer().getName()));

    }
    @EventHandler(priority= EventPriority.HIGHEST)
    public void 玩家成功注册(zccg dj){
        if(玩家ip配置.contains(dj.getPlayer().getAddress().getHostString())){
            if(玩家ip配置.getStringList(dj.getPlayer().getAddress().getHostString()).size()>单个ip最大注册玩家数量){
                dj.setCancelled(true);
                dj.getPlayer().sendTitle(超过单个ip最大注册玩家数量显示消息.replaceAll("%玩家%",dj.getPlayer().getName()),超过单个ip最大注册玩家数量显示消息1.replaceAll("%玩家%",dj.getPlayer().getName()),10,40,10);
                return;
            }
        }

        List wjb = 玩家ip配置.getStringList(dj.getPlayer().getAddress().getHostString());
        if(wjb.contains(dj.getPlayer().getName())){
            return;
        }
        wjb.add(dj.getPlayer().getName());
        玩家ip配置.set(dj.getPlayer().getAddress().getHostString(),wjb);
        Thread 异步保存数据 = new Thread(){
            @Override
            public void run(){
                super.run();
                System.out.println("[箱子登入：ip管理]§a异步保存玩家ip中...");
                try {
                    玩家ip配置.save(玩家ip);
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("[箱子登入：ip管理]§c玩家ip保存出错！请检查磁盘空间和文件权限。");
                }
                System.out.println("[箱子登入：ip管理]§a保存完毕...");
            }
        };
        异步保存数据.start();

        if(dj.isCancelled()){
            return;
        }
        broadcastMessage(玩家登入成功时广播消息.replaceAll("%玩家%",dj.getPlayer().getName()));

    }
}
