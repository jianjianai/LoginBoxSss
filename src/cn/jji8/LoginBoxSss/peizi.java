package cn.jji8.LoginBoxSss;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class peizi {

    public int 登入超时时间,最小长度,最大长度;

    public String 登入;
    public String 登入超时踢出玩家提示消息;
    public String 注册;
    public String 重复;
    public String 密码错误;
    public String 两次密码不一致;
    public String 取消 ;
    public String 登入成功1,登入成功2,登入成功后台执行命令,注册成功1,注册成功2,注册成功后台执行命令,修改密码箱子标题,修改成功1,修改成功2;

    public String 分割线;
    public String 确定,取消修改密码1,取消修改密码2,输入你想修改的密码,工作路径,允许名字范围;


    public List 物品列表;

    public boolean 登入时旁观者模式,ip管理器;
    public boolean 声音;
    public boolean 登入超时踢出玩家,bc模式,名字限制,同名大小不同禁止进入;

    public GameMode 服务器游戏模式;

    public File wanjiamimapeizi;

    public ItemStack 分割线物品,确定按钮物品,重新输入按钮物品;

    public peizi(){
        main.getMian().saveResource("peizi.yml",false);
        YamlConfiguration a = YamlConfiguration.loadConfiguration(new File(main.mian.getDataFolder(),"peizi.yml"));
        Bukkit.getLogger().info("[箱子登入X]:§a开始加载配置");
        //string
        if(a.contains("允许名字范围")){ 允许名字范围 = a.getString("允许名字范围");}else{System.out.println("[箱子登入]：§c允许名字范围置文件错误，请检查配置文件");}
        if(a.contains("工作路径")){ 工作路径 = a.getString("工作路径");}else{System.out.println("[箱子登入]：§c工作路径置文件错误，请检查配置文件");}
        if(a.contains("修改成功1")){ 修改成功1 = a.getString("修改成功1");}else{System.out.println("[箱子登入]：§c修改成功1置文件错误，请检查配置文件");}
        if(a.contains("修改成功2")){ 修改成功2 = a.getString("修改成功2");}else{System.out.println("[箱子登入]：§c修改成功2置文件错误，请检查配置文件");}
        if(a.contains("输入你想修改的密码")){ 输入你想修改的密码 = a.getString("输入你想修改的密码");}else{System.out.println("[箱子登入]：§c输入你想修改的密码置文件错误，请检查配置文件");}
        if(a.contains("取消修改密码1")){取消修改密码1 = a.getString("取消修改密码1");}else{System.out.println("[箱子登入]：§c取消修改密码1置文件错误，请检查配置文件");}
        if(a.contains("取消修改密码2")){取消修改密码2 = a.getString("取消修改密码2");}else{System.out.println("[箱子登入]：§c取消修改密码2配置文件错误，请检查配置文件");}
        if(a.contains("修改密码箱子标题")){修改密码箱子标题 = a.getString("修改密码箱子标题");}else{System.out.println("[箱子登入]：§c修改密码箱子标题配置文件错误，请检查配置文件");}
        if(a.contains("密码错误")){ 密码错误 = a.getString("密码错误");}else{System.out.println("[箱子登入]：§c密码错误配置文件错误，请检查配置文件");}
        if(a.contains("两次密码不一致")){两次密码不一致 = a.getString("两次密码不一致");}else{System.out.println("[箱子登入]：§c两次密码不一致配置文件错误，请检查配置文件");}
        if(a.contains("注册")){ 注册 = a.getString("注册");}else{ System.out.println("[箱子登入]：§c注册配置文件错误，请检查配置文件"); }
        if(a.contains("分割线")){ 分割线 = a.getString("分割线");}else{System.out.println("[箱子登入]：§c分割线配置文件错误，请检查配置文件"); }
        if(a.contains("登入")){ 登入 = a.getString("登入");}else{System.out.println("[箱子登入]：§c登入配置文件错误，请检查配置文件");}
        if(a.contains("确定")){ 确定 = a.getString("确定");}else{ System.out.println("[箱子登入]：§c确定配置文件错误，请检查配置文件");}
        if(a.contains("重复")){ 重复 = a.getString("重复");}else{System.out.println("[箱子登入]：§c重复配置文件错误，请检查配置文件");}
        if(a.contains("取消")){取消 = a.getString("取消");}else{ System.out.println("[箱子登入]：§c取消配置文件错误，请检查配置文件"); }
        if(a.contains("登入成功1")){  登入成功1 = a.getString("登入成功1");}else{ System.out.println("[箱子登入]：§c登入成功1配置文件错误，请检查配置文件"); }
        if(a.contains("登入成功2")){  登入成功2 = a.getString("登入成功2");}else{ System.out.println("[箱子登入]：§c登入成功2配置文件错误，请检查配置文件"); }
        if(a.contains("登入成功后台执行命令")){  登入成功后台执行命令 = a.getString("登入成功后台执行命令");}else{System.out.println("[箱子登入]：§c登入成功后台执行命令配置文件错误，请检查配置文件"); }
        if(a.contains("注册成功1")){ 注册成功1 = a.getString("注册成功1");}else{System.out.println("[箱子登入]：§c注册成功1配置文件错误，请检查配置文件");}
        if(a.contains("注册成功2")){ 注册成功2 = a.getString("注册成功2");}else{System.out.println("[箱子登入]：§c注册成功2配置文件错误，请检查配置文件");}
        if(a.contains("注册成功后台执行命令")){ 注册成功后台执行命令 = a.getString("注册成功后台执行命令");}else{System.out.println("[箱子登入]：§c注册成功后台执行命令配置文件错误，请检查配置文件"); }
        if(a.contains("登入超时踢出玩家提示消息")){ 登入超时踢出玩家提示消息 = a.getString("登入超时踢出玩家提示消息");}else{ System.out.println("[箱子登入]：§c登入超时踢出玩家提示消息配置文件错误，请检查配置文件"); }
        //list
       物品列表 = new ArrayList();
        //ItemStack
        try {  分割线物品 = new ItemStack(Material.getMaterial(a.getString("分割线物品")));}catch (Throwable ssss){ System.out.println("[箱子登入]：§c分割线物品配置文件错误，已替换为基岩，请检查配置文件");分割线物品 = new ItemStack(Material.BEDROCK);}
        try {  确定按钮物品 = new ItemStack(Material.getMaterial(a.getString("确定按钮物品")));}catch (Throwable ssss){ System.out.println("[箱子登入]：§c确定按钮物品配置文件错误，已替换为基岩，请检查配置文件"); 确定按钮物品 = new ItemStack(Material.BEDROCK);}
        try { 重新输入按钮物品 = new ItemStack(Material.getMaterial(a.getString("重新输入按钮物品")));}catch (Throwable ssss){ System.out.println("[箱子登入]：§c重新输入按钮物品配置文件错误，已替换为基岩，请检查配置文件"); 重新输入按钮物品 = new ItemStack(Material.BEDROCK);}
        //booble
        if(a.contains("同名大小不同禁止进入")){ 同名大小不同禁止进入=a.getBoolean("同名大小不同禁止进入");}else{System.out.println("[箱子登入]：§c同名大小不同禁止进入配置文件错误，请检查配置文件");}
        if(a.contains("名字限制")){ 名字限制=a.getBoolean("名字限制");}else{System.out.println("[箱子登入]：§c名字限制配置文件错误，请检查配置文件");}
        if(a.contains("bc模式")){ bc模式=a.getBoolean("bc模式");}else{System.out.println("[箱子登入]：§cbc模式配置文件错误，请检查配置文件");}
        if(a.contains("ip管理器")){ ip管理器=a.getBoolean("ip管理器");}else{System.out.println("[箱子登入]：§cip管理器配置文件错误，请检查配置文件");}
        if(a.contains("登入时旁观者模式")){ 登入时旁观者模式=a.getBoolean("登入时旁观者模式");}else{System.out.println("[箱子登入]：§c登入时旁观者模式配置文件错误，请检查配置文件");}
        if(a.contains("登入超时踢出玩家")){  登入超时踢出玩家=a.getBoolean("登入超时踢出玩家");}else{System.out.println("[箱子登入]：§c登入超时踢出玩家配置文件错误，请检查配置文件"); }
        if(a.contains("声音")){  声音=a.getBoolean("声音");}else{System.out.println("[箱子登入]：§c声音配置文件错误，请检查配置文件"); }
        //gamemode
        try {  服务器游戏模式 = GameMode.valueOf(a.getString("服务器游戏模式"));}catch (Throwable ssss){ System.out.println("[箱子登入]：§c服务器游戏模式配置文件错误已自动设置为生存，请检查配置文件"); 服务器游戏模式 = GameMode.SURVIVAL;}
        //int
        if(a.contains("最小长度")){  最小长度 = a.getInt("最小长度");}else{System.out.println("[箱子登入]：§c最小长度配置文件错误，请检查配置文件");}
        if(a.contains("最大长度")){  最大长度 = a.getInt("最大长度");}else{System.out.println("[箱子登入]：§c最大长度配置文件错误，请检查配置文件");}
        if(a.contains("登入超时时间")){  登入超时时间 = a.getInt("登入超时时间");}else{System.out.println("[箱子登入]：§c登入超时时间配置文件错误，请检查配置文件");}
        //list
        List wp = a.getStringList("选择物品");
        List mz = a.getStringList("名字");
        List lo = a.getList("lore");

        for(int i = 0;i<=35;i++){
            ItemStack WPD;
            try {
                WPD = new ItemStack(Material.getMaterial((String) wp.get(i)));
            }catch (Throwable ssss){
                WPD = new ItemStack(Material.BEDROCK);
                try {
                    System.out.println("[箱子登入]：§c第"+i+"个物品"+wp.get(i)+"错误已替换成基岩");
                }catch (Throwable sssss){
                    System.out.println("[箱子登入]：§c第"+i+"个物品NULL错误已替换成基岩");
                }
            }
            ItemMeta we = WPD.getItemMeta();
            try {
                we.setDisplayName((String) mz.get(i));
            }catch (Throwable ssss){
                System.out.println("[箱子登入]：§c第"+i+"个物品名字错误");
            }
            try {
                we.setLore((List<String>) lo.get(i));
            }catch (Throwable ssss){
                System.out.println("[箱子登入]：§c第"+i+"个物品lore错误");
            }
            WPD.setItemMeta(we);
            物品列表.add(WPD);
        }
        Bukkit.getLogger().info("[箱子登入X]:§a配置加载完成");
    }
}
