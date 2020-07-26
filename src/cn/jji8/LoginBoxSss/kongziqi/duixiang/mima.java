package cn.jji8.LoginBoxSss.kongziqi.duixiang;

import cn.jji8.LoginBoxSss.kongziqi.duixiang.kongziqi.denru;
import cn.jji8.LoginBoxSss.kongziqi.duixiang.kongziqi.kzq;
import cn.jji8.LoginBoxSss.kongziqi.duixiang.kongziqi.zhuce;
import cn.jji8.LoginBoxSss.main;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class mima {
    int wuping[] = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
    int shuliang[] = {1,1,1,1,1,1,1,1,1};
    int zhizheng=0;
    String mima;
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
    public kzq duqumima(String wanjia){
        YamlConfiguration a = YamlConfiguration.loadConfiguration(new File(main.getMian().getDataFolder(),wanjia+".yml"));
        if(a.contains("密码")){
            mima = a.getString("密码");
            return new denru();
        }
        return new zhuce();
    }
    public void ziduqumima(String wanjia){
        YamlConfiguration a = YamlConfiguration.loadConfiguration(new File(main.getMian().getDataFolder(),wanjia+".yml"));
        mima = a.getString("密码");
    }
    public void baocunmima(String wanjia){
        File File;
        YamlConfiguration a = YamlConfiguration.loadConfiguration(File = new File(main.getMian().getDataFolder(),wanjia+".yml"));
        a.set("密码",toString());
    }
}
