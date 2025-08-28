package org.marriosbot.bot;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;

final public class CommandDispatcher {
    private List<CommandInterface> commands;
    private Character commandPrefix = '!';

    public CommandDispatcher setCommandPrefix(Character prefix) {
        this.commandPrefix = prefix;
        return this;
    }

    public CommandDispatcher setCommands(List<CommandInterface> commands) {
        this.commands = commands;
        return this;
    }

    public void dispatch(MessageReceivedEvent event) {
        String msg = event.getMessage().getContentRaw();

        if(msg.charAt(0) != this.commandPrefix) {
            System.out.println( msg.substring(0, 1) + " NO COMMAND");
            return;
        }

        String commandId = msg.substring(1).split(" ")[0];

        System.out.println("COMANDO: " + commandId);

       commands.stream()
                .filter(cmd -> cmd.getId().equalsIgnoreCase(commandId))
                .findFirst()
                .ifPresent(cmd -> cmd.execute(event));
    }
}
