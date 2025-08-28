package org.marriosbot.bot;

import io.github.cdimascio.dotenv.Dotenv;

public class BotConfig {
    private static final Dotenv dotenv = Dotenv.load();
    public static final String TOKEN = dotenv.get("BOT_TOKEN");
}