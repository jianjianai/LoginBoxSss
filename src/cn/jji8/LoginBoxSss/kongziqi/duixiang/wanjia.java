package cn.jji8.LoginBoxSss.kongziqi.duixiang;

import cn.jji8.LoginBoxSss.kongziqi.duixiang.kongziqi.kzq;
import org.bukkit.entity.Player;

public class wanjia {
    Player P;
    kzq kzq;
    mima mima;
    public wanjia(Player a){
        P = a;
        mima = new mima();
        kzq = mima.duqumima(a.getName());
    }
    public wanjia(Player a, kzq b){
        kzq = b;
        P = a;
    }
    public void dianji(int dianjiweizi){
        kzq.dianji(this,dianjiweizi);
    }
}
