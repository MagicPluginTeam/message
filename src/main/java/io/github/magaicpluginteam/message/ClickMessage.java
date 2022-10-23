package io.github.magaicpluginteam.message;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class ClickMessage extends EventMessageBase {

    public ClickEvent.Action action;
    public String content;

    public ClickMessage(String text, ClickEvent.Action action, String content) {
        super(text);
        this.action = action;
        this.content = content;
    }

    public ClickMessage(String text, String action, String content) {
        super(text);
        try {
            this.action = ClickEvent.Action.valueOf(action);
        } catch (Exception e) {
            throw new AssertionError(action + " is not valid");
        }
        this.content = content;
    }

    public String getAction() {
        return this.action.name();
    }


    @Override
    public void event(TextComponent component, Object...args) {
        component.setClickEvent(new ClickEvent(action, String.format(content, args)));
    }
}
