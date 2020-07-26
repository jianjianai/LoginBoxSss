package cn.jji8.LoginBoxSss.kongziqi.duixiang.kongziqi;

import cn.jji8.LoginBoxSss.kongziqi.duixiang.kongziqi.xiangzi.xiangzi;
import cn.jji8.LoginBoxSss.kongziqi.duixiang.wanjia;
import cn.jji8.LoginBoxSss.main;
import org.bukkit.entity.Player;

public class denru implements kzq {
    xiangzi xiangzi;
    wanjia wanjia;
    public denru(wanjia a){
        wanjia = a;
        xiangzi = new xiangzi(a.getP().getName());
        xiangzi.chuangjianxiangzi(main.getPeizi().登入);
        xiangzi.dakaixiangzi(a.getP());
    }
    @Override
    public void dianji(wanjia a, int dianjiweizi) {
            if(dianjiweizi>=0&dianjiweizi<=35){
                wanjia.getMima().suru(dianjiweizi);
            }else if(dianjiweizi==36){

            }else if(dianjiweizi==44){

        }
    }
}
