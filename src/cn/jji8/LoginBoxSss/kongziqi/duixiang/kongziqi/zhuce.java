package cn.jji8.LoginBoxSss.kongziqi.duixiang.kongziqi;

import cn.jji8.LoginBoxSss.kongziqi.dengrukongzhiqi;
import cn.jji8.LoginBoxSss.kongziqi.duixiang.kongziqi.xiangzi.xiangzi;
import cn.jji8.LoginBoxSss.kongziqi.duixiang.wanjia;
import cn.jji8.LoginBoxSss.main;
import org.bukkit.Sound;

public class zhuce implements kzq {
    xiangzi xiangzi;
    wanjia wanjia;
    boolean chongfu = false;
    String mima;
    public zhuce(wanjia a){
        wanjia = a;
        xiangzi = new xiangzi(a.getP().getName());
        xiangzi.chuangjianxiangzi(main.getPeizi().注册);
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
            xiangzi.chuangjianxiangzi(main.getPeizi().注册);
            xiangzi.xianshimima(wanjia.getMima());
            xiangzi.dakaixiangzi(wanjia.getP());
            chongfu = false;
        }else if(dianjiweizi==44){
            wanjia.getP().playSound(wanjia.getP().getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL,30,2);
            if(!chongfu){
                mima = wanjia.getMima().toString();
                wanjia.getMima().chongzimima();
                xiangzi.chuangjianxiangzi(main.getPeizi().重复);
                xiangzi.xianshimima(wanjia.getMima());
                xiangzi.dakaixiangzi(wanjia.getP());
                chongfu = true;
            }else {
                if(mima.equals(wanjia.getMima().toString())){
                    wanjia.getMima().baocunmima(wanjia.getP().getName());
                    wanjia.getP().closeInventory();
                    dengrukongzhiqi.biao.remove(wanjia.getP().getName());
                }else {
                    wanjia.getMima().chongzimima();
                    xiangzi.chuangjianxiangzi(main.getPeizi().两次密码不一致);
                    xiangzi.xianshimima(wanjia.getMima());
                    xiangzi.dakaixiangzi(wanjia.getP());
                }
            }
        }
    }
}
