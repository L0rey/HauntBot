package me.purox.hauntbot.commands;

import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;

/**
 * Created by Lorenzo on 24/06/2017.
 */
public class TeamspeakCMD {

    static TeamspeakCMD instance;

    public static TeamspeakCMD getInstance() {
        if(instance == null) {
            instance = new TeamspeakCMD();
        }
        return instance;
    }

    public void sendTeamsSpeakMessage(TextChannel channel, User user) {
        channel.sendMessage(user.getAsMention() + ", Our teamspeak IP is 'ts.hauntnetwork.eu'").queue();
    }
}
