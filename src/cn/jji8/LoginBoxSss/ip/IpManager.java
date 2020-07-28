package cn.jji8.LoginBoxSss.ip;

import cn.jji8.LoginBoxSss.Main;
import cn.jji8.LoginBoxSss.event.LoginSuccessEvent;
import cn.jji8.LoginBoxSss.event.PlayerRegisterSuccessEvent;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.bukkit.Bukkit.broadcastMessage;

public class IpManager implements Listener {
    private int maxJoinedPlayerPerIp;
    private int maxRegistrationPerIp;
    private String joinMessage;
    private String loginMessage;
    private String leaveMessage;
    private String maxIpKickMessage;
    private String maxIpRegisterationMessage;
    private String maxIpRegisterationMessage2;

    private final File playerIpConfigurationFile;
    private final FileConfiguration playerIpConfiguration;
    private final PlayerIpTable ip = new PlayerIpTable();

    public IpManager(){
        System.out.println("[箱子登入：ip管理]§a开始加载配置文件");
        Main.getMain().saveResource("ipconfig.yml",false);
        playerIpConfigurationFile = new File(Main.getMain().getDataFolder(),"ip/ipconfig.yml");
        FileConfiguration ipConfig = YamlConfiguration.loadConfiguration(new File(Main.getMain().getDataFolder(), "ipconfig.yml"));
        playerIpConfiguration = YamlConfiguration.loadConfiguration(playerIpConfigurationFile);
        try {
            joinMessage = ipConfig.getString("joinMessage");
        }catch (Throwable ssss){
            System.out.println("[箱子登入：ip管理]§c玩家进入时广播消息配置文件错误，请检查配置文件");
        }
        try {
            loginMessage = ipConfig.getString("loginMessage");
        }catch (Throwable ssss){
            System.out.println("[箱子登入：ip管理]§c玩家登入成功时广播消息配置文件错误，请检查配置文件");
        }
        try {
            maxJoinedPlayerPerIp = ipConfig.getInt("maxJoinedPlayerPerIp");
        }catch (Throwable ssss){
            System.out.println("[箱子登入：ip管理]§c单个ip最大进入玩家数量配置文件错误，请检查配置文件");
        }
        try {
            maxRegistrationPerIp = ipConfig.getInt("maxRegistrationPerIp");
        }catch (Throwable ssss){
            System.out.println("[箱子登入：ip管理]§c单个ip最大注册玩家数量配置文件错误，请检查配置文件");
        }
        try {
            leaveMessage = ipConfig.getString("leaveMessage");
        }catch (Throwable ssss){
            System.out.println("[箱子登入：ip管理]§c玩家离开服务器时广播消息配置文件错误，请检查配置文件");
        }
        try {
            maxIpKickMessage = ipConfig.getString("maxIpKickMessage");
        }catch (Throwable ssss){
            System.out.println("[箱子登入：ip管理]§c超过ip限制被踢时显示消息配置文件错误，请检查配置文件");
        }
        try {
            maxIpRegisterationMessage = ipConfig.getString("maxIpRegisterationMessage");
        }catch (Throwable ssss){
            System.out.println("[箱子登入：ip管理]§c超过单个ip最大注册玩家数量显示消息配置文件错误，请检查配置文件");
        }
        try {
            maxIpRegisterationMessage2 = ipConfig.getString("maxIpRegisterationMessage2");
        }catch (Throwable ssss){
            System.out.println("[箱子登入：ip管理]§c超过单个ip最大注册玩家数量显示消息1配置文件错误，请检查配置文件");
        }
        System.out.println("[箱子登入：ip管理]§a配置文件加载完成");
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        if(ip.checkPlayerAmountOnIp(event.getPlayer().getPlayer().getAddress().getHostString(), maxJoinedPlayerPerIp)){
            event.getPlayer().kickPlayer(maxIpKickMessage.replaceAll("%玩家%",event.getPlayer().getName()));
            return;
        }
        ip.add(event.getPlayer().getPlayer().getAddress().getHostString(),event.getPlayer().getName());
        event.setJoinMessage(joinMessage.replaceAll("%玩家%",event.getPlayer().getName()));
    }
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event){
        ip.remove(event.getPlayer().getPlayer().getAddress().getHostString(),event.getPlayer().getName());
        event.setQuitMessage(leaveMessage.replaceAll("%玩家%",event.getPlayer().getName()));
    }
    @EventHandler(priority= EventPriority.HIGHEST)
    public void onPlayerLoginSuccessfully(LoginSuccessEvent event){
        if(event.isCancelled()){
            return;
        }
        broadcastMessage(loginMessage.replaceAll("%玩家%",event.getPlayer().getName()));

    }
    @EventHandler(priority= EventPriority.HIGHEST)
    public void onPlayerRegisterSuccessfully(PlayerRegisterSuccessEvent dj){
        if(playerIpConfiguration.contains(dj.getPlayer().getAddress().getHostString())){
            if(playerIpConfiguration.getStringList(dj.getPlayer().getAddress().getHostString()).size()> maxRegistrationPerIp){
                dj.setCancelled(true);
                dj.getPlayer().sendTitle(maxIpRegisterationMessage.replaceAll("%玩家%",dj.getPlayer().getName()), maxIpRegisterationMessage2.replaceAll("%玩家%",dj.getPlayer().getName()),10,40,10);
                return;
            }
        }

        List<String> registeredPlayers = playerIpConfiguration.getStringList(dj.getPlayer().getAddress().getHostString());
        if(registeredPlayers.contains(dj.getPlayer().getName())){
            return;
        }
        registeredPlayers.add(dj.getPlayer().getName());
        playerIpConfiguration.set(dj.getPlayer().getAddress().getHostString(), registeredPlayers);
        Bukkit.getScheduler().runTaskAsynchronously(Main.getMain(), () -> {
            System.out.println("[箱子登入：ip管理]§a异步保存玩家ip中...");
            try {
                playerIpConfiguration.save(playerIpConfigurationFile);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("[箱子登入：ip管理]§c玩家ip保存出错！请检查磁盘空间和文件权限。");
            }
            System.out.println("[箱子登入：ip管理]§a保存完毕...");
        });

        if(dj.isCancelled()){
            return;
        }
        broadcastMessage(loginMessage.replaceAll("%玩家%",dj.getPlayer().getName()));

    }
}
