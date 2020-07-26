package cn.jji8.LoginBoxSss.isstatic;

import cn.jji8.LoginBoxSss.duixiang.guikongziqi.dengru;
import cn.jji8.LoginBoxSss.duixiang.guikongziqi.zhuce;
import cn.jji8.LoginBoxSss.duixiang.mima;
import cn.jji8.LoginBoxSss.duixiang.wanjia;
import cn.jji8.LoginBoxSss.main;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/*
* 专门负责操作密码
* */
public class mimacaozuo {
    static File lujing = new File(main.getMian().getDataFolder(), "mima.yml");
    static YamlConfiguration mima =  YamlConfiguration.loadConfiguration(lujing);

    //读取密码和添加控制器
    public static void duqumima(wanjia a){
        if(mima.contains(a.getPlayer().getName())){
            a.setKz(new dengru());
            a.getMima().setMimaT(mima.getString(a.getPlayer().getName()));
        }else {
            a.setKz(new zhuce());
        }
    }
    //只读取密码
    public static void ziduqumima(wanjia a){
            a.getMima().setMimaT(mima.getString(a.getPlayer().getName()));
    }
    //保存密码
    public static void baocunmima(wanjia a) throws IOException {
        mima.set(a.getPlayer().getName(),a.getMima().toString());
        mima.save(lujing);
    }
    //判断密码
    public static boolean panduanmima(wanjia a){
        return a.getMima().toString().equals(a.getMima().getMimaT());
    }
}
