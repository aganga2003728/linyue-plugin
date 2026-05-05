package com.example;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.HashMap;
import java.util.UUID;

public class Main extends JavaPlugin implements Listener {
    private final HashMap<UUID, Integer> steps = new HashMap<>();
    
    @Override public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }
    
    @EventHandler public void onJoin(PlayerJoinEvent e) {
        steps.put(e.getPlayer().getUniqueId(), 0);
        e.getPlayer().sendMessage("欢迎！");
    }
    
    @EventHandler public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if (e.getFrom().getBlockX() != e.getTo().getBlockX() || 
            e.getFrom().getBlockZ() != e.getTo().getBlockZ()) {
            UUID id = p.getUniqueId();
            int s = steps.getOrDefault(id, 0) + 1;
            steps.put(id, s);
            if (s % 5 == 0) p.sendMessage("§6琳悦yyds");
        }
    }
}
