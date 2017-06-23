package me.purox.hauntbot.commands;

import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;

/**
 * Created by Lorenzo on 24/06/2017.
 */
public class ForumCMD {

    static ForumCMD instance;

    public static ForumCMD getInstance() { //alt+ENTER //alt+ENTER //alt+ENTER //alt+ENTER //alt+ENTER
        if(instance == null) {
            instance = new ForumCMD();
        }
        return instance;
    }

    public void sendForumMessage (TextChannel channel, User user) {
        channel.sendMessage(user.getAsMention() + "This is our Forums 'www.hauntnetwork.eu' ").queue();
    }

}
