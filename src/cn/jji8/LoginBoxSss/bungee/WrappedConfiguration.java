package cn.jji8.LoginBoxSss.bungee;

import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WrappedConfiguration {
    String workdir;
    boolean verbose;
    WrappedConfiguration(){
        Main.main.getLogger().info("开始加载配置文件");
        Configuration config = null;
        File File = null;
        try {
            File = new File(Main.main.getDataFolder(), "config.yml");
            config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(File);
        } catch (IOException e) {
            Main.main.getDataFolder().mkdirs();
            try {
                FileWriter FileWriter = new FileWriter(File);
                FileWriter.close();
                Main.main.getLogger().info("配置文件创建成功！");
                config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(File);
            }catch (IOException g) {
                g.printStackTrace();
                Main.main.getLogger().warning("配置文件创建失败！");
            }

        }
        if(config.contains("workdir")){
            workdir = config.getString("workdir");
        }else {
            config.set("workdir","C:/工作路径");
            workdir = "C:/工作路径";
            try {
                ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, new File(Main.main.getDataFolder(), "config.yml"));
            } catch (IOException e) {
                e.printStackTrace();
                Main.main.getLogger().warning("配置文件保存异常！");
            }
        }
        if(config.contains("verbose")){
            verbose = config.getBoolean("verbose");
        }else {
            config.set("verbose",true);
            verbose = true;
            try {
                ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, new File(Main.main.getDataFolder(), "config.yml"));
            } catch (IOException e) {
                e.printStackTrace();
                Main.main.getLogger().warning("配置文件保存异常！");
            }
        }

        Main.main.getLogger().info("工作路径是："+ workdir);
        Main.main.getLogger().info("配置文件加载完成");
    }
}
