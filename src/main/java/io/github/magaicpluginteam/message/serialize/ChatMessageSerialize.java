package io.github.magaicpluginteam.message.serialize;

import io.github.magaicpluginteam.message.ChatMessage;
import io.github.magicpluginteam.serialize.YamlSerialize;
import io.github.magicpluginteam.serialize.symbol.YamlSymbol;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

@YamlSymbol(symbol = "chat")
public class ChatMessageSerialize implements YamlSerialize<ChatMessage> {
    @Override
    public ChatMessage deserialize(ConfigurationSection conf) {
        return new ChatMessage(conf.getString("_"));
    }

    @Override
    public ConfigurationSection serialize(ChatMessage chatMessage) {
        YamlConfiguration section = new YamlConfiguration();
        section.set("_", chatMessage.message);
        return section;
    }
}
