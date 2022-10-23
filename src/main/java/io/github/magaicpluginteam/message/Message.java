package io.github.magaicpluginteam.message;

import org.bukkit.entity.Player;

public interface Message {
    
    void send(Player player, Object...args);
    
}
