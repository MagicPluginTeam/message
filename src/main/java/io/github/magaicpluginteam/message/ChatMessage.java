package io.github.magaicpluginteam.message;

import org.bukkit.entity.Player;

public class ChatMessage implements Message {

    public String message;

    public ChatMessage(String message) {
        this.message = message;
    }

    @Override
    public void send(Player player, Object...args) {
        player.sendMessage(String.format(message, args));
    }

}
