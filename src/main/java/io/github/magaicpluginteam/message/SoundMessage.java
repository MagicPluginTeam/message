package io.github.magaicpluginteam.message;

import org.bukkit.entity.Player;

public class SoundMessage implements Message {


    public String sound;

    public SoundMessage(String sound) {
        this.sound = sound;
    }

    @Override
    public void send(Player player, Object... args) {
        player.playSound(player.getLocation(), sound, 1f, 1f);
    }
}
