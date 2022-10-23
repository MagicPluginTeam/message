package io.github.magaicpluginteam.message;

import io.github.magaicpluginteam.message.utils.ArrayUtils;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class EventMessageBase implements EventMessage {

    public String text;

    public EventMessageBase(String text) {
        this.text = text;
    }

    @Override
    public void send(Player player, Object... args) {
        TextComponent component = new TextComponent(String.format(text, args));
        Object[] reversed = ArrayUtils.reverse(args);
        event(component, reversed);
        player.spigot().sendMessage(component);
    }

    @Override
    public void event(TextComponent component, Object... args) {

    }
}
