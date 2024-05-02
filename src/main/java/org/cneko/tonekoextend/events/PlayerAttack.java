package org.cneko.tonekoextend.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.cneko.tonekoextend.api.PortBall;

import static org.cneko.tonekoextend.ToNekoExtend.getMessage;

public class PlayerAttack implements Listener {
    public static void init(){

    }
    @EventHandler
    public void onPlayerAttack(EntityDamageByEntityEvent event){
        if (event.getEntity() instanceof Player neko && event.getDamager() instanceof Player attacker) {
            ItemStack item = attacker.getInventory().getItemInMainHand();
            if(item.getType() == Material.END_ROD){
                if (PortBall.getStatus(neko.getName())) {
                    attacker.sendMessage(getMessage("toneko_extend.portball.out"));
                    PortBall.setStatus(neko.getName(), false);
                } else {
                    attacker.sendMessage(getMessage("toneko_extend.portball.in"));
                    PortBall.setStatus(neko.getName(), true);
                }
            }
        }
    }
}
