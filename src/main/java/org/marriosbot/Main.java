package org.marriosbot;

import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.marriosbot.bot.CommandDispatcher;
import org.marriosbot.bot.CommandInterface;
import org.marriosbot.bot.Listener;
import org.marriosbot.command.aviso.AvisoCommand;
import org.marriosbot.command.ping.PingCommand;

import java.util.ArrayList;
import java.util.List;

public class Main extends ListenerAdapter {

    public static void main(String[] args) throws Exception {
        List<CommandInterface> commands = new ArrayList<>();
        commands.add(new PingCommand());
        commands.add(new AvisoCommand());

        CommandDispatcher commandDispatcher = new CommandDispatcher();

        commandDispatcher
            .setCommandPrefix('@')
            .setCommands(commands);

        Listener listener = new Listener(commandDispatcher);
        listener.start();
    }
}