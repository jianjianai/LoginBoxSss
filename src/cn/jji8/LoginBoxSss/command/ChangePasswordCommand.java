package cn.jji8.LoginBoxSss.command;


import cn.jji8.LoginBoxSss.login.controller.ChangePassword;
import cn.jji8.LoginBoxSss.login.util.WrappedPlayer;
import cn.jji8.LoginBoxSss.login.LoginManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChangePasswordCommand implements CommandExecutor{//修改密码
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(!(commandSender instanceof Player)){
            commandSender.sendMessage("此命令只有玩家可以使用");
            return true;
        }
        LoginManager.openChestForPlayer(new WrappedPlayer((Player) commandSender,new ChangePassword((Player) commandSender)));
        return true;
    }
}
