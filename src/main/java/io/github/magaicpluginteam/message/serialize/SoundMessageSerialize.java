package io.github.magaicpluginteam.message.serialize;

import io.github.magaicpluginteam.message.SoundMessage;
import io.github.magicpluginteam.serialize.YamlSerialize;
import io.github.magicpluginteam.serialize.symbol.YamlSymbol;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

@YamlSymbol(symbol = "sound")
public class SoundMessageSerialize implements YamlSerialize<SoundMessage> {
    @Override
    public SoundMessage deserialize(ConfigurationSection conf) {
        return new SoundMessage(conf.getString("_"));
    }

    @Override
    public ConfigurationSection serialize(SoundMessage chatAlert) {
        YamlConfiguration section = new YamlConfiguration();
        section.set("_", chatAlert.sound);
        return section;
    }
}
