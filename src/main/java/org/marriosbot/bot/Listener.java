package org.marriosbot.bot;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;


public class Listener extends ListenerAdapter {
    public CommandDispatcher commandDispatcher;

    public Listener(CommandDispatcher commandDispatcher){
        this.commandDispatcher = commandDispatcher;
    }

    public void start() {
        String token = BotConfig.TOKEN;

        JDABuilder
            .createDefault(token, GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT)
            .addEventListeners(new Listener(this.commandDispatcher))
            .setActivity(Activity.playing("eh sim famia"))
            .build();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        this.commandDispatcher.dispatch(event);
    }
}