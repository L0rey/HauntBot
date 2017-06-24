package me.purox.hauntbot.events;

import me.purox.hauntbot.commands.*;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * Created by Lorenzo on 24/06/2017.
 */
public class MessageEvent {

    public void onMessageReceivedEvent(MessageReceivedEvent e) {
        Member member = e.getMember();
        User user = e.getAuthor();
        TextChannel channel = e.getTextChannel();

        String prefix = "!";

        String message = e.getMessage().getContent();

        String[] args = message.split(" ");

        switch (prefix + args[0]) {
            case "ts":
                TeamspeakCMD.getInstance().sendTeamsSpeakMessage(channel, user);
                break;
            case "twitter":
                TwitterCMD.getInstance().sendTwitterMessage(channel, user);
                break;
            case "forum":
                ForumCMD.getInstance().sendForumMessage(channel, user);
                break;
            case "ip":
                MinecraftCMD.getInstance().sendMinecraftMessage(channel, user);
                break;
            case "translate":
                String language = args[1];
                TranslatorsCMD.getInstance().sendTranslatorMSG(channel, user, language);
                break;
            default:
                break;
        }
    }
}
