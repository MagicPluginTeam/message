package io.github.magaicpluginteam.message.serialize;

import io.github.magaicpluginteam.message.Message;
import io.github.magicpluginteam.serialize.symbol.SerializableYamlSymbol;
import io.github.magicpluginteam.serialize.symbol.YamlSymbol;

@YamlSymbol(symbol = "messages")
public class SerializableMessage extends SerializableYamlSymbol<Message> {

    public SerializableMessage() {
        super(
                ActionBarMessageSerialize.class,
                ChatMessageSerialize.class,
                ClickMessageSerialize.class,
                HoverMessageSerialize.class,
                SoundMessageSerialize.class,
                TitleMessageSerialize.class
        );
    }
}
