package me.purox.hauntbot.commands;

import me.purox.hauntbot.utils.Logger;
import me.purox.hauntbot.utils.MessageUtils;
import net.dv8tion.jda.core.entities.*;

import java.util.List;

/**
 * Created by Daniel on 6/24/2017.
 */
public class HelpCMD {

    static HelpCMD instance;

    public static HelpCMD getInstance() {
        if(instance == null) {
            instance = new HelpCMD();
        }
        return instance;
    }

    public void sendHelpMessage(MessageChannel channel, Member member) {
        List<Guild> mutalguilds = member.getUser().getMutualGuilds();
        Guild guild = mutalguilds.get(0);

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("**Haunt Bot Commands**\n");
        stringBuilder.append("```");
        stringBuilder.append("!Author       : Bot creators\n");
        stringBuilder.append("!Forum        : Our Forums\n");
        stringBuilder.append("!Ts           : Our teamspeak 3 server\n");
        stringBuilder.append("!Twitter      : Our Twitter page\n");
        stringBuilder.append("!IP           : Our Minecraft Server IP");
        stringBuilder.append("```");

        String message = stringBuilder.toString();



        if(channel.getType() == ChannelType.PRIVATE) {
            channel.sendMessage(message).queue();
        } else {
            MessageUtils.getInstance().PM(member.getUser(), guild, message);
            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            if(MessageUtils.getInstance().ERROR == "002"){
                                channel.sendMessage(member.getUser().getAsMention() + ", check your DM's!").queue();
                            } else if (MessageUtils.getInstance().ERROR == "001"){
                                channel.sendMessage(member.getUser().getAsMention() + ", I couldn't DM you due to insufficient Permissions ;(").queue();
                            }
                        }
                    },
                    250
            );
        }
    }

}
