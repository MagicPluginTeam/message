package io.github.magaicpluginteam.message.serialize;

import io.github.magaicpluginteam.message.ActionBarMessage;
import io.github.magicpluginteam.serialize.YamlSerialize;
import io.github.magicpluginteam.serialize.symbol.YamlSymbol;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

@YamlSymbol(symbol = "actionbar")
public class ActionBarMessageSerialize implements YamlSerialize<ActionBarMessage> {
    @Override
    public ActionBarMessage deserialize(ConfigurationSection conf) {
        return new ActionBarMessage(conf.getString("_"));
    }

    @Override
    public ConfigurationSection serialize(ActionBarMessage actionBarMessage) {
        YamlConfiguration section = new YamlConfiguration();
        section.set("_", actionBarMessage.message);
        return section;
    }
}
