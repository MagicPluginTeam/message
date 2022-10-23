package io.github.magaicpluginteam.message;

import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class HoverMessage extends EventMessageBase {

    public HoverEvent.Action action;
    public String content;

    public HoverMessage(String text, HoverEvent.Action action, String content) {
        super(text);
        this.action = action;
        this.content = content;
    }

    public HoverMessage(String text, String action, String content) {
        super(text);
        try {
            this.action = HoverEvent.Action.valueOf(action);
        } catch (Exception e) {
            throw new AssertionError(action + " is not valid");
        }
        this.content = content;
    }

    @Override
    public void event(TextComponent component, Object...args) {

        component.setHoverEvent(new HoverEvent(action, new ComponentBuilder(String.format(content, args)).create()));
    }
}
