package org.marriosbot.bot;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public interface CommandInterface {
    String getId();
    MessageReceivedEvent execute(MessageReceivedEvent event);
}
