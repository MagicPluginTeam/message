package io.github.magaicpluginteam.message;

import io.github.magaicpluginteam.message.utils.ArrayUtils;
import org.bukkit.entity.Player;

public class TitleMessage implements Message {

    public  int fadeIn;
    public int stay;
    public int fadeOut;
    public String title;
    public String subtitle;

    public TitleMessage(int fadeIn, int stay, int fadeOut, String title, String subtitle) {
        this.fadeIn = fadeIn;
        this.stay = stay;
        this.fadeOut = fadeOut;
        this.title = title;
        this.subtitle = subtitle;
    }

    @Override
    public void send(Player player, Object... args) {
        Object[] reversed = ArrayUtils.reverse(args);
        player.sendTitle(String.format(title, args), String.format(subtitle, reversed), fadeIn, stay, fadeOut);
    }
}
