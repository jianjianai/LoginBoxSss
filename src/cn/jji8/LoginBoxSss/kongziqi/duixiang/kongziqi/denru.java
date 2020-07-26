package cn.jji8.LoginBoxSss.kongziqi.duixiang.kongziqi;

import cn.jji8.LoginBoxSss.kongziqi.dengrukongzhiqi;
import cn.jji8.LoginBoxSss.kongziqi.duixiang.kongziqi.xiangzi.xiangzi;
import cn.jji8.LoginBoxSss.kongziqi.duixiang.wanjia;
import cn.jji8.LoginBoxSss.main;
import org.bukkit.Sound;
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
                xiangzi.xianshimima(wanjia.getMima());
            }else if(dianjiweizi==36){
                wanjia.getP().playSound(wanjia.getP().getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL,30,2);
                wanjia.getMima().chongzimima();
                xiangzi.chuangjianxiangzi(main.getPeizi().登入);
                xiangzi.xianshimima(wanjia.getMima());
                xiangzi.dakaixiangzi(wanjia.getP());
            }else if(dianjiweizi==44){
                wanjia.getP().playSound(wanjia.getP().getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL,30,2);
                if(wanjia.getMima().bijiaomima()){
                    wanjia.getP().closeInventory();
                    dengrukongzhiqi.biao.remove(wanjia.getP().getName());
                }else {
                    xiangzi.chuangjianxiangzi(main.getPeizi().密码错误);
                    xiangzi.xianshimima(wanjia.getMima());
                    xiangzi.dakaixiangzi(a.getP());
                }
        }
    }
}
