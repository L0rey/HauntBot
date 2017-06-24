package me.purox.hauntbot.commands;

import me.purox.hauntbot.utils.Logger;
import net.dv8tion.jda.core.entities.MessageChannel;
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

    public void sendTeamsSpeakMessage(MessageChannel channel, User user) {

        if(channel == null) {
            Logger.getLogger().log("Tried to send a message to a null channel");
            return;
        }
        if (user == null) {
            Logger.getLogger().log("Tried to mention a null user");
            return;
        }
        channel.sendMessage(user.getAsMention() + ", Our teamspeak IP is 'ts.hauntnetwork.eu'").queue();
    }
}
