package io.github.magaicpluginteam.message;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class ActionBarMessage implements Message {

    public String message;

    public ActionBarMessage(String message) {
        this.message = message;
    }

    @Override
    public void send(Player player, Object...args) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(String.format(message, args)));
    }

}
