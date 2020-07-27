package cn.jji8.LoginBoxSss.kongziqi.duixiang.kongziqi;

import cn.jji8.LoginBoxSss.kongziqi.duixiang.kongziqi.xiangzi.xiangzi;
import cn.jji8.LoginBoxSss.kongziqi.duixiang.wanjia;
import cn.jji8.LoginBoxSss.kongziqi.wanjiasezi;
import cn.jji8.LoginBoxSss.main;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class xiugaimima implements kzq {
    xiangzi xiangzi;
    boolean chongfu = false;
    boolean xiugaimima = false;
    String mima;
    boolean guanbi = false;
    public xiugaimima(Player a){
        if(main.getPeizi().登入时旁观者模式){
            a.getPlayer().setGameMode(GameMode.SPECTATOR);
        }
        xiangzi = new xiangzi(a.getName());
        xiangzi.chuangjianxiangzi(main.getPeizi().修改密码箱子标题);
        xiangzi.dakaixiangzi(a);

        Thread T = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                guanbi = true;
            }
        };
        T.start();
    }
    @Override
    public void dianji(wanjia wanjia, int dianjiweizi) {
        if(dianjiweizi>=0&dianjiweizi<=35){
            wanjia.getMima().suru(dianjiweizi);
            xiangzi.xianshimima(wanjia.getMima());
        }else if(dianjiweizi==36){
            if(main.getPeizi().声音){
                wanjia.getP().playSound(wanjia.getP().getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL,30,2);
            }
            if(xiugaimima){
                wanjia.getMima().chongzimima();
                xiangzi.chuangjianxiangzi(main.getPeizi().输入你想修改的密码);
                xiangzi.xianshimima(wanjia.getMima());
                xiangzi.dakaixiangzi(wanjia.getP());
                chongfu = false;
            }else {
                wanjia.getMima().chongzimima();
                xiangzi.chuangjianxiangzi(main.getPeizi().修改密码箱子标题);
                xiangzi.xianshimima(wanjia.getMima());
                xiangzi.dakaixiangzi(wanjia.getP());
            }
        }else if(dianjiweizi==44){
            if(main.getPeizi().声音){
                wanjia.getP().playSound(wanjia.getP().getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL,30,2);
            }
            if(xiugaimima){
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
                        wanjiasezi.setwanjiayidengru(wanjia.getP().getName());
                        wanjia.getP().sendTitle(main.getPeizi().修改成功1.replaceAll("%玩家%",wanjia.getP().getName()),main.getPeizi().修改成功2.replaceAll("%玩家%",wanjia.getP().getName()),10,40,10);
                        if(main.getPeizi().登入时旁观者模式){
                            wanjia.getP().setGameMode(main.getPeizi().服务器游戏模式);
                        }
                    }else {
                        wanjia.getMima().chongzimima();
                        xiangzi.chuangjianxiangzi(main.getPeizi().两次密码不一致);
                        xiangzi.xianshimima(wanjia.getMima());
                        xiangzi.dakaixiangzi(wanjia.getP());
                    }
                }
            }else if(wanjia.getMima().bijiaomima()){
                wanjia.getMima().chongzimima();
                xiangzi.chuangjianxiangzi(main.getPeizi().输入你想修改的密码);
                xiangzi.xianshimima(wanjia.getMima());
                xiangzi.dakaixiangzi(wanjia.getP());
                xiugaimima = true;
            }else {
                xiangzi.chuangjianxiangzi(main.getPeizi().密码错误);
                xiangzi.xianshimima(wanjia.getMima());
                xiangzi.dakaixiangzi(wanjia.getP());
            }


        }
    }
    @Override
    public void dakai(wanjia a) {
        if(guanbi){
            a.getP().closeInventory();
            wanjiasezi.setwanjiayidengru(a.getP().getName());
            a.getP().sendTitle(main.getPeizi().取消修改密码1.replaceAll("%玩家%",a.getP().getName()),main.getPeizi().取消修改密码2.replaceAll("%玩家%",a.getP().getName()),10,40,10);
            if(main.getPeizi().登入时旁观者模式){
                a.getP().setGameMode(main.getPeizi().服务器游戏模式);
            }
        }
    }
}
