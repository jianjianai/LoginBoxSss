package cn.jji8.LoginBoxSss.isstatic;

import cn.jji8.LoginBoxSss.duixiang.wanjia;
import org.bukkit.entity.Player;

import java.util.HashMap;
/*
* 记录未登入的玩家
* */
public class biao {
    static HashMap<String, wanjia> b = new HashMap<String, wanjia>();
    //添加玩家
    public static wanjia tianjia(Player a){
        wanjia wanjia = new wanjia(a);
        b.put(a.getName(),wanjia);
        return wanjia;
    }
    //删除玩家
    public static void shancu(Player a){
        b.remove(a.getName());
    }
    //删除玩家
    public static void shancu(String wanjiamingzi){
        b.remove(wanjiamingzi);
    }
    //判断玩家是否在表中
    public static boolean ifwanjia(Player a){
        return b.containsKey(a.getName());
    }
    //判断玩家是否在表中
    public static boolean ifwanjia(String wanjiamingzi){
        return b.containsKey(wanjiamingzi);
    }
    //获取玩家
    public static wanjia getwanjia(Player a){
        return b.get(a.getName());
    }
    //获取玩家
    public static wanjia getwanjia(String wanjiamengzi){
        return b.get(wanjiamengzi);
    }
}
