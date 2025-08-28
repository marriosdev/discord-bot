package org.marriosbot.command.ping;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.marriosbot.command.CommandInterface;

public class PingCommand implements CommandInterface {

    private String ID = "ping";

    @Override
    public String getId() {
        return this.ID;
    }

    @Override
    public MessageReceivedEvent execute(MessageReceivedEvent event) {
        event.getChannel().sendMessage("Pong! 🏓").queue();
        return event;
    }
}
