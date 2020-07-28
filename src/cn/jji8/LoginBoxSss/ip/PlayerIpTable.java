package cn.jji8.LoginBoxSss.ip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PlayerIpTable {
    private final HashMap<String, List<String>> ipTable;
    private final List<String> playerNameList;

    PlayerIpTable(){
        ipTable = new HashMap<>();
        playerNameList = new ArrayList<>();
    }
    public void add(String ip,String playerName){
        if(ipTable.containsKey(ip)){
            List<String> playerList = ipTable.get(ip);
            playerList.add(playerName);
        }else {
            List<String> playerList = new ArrayList<>();
            playerList.add(playerName);
            ipTable.put(ip,playerList);
        }
        playerNameList.add(playerName);
    }
    public void remove(String ip, String playerName){
        if(ipTable.containsKey(ip)){
            List<String> playerNameList = ipTable.get(ip);
            playerNameList.remove(playerName);
        }
    }
    public boolean checkPlayerAmountOnIp(String ip, int bz){
        if(getPlayerAmountOfIp(ip)<bz){
            return false;
        }
        return true;
    }
    public int getPlayerAmountOfIp(String ip){
        if(ipTable.containsKey(ip)){
            List<String> playerNameList = ipTable.get(ip);
            return playerNameList.size();
        }
        return 0;
    }
}
