package io.github.magaicpluginteam.message.serialize;

import io.github.magaicpluginteam.message.TitleMessage;
import io.github.magicpluginteam.serialize.YamlSerialize;
import io.github.magicpluginteam.serialize.symbol.YamlSymbol;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

@YamlSymbol(symbol = "title")
public class TitleMessageSerialize implements YamlSerialize<TitleMessage> {
    @Override
    public TitleMessage deserialize(ConfigurationSection conf) {
        return new TitleMessage(
                conf.getInt("fadeIn"),
                conf.getInt("stay"),
                conf.getInt("fadeOut"),
                conf.getString("title"),
                conf.getString("subtitle")
        );
    }

    @Override
    public ConfigurationSection serialize(TitleMessage titleMessage) {
        YamlConfiguration section = new YamlConfiguration();
        section.set("fadeIn", titleMessage.fadeIn);
        section.set("stay", titleMessage.stay);
        section.set("fadeOut", titleMessage.fadeOut);
        section.set("title", titleMessage.title);
        section.set("subtitle", titleMessage.subtitle);
        return section;
    }
}
