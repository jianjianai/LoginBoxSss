package cn.jji8.LoginBoxSss.kongziqi.duixiang;

import cn.jji8.LoginBoxSss.kongziqi.duixiang.kongziqi.kzq;
import org.bukkit.entity.Player;

public class wanjia {
    Player P;
    kzq kzq;
    mima mima;
    public wanjia(Player a){
        P = a;
        mima = new mima(this);
        kzq = mima.duqumima(a.getName());
    }
    public wanjia(Player a, kzq b){
        kzq = b;
        P = a;
        mima = new mima(this);
        mima.ziduqumima(a.getName());
    }
    public void dianji(int dianjiweizi){
        kzq.dianji(this,dianjiweizi);
    }
    public void dakai(){kzq.dakai(this);}

    public Player getP() {
        return P;
    }

    public cn.jji8.LoginBoxSss.kongziqi.duixiang.mima getMima() {
        return mima;
    }
}
