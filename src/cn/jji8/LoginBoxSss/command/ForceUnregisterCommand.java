package cn.jji8.LoginBoxSss.command;

import cn.jji8.LoginBoxSss.login.LoginManager;
import cn.jji8.LoginBoxSss.login.util.WrappedPlayer;
import cn.jji8.LoginBoxSss.login.controller.Register;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getPlayer;

public class ForceUnregisterCommand implements CommandExecutor {//修改密码
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        String name;
        try {
            name = args[0];
        }catch (Throwable a){
            sender.sendMessage("请输入玩家");
            return true;
        }
        Player p = getPlayer(name);
        if(p==null){
            sender.sendMessage("玩家名字错误");
            return true;
        }
        LoginManager.openChestForPlayer(new WrappedPlayer(p,new Register(p)));
        return true;
    }
}
