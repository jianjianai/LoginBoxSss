package cn.jji8.LoginBoxSss.ml;


import cn.jji8.LoginBoxSss.kongziqi.duixiang.kongziqi.xiugaimima;
import cn.jji8.LoginBoxSss.kongziqi.duixiang.wanjia;
import cn.jji8.LoginBoxSss.kongziqi.wanjiasezi;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class xgmm implements CommandExecutor{//修改密码
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)){
            commandSender.sendMessage("此命令只有玩家可以使用");
            return true;
        }
        wanjiasezi.setwanjieweidenru(new wanjia((Player) commandSender,new xiugaimima((Player) commandSender)));
        return true;
    }
}
