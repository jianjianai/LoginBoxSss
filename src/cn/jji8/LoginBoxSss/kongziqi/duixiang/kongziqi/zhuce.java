package cn.jji8.LoginBoxSss.kongziqi.duixiang.kongziqi;

import cn.jji8.LoginBoxSss.kongziqi.duixiang.kongziqi.xiangzi.xiangzi;
import cn.jji8.LoginBoxSss.kongziqi.duixiang.wanjia;
import cn.jji8.LoginBoxSss.main;

public class zhuce implements kzq {
    xiangzi xiangzi;
    wanjia wanjia;
    public zhuce(wanjia a){
        wanjia = a;
        xiangzi = new xiangzi(a.getP().getName());
        xiangzi.chuangjianxiangzi(main.getPeizi().注册);
        xiangzi.dakaixiangzi(a.getP());
    }
    @Override
    public void dianji(wanjia a, int dianjiweizi) {
        
    }
}
