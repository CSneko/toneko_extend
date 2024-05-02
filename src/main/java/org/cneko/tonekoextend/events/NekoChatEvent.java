package org.cneko.tonekoextend.events;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.cneko.ctlib.common.util.ChatPrefix;
import org.cneko.tonekoextend.ToNekoExtend;
import org.cneko.tonekoextend.api.PortBall;

import java.io.File;
import java.util.Random;

import static com.crystalneko.toneko.api.events.ChatEvents.OnChat;
import static org.bukkit.Bukkit.getServer;
import static org.cneko.tonekoextend.ToNekoExtend.getMessage;
public class NekoChatEvent implements Listener {
    public static void init(){
        getServer().getPluginManager().registerEvents(new NekoChatEvent(), ToNekoExtend.instance);
    }
    @EventHandler
    public void onNekoChat(OnChat event){
        Player player = event.getPlayer();
        String name = player.getName();
        if(PortBall.getStatus(name)){
            event.setCancelled(true);
        }else{
            return;
        }
        //TODO 在toneko添加configAPI
        Plugin toneko = Bukkit.getPluginManager().getPlugin("toNeko");
        FileConfiguration tonekoConfig = toneko.getConfig();
        // 获取占位符
        String prefix = ChatPrefix.getAllPublicPrefixValues() + ChatPrefix.getPrivatePrefix(name);
        String msg = tonekoConfig.getString("chat.format");
        msg = msg.replace("${prefix}",prefix);
        msg = msg.replace("${player}",name);
        // 随机获取替换消息
        int random = new Random().nextInt(4);
        msg = msg.replace("${msg}",getMessage("toneko_extend.chat.portball."+random));
        for(Player p : Bukkit.getOnlinePlayers()){
            p.sendMessage(msg);
        }
    }
}
