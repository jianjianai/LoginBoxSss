package cn.jji8.LoginBoxSss.kongziqi.duixiang.kongziqi.xiangzi;

import cn.jji8.LoginBoxSss.kongziqi.duixiang.mima;
import cn.jji8.LoginBoxSss.main;
import cn.jji8.LoginBoxSss.peizi;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class xiangzi {
    Inventory xiagnzi;
    peizi  peizi = main.getPeizi();
    String wanjiamengzi;
    public void dakaixiangzi(Player a){
        a.openInventory(xiagnzi);
    }
    public void xianshimima(mima a){
        xianshimima(a.wuping,a.shuliang);
    }
    public void xianshimima(int wupin[],int shulian[]){//用于显示玩家的密码
        for(int i=0;i<=8;i++){
            if(wupin[i]!=-1){
                ItemStack a = (ItemStack) peizi.物品列表.get(wupin[i]);
                ItemStack b = new ItemStack(a);
                b.setAmount(shulian[i]);
                xiagnzi.setItem(i+45,b);
            }
        }
    }
    public xiangzi(String a){
        wanjiamengzi = a;
    }
    public void chuangjianxiangzi(String a){
        Inventory xz1;
        xz1 = Bukkit.createInventory(null,6*9,a);
        chuangjianxiangzi(xz1);
    }
    public void chuangjianxiangzi(Inventory xz1){
        ItemStack WPD;
        WPD = new ItemStack(peizi.分割线物品);
        ItemMeta wp = WPD.getItemMeta();
        try {
            wp.setDisplayName(peizi.分割线.replaceAll("%玩家%",wanjiamengzi));
        }catch (Throwable sss){
            wp.setDisplayName("错误，请联系管理员");
        }
        WPD.setItemMeta(wp);
        for(int i=36;i<=44;i++){
            xz1.setItem(i, WPD);
        }
        WPD = new ItemStack(peizi.重新输入按钮物品);
        wp = WPD.getItemMeta();
        try {
            wp.setDisplayName(peizi.取消.replaceAll("%玩家%",wanjiamengzi));
        }catch (Throwable sss){
            wp.setDisplayName("错误，请联系管理员");
        }
        WPD.setItemMeta(wp);
        xz1.setItem(36, WPD);
        WPD = new ItemStack(peizi.确定按钮物品);
        wp = WPD.getItemMeta();
        try {
            wp.setDisplayName(peizi.确定.replaceAll("%玩家%",wanjiamengzi));
        }catch (Throwable sss){
            wp.setDisplayName("错误，请联系管理员");
        }
        WPD.setItemMeta(wp);
        xz1.setItem(44, WPD);
        xiagnzi = xz1;

        for(int i=0;i<=35;i++){
            xz1.setItem(i, (ItemStack) peizi.物品列表.get(i));
        }
    }

}
