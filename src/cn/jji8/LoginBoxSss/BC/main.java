package cn.jji8.LoginBoxSss.BC;

import net.md_5.bungee.api.plugin.Plugin;


public class main extends Plugin {
    public static main main;
    public static peizhi peizhi;
    @Override
    public void onEnable() {
        main = this;
        getLogger().info("启动！");
        peizhi = new peizhi();
    }
}
