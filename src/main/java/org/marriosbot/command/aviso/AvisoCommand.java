package org.marriosbot.command.aviso;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.marriosbot.bot.CommandInterface;

import java.awt.*;


public class AvisoCommand implements CommandInterface {
    private String ID = "aviso";

    public String getId() {
        return this.ID;
    }

    @Override
    public MessageReceivedEvent execute(MessageReceivedEvent event) {
        EmbedBuilder eb = new EmbedBuilder().
                setTitle("⚠️ Aviso")
                .setDescription("Estais avisado!")
                .setColor(Color.GREEN)
                .setImage("https://cdn.discordapp.com/attachments/1392164635783987202/1404922569475489882/Video_sem_titulo_Feito_com_o_Clipchamp.gif?ex=68b0115a&is=68aebfda&hm=fa535ec349368f128b3e8b1473f396c5763393bb9e7b7760977f3180c344a553&"); // link da imagem
        event.getChannel().sendMessageEmbeds(eb.build()).queue();

        return event;
    }
}
