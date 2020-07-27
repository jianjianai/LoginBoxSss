package cn.jji8.LoginBoxSss.ip;

import java.util.ArrayList;
import java.util.HashMap;

public class ipdengruwanjia {
    HashMap 表;
    ArrayList 玩家;

    ipdengruwanjia(){
        表 = new HashMap();
        玩家 = new ArrayList();
    }
    public void add(String ip,String p){
        if(表.containsKey(ip)){
            ArrayList wj = (ArrayList) 表.get(ip);
            wj.add(p);
        }else {
            ArrayList wj = new ArrayList();
            wj.add(p);
            表.put(ip,wj);
        }
        玩家.add(p);
    }
    public void 删除(String ip,String p){
        if(表.containsKey(ip)){
            ArrayList wj = (ArrayList) 表.get(ip);
            wj.remove(p);
        }
    }
    public boolean if是否超过ip玩家数量限制(String ip,int bz){
        if(getip玩家个数(ip)<bz){
            return false;
        }
        return true;
    }
    public int getip玩家个数(String ip){
        if(表.containsKey(ip)){
            ArrayList wj = (ArrayList) 表.get(ip);
            return wj.size();
        }
        return 0;
    }
}
