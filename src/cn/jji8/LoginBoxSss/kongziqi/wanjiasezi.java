package cn.jji8.LoginBoxSss.kongziqi;

import cn.jji8.LoginBoxSss.kongziqi.duixiang.wanjia;
import org.bukkit.entity.Player;

public class wanjiasezi {
    public static void setwanjiayidengru(String name){
        wanjiakongzhiqi.biao.add(name);
        dengrukongzhiqi.biao.remove(name);
    }
    public static void setwanjieweidenru(Player wanjia){
        wanjiakongzhiqi.biao.remove(wanjia.getName());
        dengrukongzhiqi.shjian(wanjia);
    }
    public static void setwanjieweidenru(wanjia wanjia){
        dengrukongzhiqi.biao.put(wanjia.getP().getName(),wanjia);
        wanjiakongzhiqi.biao.remove(wanjia.getP().getName());
    }
}
