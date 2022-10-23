package io.github.magaicpluginteam.message.serialize;

import io.github.magaicpluginteam.message.HoverMessage;
import io.github.magicpluginteam.serialize.YamlSerialize;
import io.github.magicpluginteam.serialize.symbol.YamlSymbol;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

@YamlSymbol(symbol = "hover")
public class HoverMessageSerialize implements YamlSerialize<HoverMessage> {
    @Override
    public HoverMessage deserialize(ConfigurationSection conf) {
        return new HoverMessage(
                conf.getString("text"),
                conf.getString("action"),
                conf.getString("content")
        );
    }

    @Override
    public ConfigurationSection serialize(HoverMessage hoverMessage) {
        YamlConfiguration section = new YamlConfiguration();
        section.set("text", hoverMessage.text);
        section.set("action", hoverMessage.action);
        section.set("content", hoverMessage.content);
        return section;
    }
}
