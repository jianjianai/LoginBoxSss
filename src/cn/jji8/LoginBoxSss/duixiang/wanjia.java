package cn.jji8.LoginBoxSss.duixiang;

import cn.jji8.LoginBoxSss.duixiang.guikongziqi.kz;
import org.bukkit.entity.Player;

public class wanjia {

    Player Player;
    mima mima = new mima();
    kz kz;
    //构造方法
    public wanjia(Player a){
        Player = a;
    }
    //get方法
    public Player getPlayer() {
        return Player;
    }
    //get方法
    public mima getMima() {//获取密码
        return mima;
    }
    //set方法
    public void setKz(kz kz) {
        this.kz = kz;
    }
    //点击方法
    public void dianji(int weizi){
        kz.dianji(weizi,this);
    }
}
