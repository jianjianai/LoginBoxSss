package cn.jji8.LoginBoxSss.login.controller.chest;

import cn.jji8.LoginBoxSss.login.util.Password;
import cn.jji8.LoginBoxSss.Main;
import cn.jji8.LoginBoxSss.WrappedConfiguration;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LoginChest {
    Inventory xiagnzi;
    WrappedConfiguration WrappedConfiguration = Main.getWrappedConfiguration();
    String playerName;
    public void openForPlayer(Player a){
        a.openInventory(xiagnzi);
    }
    public void displayPassword(Password a){
        displayPassword(a.wuping,a.shuliang);
    }
    public void displayPassword(int wupin[], int shulian[]){//用于显示玩家的密码
        for(int i=0;i<=8;i++){
            if(wupin[i]!=-1){
                ItemStack a = (ItemStack) WrappedConfiguration.itemList.get(wupin[i]);
                ItemStack b = new ItemStack(a);
                b.setAmount(shulian[i]);
                xiagnzi.setItem(i+45,b);
            }
        }
    }
    public LoginChest(String playerName){
        this.playerName = playerName;
    }
    public void createInventory(String title){
        Inventory inventory;
        inventory = Bukkit.createInventory(null,6*9,title);
        createInventory(inventory);
    }
    public void createInventory(Inventory inventory){
        ItemStack item;
        item = new ItemStack(WrappedConfiguration.splitItem);
        ItemMeta meta = item.getItemMeta();
        try {
            meta.setDisplayName(WrappedConfiguration.splitLine.replaceAll("%玩家%", playerName));
        }catch (Throwable sss){
            meta.setDisplayName("错误，请联系管理员");
        }
        item.setItemMeta(meta);
        for(int i=36;i<=44;i++){
            inventory.setItem(i, item);
        }
        item = new ItemStack(WrappedConfiguration.reinputButton);
        meta = item.getItemMeta();
        try {
            meta.setDisplayName(WrappedConfiguration.cancel.replaceAll("%玩家%", playerName));
        }catch (Throwable sss){
            meta.setDisplayName("错误，请联系管理员");
        }
        item.setItemMeta(meta);
        inventory.setItem(36, item);
        item = new ItemStack(WrappedConfiguration.confirmButton);
        meta = item.getItemMeta();
        try {
            meta.setDisplayName(WrappedConfiguration.confirm.replaceAll("%玩家%", playerName));
        }catch (Throwable sss){
            meta.setDisplayName("错误，请联系管理员");
        }
        item.setItemMeta(meta);
        inventory.setItem(44, item);
        xiagnzi = inventory;

        for(int i=0;i<=35;i++){
            inventory.setItem(i, (ItemStack) WrappedConfiguration.itemList.get(i));
        }
    }

}
