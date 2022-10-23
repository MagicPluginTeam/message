package io.github.magaicpluginteam.message.serialize;

import io.github.magaicpluginteam.message.ClickMessage;
import io.github.magicpluginteam.serialize.YamlSerialize;
import io.github.magicpluginteam.serialize.symbol.YamlSymbol;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

@YamlSymbol(symbol = "click")
public class ClickMessageSerialize implements YamlSerialize<ClickMessage> {
    @Override
    public ClickMessage deserialize(ConfigurationSection conf) {
        return new ClickMessage(
                conf.getString("text"),
                conf.getString("action"),
                conf.getString("content")
        );
    }

    @Override
    public ConfigurationSection serialize(ClickMessage clickMessage) {
        YamlConfiguration section = new YamlConfiguration();
        section.set("text", clickMessage.text);
        section.set("action", clickMessage.action);
        section.set("content", clickMessage.content);
        return section;
    }
}
