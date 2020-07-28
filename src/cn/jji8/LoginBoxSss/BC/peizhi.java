package cn.jji8.LoginBoxSss.BC;

import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class peizhi {
    String 工作路径;
    boolean 后台更多信息;
    peizhi(){
        main.main.getLogger().info("[箱子登入X]:开始加载配置文件");
        Configuration peizhi = null;
        File File = null;
        try {
            File = new File(main.main.getDataFolder(), "peizi.yml");
            peizhi = ConfigurationProvider.getProvider(YamlConfiguration.class).load(File);
        } catch (IOException e) {
            main.main.getDataFolder().mkdirs();
            try {
                FileWriter FileWriter = new FileWriter(File);
                FileWriter.close();
                main.main.getLogger().info("[箱子登入X]:配置文件创建成功！");
                peizhi = ConfigurationProvider.getProvider(YamlConfiguration.class).load(File);
            }catch (IOException g) {
                g.printStackTrace();
                main.main.getLogger().warning("[箱子登入X]:配置文件创建失败！");
            }

        }
        if(peizhi.contains("工作路径")){
            工作路径 = peizhi.getString("工作路径");
        }else {
            peizhi.set("工作路径","C:/工作路径");
            工作路径 = "C:/工作路径";
            try {
                ConfigurationProvider.getProvider(YamlConfiguration.class).save(peizhi, new File(main.main.getDataFolder(), "peizi.yml"));
            } catch (IOException e) {
                e.printStackTrace();
                main.main.getLogger().warning("配置文件保存异常！");
            }
        }
        if(peizhi.contains("后台更多信息")){
            后台更多信息 = peizhi.getBoolean("后台更多信息");
        }else {
            peizhi.set("后台更多信息",true);
            后台更多信息 = true;
            try {
                ConfigurationProvider.getProvider(YamlConfiguration.class).save(peizhi, new File(main.main.getDataFolder(), "peizi.yml"));
            } catch (IOException e) {
                e.printStackTrace();
                main.main.getLogger().warning("[箱子登入X]:配置文件保存异常！");
            }
        }
        main.main.getLogger().info("[箱子登入X]:工作路径是："+工作路径);
        main.main.getLogger().info("[箱子登入X]:配置文件加载完成");
    }
}
