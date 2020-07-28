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

public class WrappedConfiguration {

    public int timeout;

    public String loginMessage;
    public String timeOutMessage;
    public String registerMessage;
    public String repeatMessage;
    public String wrongPassword;
    public String notSamePassword;
    public String cancel;
    public String loginSuccess1;
    public String loginSuccess2;
    public String commandAfterLogin;
    public String registerSuccess1;
    public String registerSuccess2;
    public String commandAfterRegisteration;
    public String changePasswordTitle;
    public String passwordChangeSuccessfully1;
    public String passwordChangeSuccessfully2;

    public String splitLine;
    public String confirm;
    public String cancelPasswordChanging1;
    public String cancelPasswordChanging2;
    public String changePasswordMessage;
    public String workDir;


    public List<ItemStack> itemList;

    public boolean spectatorBeforeLogin;
    public boolean ipManager;
    public boolean playSound;
    public boolean kickPlayerOnTimeout;
    public boolean bungeeMode;

    public GameMode serverGameMode;

    public ItemStack splitItem;
    public ItemStack confirmButton;
    public ItemStack reinputButton;

    @SuppressWarnings("unchecked")
    public WrappedConfiguration(){
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(new File(Main.main.getDataFolder(), "config.yml"));
        Bukkit.getLogger().info("[箱子登入X]:§a开始加载配置");
        //string
        if(yamlConfiguration.contains("workdir")){ workDir = yamlConfiguration.getString("workdir");}else{System.out.println("[箱子登入]：§c工作路径置文件错误，请检查配置文件");}
        if(yamlConfiguration.contains("passwordChangeSuccessfully1")){ passwordChangeSuccessfully1 = yamlConfiguration.getString("passwordChangeSuccessfully1");}else{System.out.println("[箱子登入]：§c修改成功1置文件错误，请检查配置文件");}
        if(yamlConfiguration.contains("passwordChangeSuccessfully2")){ passwordChangeSuccessfully2 = yamlConfiguration.getString("passwordChangeSuccessfully2");}else{System.out.println("[箱子登入]：§c修改成功2置文件错误，请检查配置文件");}
        if(yamlConfiguration.contains("changePasswordMessage")){ changePasswordMessage = yamlConfiguration.getString("changePasswordMessage");}else{System.out.println("[箱子登入]：§c输入你想修改的密码置文件错误，请检查配置文件");}
        if(yamlConfiguration.contains("cancelPasswordChanging1")){
            cancelPasswordChanging1 = yamlConfiguration.getString("cancelPasswordChanging1");}else{System.out.println("[箱子登入]：§c取消修改密码1置文件错误，请检查配置文件");}
        if(yamlConfiguration.contains("cancelPasswordChanging2")){
            cancelPasswordChanging2 = yamlConfiguration.getString("cancelPasswordChanging2");}else{System.out.println("[箱子登入]：§c取消修改密码2配置文件错误，请检查配置文件");}
        if(yamlConfiguration.contains("changePasswordTitle")){
            changePasswordTitle = yamlConfiguration.getString("changePasswordTitle");}else{System.out.println("[箱子登入]：§c修改密码箱子标题配置文件错误，请检查配置文件");}
        if(yamlConfiguration.contains("wrongPassword")){ wrongPassword = yamlConfiguration.getString("wrongPassword");}else{System.out.println("[箱子登入]：§c密码错误配置文件错误，请检查配置文件");}
        if(yamlConfiguration.contains("notSamePassword")){
            notSamePassword = yamlConfiguration.getString("notSamePassword");}else{System.out.println("[箱子登入]：§c两次密码不一致配置文件错误，请检查配置文件");}
        if(yamlConfiguration.contains("registerMessage")){ registerMessage = yamlConfiguration.getString("registerMessage");}else{ System.out.println("[箱子登入]：§c注册配置文件错误，请检查配置文件"); }
        if(yamlConfiguration.contains("splitLine")){ splitLine = yamlConfiguration.getString("splitLine");}else{System.out.println("[箱子登入]：§c分割线配置文件错误，请检查配置文件"); }
        if(yamlConfiguration.contains("loginMessage")){ loginMessage = yamlConfiguration.getString("loginMessage");}else{System.out.println("[箱子登入]：§c登入配置文件错误，请检查配置文件");}
        if(yamlConfiguration.contains("confirm")){ confirm = yamlConfiguration.getString("confirm");}else{ System.out.println("[箱子登入]：§c确定配置文件错误，请检查配置文件");}
        if(yamlConfiguration.contains("repeatMessage")){ repeatMessage = yamlConfiguration.getString("repeatMessage");}else{System.out.println("[箱子登入]：§c重复配置文件错误，请检查配置文件");}
        if(yamlConfiguration.contains("cancel")){
            cancel = yamlConfiguration.getString("cancel");}else{ System.out.println("[箱子登入]：§c取消配置文件错误，请检查配置文件"); }
        if(yamlConfiguration.contains("loginSuccess1")){  loginSuccess1 = yamlConfiguration.getString("loginSuccess1");}else{ System.out.println("[箱子登入]：§c登入成功1配置文件错误，请检查配置文件"); }
        if(yamlConfiguration.contains("loginSuccess2")){  loginSuccess2 = yamlConfiguration.getString("loginSuccess2");}else{ System.out.println("[箱子登入]：§c登入成功2配置文件错误，请检查配置文件"); }
        if(yamlConfiguration.contains("commandAfterLogin")){  commandAfterLogin = yamlConfiguration.getString("commandAfterLogin");}else{System.out.println("[箱子登入]：§c登入成功后台执行命令配置文件错误，请检查配置文件"); }
        if(yamlConfiguration.contains("registerSuccess1")){ registerSuccess1 = yamlConfiguration.getString("registerSuccess1");}else{System.out.println("[箱子登入]：§c注册成功1配置文件错误，请检查配置文件");}
        if(yamlConfiguration.contains("registerSuccess2")){ registerSuccess2 = yamlConfiguration.getString("registerSuccess2");}else{System.out.println("[箱子登入]：§c注册成功2配置文件错误，请检查配置文件");}
        if(yamlConfiguration.contains("commandAfterRegisteration")){ commandAfterRegisteration = yamlConfiguration.getString("commandAfterRegisteration");}else{System.out.println("[箱子登入]：§c注册成功后台执行命令配置文件错误，请检查配置文件"); }
        if(yamlConfiguration.contains("timeOutMessage")){ timeOutMessage = yamlConfiguration.getString("timeOutMessage");}else{ System.out.println("[箱子登入]：§c登入超时踢出玩家提示消息配置文件错误，请检查配置文件"); }
        //list
       itemList = new ArrayList<>();
        //ItemStack
        try {  splitItem = new ItemStack(Material.getMaterial(yamlConfiguration.getString("splitItem")));}catch (Throwable ssss){ System.out.println("[箱子登入]：§c分割线物品配置文件错误，已替换为基岩，请检查配置文件");
            splitItem = new ItemStack(Material.BEDROCK);}
        try {  confirmButton = new ItemStack(Material.getMaterial(yamlConfiguration.getString("confirmButton")));}catch (Throwable ssss){ System.out.println("[箱子登入]：§c确定按钮物品配置文件错误，已替换为基岩，请检查配置文件"); confirmButton = new ItemStack(Material.BEDROCK);}
        try { reinputButton = new ItemStack(Material.getMaterial(yamlConfiguration.getString("reinputButton")));}catch (Throwable ssss){ System.out.println("[箱子登入]：§c重新输入按钮物品配置文件错误，已替换为基岩，请检查配置文件"); reinputButton = new ItemStack(Material.BEDROCK);}
        //booble
        if(yamlConfiguration.contains("bungeeMode")){ bungeeMode =yamlConfiguration.getBoolean("bungeeMode");}else{System.out.println("[箱子登入]：§cipbc模式配置文件错误，请检查配置文件");}
        if(yamlConfiguration.contains("ipManager")){ ipManager =yamlConfiguration.getBoolean("ipManager");}else{System.out.println("[箱子登入]：§cip管理器配置文件错误，请检查配置文件");}
        if(yamlConfiguration.contains("spectatorBeforeLogin")){ spectatorBeforeLogin =yamlConfiguration.getBoolean("spectatorBeforeLogin");}else{System.out.println("[箱子登入]：§c登入时旁观者模式配置文件错误，请检查配置文件");}
        if(yamlConfiguration.contains("kickPlayerOnTimeout")){  kickPlayerOnTimeout =yamlConfiguration.getBoolean("kickPlayerOnTimeout");}else{System.out.println("[箱子登入]：§c登入超时踢出玩家配置文件错误，请检查配置文件"); }
        if(yamlConfiguration.contains("playSound")){  playSound =yamlConfiguration.getBoolean("playSound");}else{System.out.println("[箱子登入]：§c声音配置文件错误，请检查配置文件"); }
        //gamemode
        try {  serverGameMode = GameMode.valueOf(yamlConfiguration.getString("serverGameMode"));}catch (Throwable ssss){ System.out.println("[箱子登入]：§c服务器游戏模式配置文件错误已自动设置为生存，请检查配置文件"); serverGameMode = GameMode.SURVIVAL;}
        //int
        if(yamlConfiguration.contains("timeout")){  timeout = yamlConfiguration.getInt("timeout");}else{System.out.println("[箱子登入]：§c登入超时时间配置文件错误，请检查配置文件");}
        //list
        List<String> items = yamlConfiguration.getStringList("选择物品");
        List<String> names = yamlConfiguration.getStringList("名字");
        List<List<String>> lores = (List<List<String>>) yamlConfiguration.getList("lore");

        for(int i = 0;i<=35;i++){
            ItemStack itemStack;
            try {
                itemStack = new ItemStack(Material.getMaterial(items.get(i)));
            }catch (Throwable t){
                itemStack = new ItemStack(Material.BEDROCK);
                try {
                    System.out.println("[箱子登入]：§c第"+i+"个物品"+items.get(i)+"错误已替换成基岩");
                }catch (Throwable sssss){
                    System.out.println("[箱子登入]：§c第"+i+"个物品NULL错误已替换成基岩");
                }
            }
            ItemMeta im = itemStack.getItemMeta();
            if (im == null) {
                im = Bukkit.getItemFactory().getItemMeta(itemStack.getType());
            }

            try {
                im.setDisplayName(names.get(i));
            }catch (Throwable ssss){
                System.out.println("[箱子登入]：§c第"+i+"个物品名字错误");
            }
            try {
                im.setLore(lores != null ? lores.get(i) : new ArrayList<>());
            }catch (Throwable ssss){
                System.out.println("[箱子登入]：§c第"+i+"个物品lore错误");
            }
            itemStack.setItemMeta(im);
            itemList.add(itemStack);
        }
        Bukkit.getLogger().info("[箱子登入X]:§a配置加载完成");
    }
}
