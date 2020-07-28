package cn.jji8.LoginBoxSss.login.util;

import cn.jji8.LoginBoxSss.login.controller.Login;
import cn.jji8.LoginBoxSss.login.controller.Controller;
import cn.jji8.LoginBoxSss.login.controller.Register;
import cn.jji8.LoginBoxSss.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Password {
    public int wuping[] = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
    public int shuliang[] = {1,1,1,1,1,1,1,1,1};
    public int zhizheng=0;
    String mima;
    WrappedPlayer wrappedPlayer;
    Password(WrappedPlayer a){
        wrappedPlayer = a;
    }
    public boolean bijiaomima(){
        return toString().equals(mima);
    }
    public void chongzimima(){//重置密码
        wuping = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1};
        shuliang = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1};
        zhizheng=0;
    }
    public void doInput(int i){
        boolean sss = true;
        if(zhizheng-1>=0){
            if(wuping[zhizheng-1]==i){
                if(shuliang[zhizheng-1]<64){
                    sss = false;
                    shuliang[zhizheng-1] = shuliang[zhizheng-1]+1;
                    if(Main.getWrappedConfiguration().playSound){
                        wrappedPlayer.getPlayer().playSound(wrappedPlayer.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL,30,0);
                    }
                }
            }
        }
        if(sss){
            if(zhizheng<=8){
                wuping[zhizheng]=i;
                zhizheng = zhizheng+1;
                if(Main.getWrappedConfiguration().playSound){
                    wrappedPlayer.getPlayer().playSound(wrappedPlayer.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL,30,1);
                }
            }
        }
    }
    @Override
    public String toString() {
        StringBuffer to = new StringBuffer();
        for(int i =0;i<=8;i++){
            to.append(shuliang[i]);
        }
        for(int i =0;i<=8;i++){
            to.append(wuping[i]);
        }
        return to.toString();
    }
    public void setMima(String mima) {
        this.mima = mima;
    }
    public String getMima() {
        return mima;
    }
    public Controller duqumima(String wanjia){
        YamlConfiguration a;
        if(Main.getWrappedConfiguration().bungeeMode){
            a = YamlConfiguration.loadConfiguration(new File(Main.getWrappedConfiguration().workDir,"mima/"+wanjia+".yml"));
        }else {
            a = YamlConfiguration.loadConfiguration(new File(Main.getMain().getDataFolder(),"mima/"+wanjia+".yml"));
        }
        if(a.contains("密码")){
            mima = a.getString("密码");
            return new Login(this.wrappedPlayer.getPlayer());
        }
        return new Register(this.wrappedPlayer.getPlayer());
    }
    public void ziduqumima(String wanjia){
        YamlConfiguration a;
        if(Main.getWrappedConfiguration().bungeeMode){
            a = YamlConfiguration.loadConfiguration(new File(Main.getWrappedConfiguration().workDir,"mima/"+wanjia+".yml"));
        }else {
            a = YamlConfiguration.loadConfiguration(new File(Main.getMain().getDataFolder(),"mima/"+wanjia+".yml"));
        }
        mima = a.getString("密码");
    }
    public void baocunmima(String wanjia){
        File File;
        YamlConfiguration a;
        if(Main.getWrappedConfiguration().bungeeMode){
            a = YamlConfiguration.loadConfiguration(File = new File(Main.getWrappedConfiguration().workDir,"mima/"+wanjia+".yml"));
        }else {
            a = YamlConfiguration.loadConfiguration(File = new File(Main.getMain().getDataFolder(),"mima/"+wanjia+".yml"));
        }
        a.set("密码",toString());
        try {
            a.save(File);
        } catch (IOException e) {
            e.printStackTrace();
            Bukkit.getLogger().warning("[箱子登入X]:密码保存失败,玩家密码未保存，请检查写入权限，或磁盘空间");
        }
    }
}
