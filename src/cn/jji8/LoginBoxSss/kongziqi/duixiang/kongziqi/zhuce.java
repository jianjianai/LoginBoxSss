package cn.jji8.LoginBoxSss.kongziqi.duixiang.kongziqi;

import cn.jji8.LoginBoxSss.kongziqi.dengrukongzhiqi;
import cn.jji8.LoginBoxSss.kongziqi.duixiang.kongziqi.xiangzi.xiangzi;
import cn.jji8.LoginBoxSss.kongziqi.duixiang.wanjia;
import cn.jji8.LoginBoxSss.kongziqi.wanjiakongzhiqi;
import cn.jji8.LoginBoxSss.kongziqi.wanjiasezi;
import cn.jji8.LoginBoxSss.main;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class zhuce implements kzq {
    xiangzi xiangzi;
    boolean chongfu = false;
    String mima;
    public zhuce(Player a){
        if(main.getPeizi().登入时旁观者模式){
            a.getPlayer().setGameMode(GameMode.SPECTATOR);
        }
        xiangzi = new xiangzi(a.getName());
        xiangzi.chuangjianxiangzi(main.getPeizi().注册);
        xiangzi.dakaixiangzi(a);
    }
    @Override
    public void dianji(wanjia wanjia, int dianjiweizi) {
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
                    wanjia.getP().closeInventory();
                    wanjiasezi.setwanjiayidengru(wanjia.getP().getName());
                    wanjia.getP().sendTitle(main.getPeizi().注册成功1.replaceAll("%玩家%",wanjia.getP().getName()),main.getPeizi().注册成功2.replaceAll("%玩家%",wanjia.getP().getName()),10,40,10);
                    if(main.getPeizi().登入时旁观者模式){
                        wanjia.getP().setGameMode(main.getPeizi().服务器游戏模式);
                    }
                    Thread T = new Thread(){
                        @Override
                        public void run() {
                            wanjia.getMima().baocunmima(wanjia.getP().getName());
                        }
                    };
                    T.start();
                }else {
                    wanjia.getMima().chongzimima();
                    xiangzi.chuangjianxiangzi(main.getPeizi().两次密码不一致);
                    xiangzi.xianshimima(wanjia.getMima());
                    xiangzi.dakaixiangzi(wanjia.getP());
                }
            }
        }
    }
    @Override
    public void dakai(wanjia a) {
        xiangzi.dakaixiangzi(a.getP());
    }
}
