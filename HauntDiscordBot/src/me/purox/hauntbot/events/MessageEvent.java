package me.purox.hauntbot.events;

import me.purox.hauntbot.commands.*;
import me.purox.hauntbot.utils.Logger;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * Created by Lorenzo on 24/06/2017.
 */
public class MessageEvent extends ListenerAdapter{

    @Override
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
            case "!devs":
                DevsCMD.getInstance().sendDevsMessage(channel, user);
                break;
            case "!uhcstaff":
                UHCStaffCMD.getInstance().sendUHCStaffMessage(channel, user);
                break;
            case "!uhcseniors":
                UHCSeniorCMD.getInstance().sendUHCSeniorMessage(channel, user);
                break;
            case "!minigamesseniors":
                MinigamesSeniorCMD.getInstance().sendMinigamesSeniorMessage(channel, user);
                break;
            case "!minigamesstaff":
                MinigamesStaffCMD.getInstance().sendMinigamesStaffMessage(channel, user);
                break;
            default:
                break;

        }

        if(e.getChannelType() == ChannelType.PRIVATE) {
            if(!e.getAuthor().isBot()) {
                Logger.getLogger().log("[PM] " + user.getName() + " -> Bot " + message);
            }
        }
    }
}
