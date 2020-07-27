package cn.jji8.LoginBoxSss.kongziqi.duixiang.kongziqi;

import cn.jji8.LoginBoxSss.kongziqi.dengrukongzhiqi;
import cn.jji8.LoginBoxSss.kongziqi.duixiang.kongziqi.xiangzi.xiangzi;
import cn.jji8.LoginBoxSss.kongziqi.duixiang.wanjia;
import cn.jji8.LoginBoxSss.kongziqi.wanjiakongzhiqi;
import cn.jji8.LoginBoxSss.kongziqi.wanjiasezi;
import cn.jji8.LoginBoxSss.main;
import cn.jji8.LoginBoxSss.shijian.drcg;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class denru implements kzq {
    xiangzi xiangzi;
    public denru(Player a){
        if(main.getPeizi().登入时旁观者模式){
            a.getPlayer().setGameMode(GameMode.SPECTATOR);
        }
        xiangzi = new xiangzi(a.getName());
        xiangzi.chuangjianxiangzi(main.getPeizi().登入);
        xiangzi.dakaixiangzi(a);
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
            wanjia.getMima().chongzimima();
            xiangzi.chuangjianxiangzi(main.getPeizi().登入);
            xiangzi.xianshimima(wanjia.getMima());
            xiangzi.dakaixiangzi(wanjia.getP());
        }else if(dianjiweizi==44){
            if(main.getPeizi().声音){
                wanjia.getP().playSound(wanjia.getP().getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL,30,2);
            }
            if(wanjia.getMima().bijiaomima()){
                drcg drcg = new drcg(wanjia.getP());//处理事件
                Bukkit.getServer().getPluginManager().callEvent(drcg);
                if(drcg.isCancelled()) {
                    return; //事件被取消, 终止事件的处理
                }
                wanjia.getP().closeInventory();
                wanjiasezi.setwanjiayidengru(wanjia.getP().getName());
                wanjia.getP().sendTitle(main.getPeizi().登入成功1.replaceAll("%玩家%",wanjia.getP().getName()),main.getPeizi().登入成功2.replaceAll("%玩家%",wanjia.getP().getName()),10,40,10);
                if(main.getPeizi().登入时旁观者模式){
                    wanjia.getP().setGameMode(main.getPeizi().服务器游戏模式);
                }
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(),main.getPeizi().登入成功后台执行命令.replaceAll("%玩家%",wanjia.getP().getName()));
            }else {
                xiangzi.chuangjianxiangzi(main.getPeizi().密码错误);
                xiangzi.xianshimima(wanjia.getMima());
                xiangzi.dakaixiangzi(wanjia.getP());
            }
        }
    }

    @Override
    public void dakai(wanjia a) {
        xiangzi.dakaixiangzi(a.getP());
    }
}
