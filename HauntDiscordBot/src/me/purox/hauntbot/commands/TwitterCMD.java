package me.purox.hauntbot.commands;

import me.purox.hauntbot.utils.Logger;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;

/**
 * Created by Lorenzo on 24/06/2017.
 */
public class TwitterCMD {

    static TwitterCMD instance;

    public static TwitterCMD getInstance() {
        if(instance == null) {
            instance = new TwitterCMD();
        }
        return instance;
    }

    public void sendTwitterMessage(TextChannel channel, User user) {

        if(channel == null) {
            Logger.getLogger().log("Tried to send a message to a null channel");
            return;
        }
        if (user == null) {
            Logger.getLogger().log("Tried to mention a null user");
            return;
        }

        channel.sendMessage(user.getAsMention() + ", Our twitter name is '@HauntNetwork'").queue();
    }
}
