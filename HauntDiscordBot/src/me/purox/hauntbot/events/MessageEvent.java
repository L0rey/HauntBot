package me.purox.hauntbot.events;

import me.purox.hauntbot.commands.*;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * Created by Lorenzo on 24/06/2017.
 */
public class MessageEvent extends ListenerAdapter{

    public void onMessageReceived(MessageReceivedEvent e) {
        //Member member = e.getMember();
        User user = e.getAuthor();
        TextChannel channel = e.getTextChannel();

        String message = e.getMessage().getContent();

        String[] args = message.split(" ");
        String cmd = args[0].toLowerCase();
        switch (cmd) {
            case "!ts":
                TeamspeakCMD.getInstance().sendTeamsSpeakMessage(channel, user);
                break;
            case "!twitter":
                TwitterCMD.getInstance().sendTwitterMessage(channel, user);
                break;
            case "!forum":
                ForumCMD.getInstance().sendForumMessage(channel, user);
                break;
            case "!ip":
                MinecraftCMD.getInstance().sendMinecraftMessage(channel, user);
                break;
            case "!translate":
                String language;
                if(args.length == 1) {
                   language = null;
                } else {
                    language = args[1];
                }
                TranslatorsCMD.getInstance().sendTranslatorMSG(channel, user, language);
                break;
            case "!author":
                authorCMD.getInstance().sendauthorMessage(channel, user);
                break;
            default:
                break;
        }
    }
}
