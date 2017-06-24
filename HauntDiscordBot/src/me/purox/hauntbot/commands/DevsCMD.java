package me.purox.hauntbot.commands;

import me.purox.hauntbot.options.Secrets;
import me.purox.hauntbot.utils.Logger;
import net.dv8tion.jda.core.entities.*;

/**
 * Created by Daniel on 6/24/2017.
 */
public class DevsCMD {

    static DevsCMD instance;

    public static DevsCMD getInstance() {
        if(instance == null) {
            instance = new DevsCMD();
        }
        return instance;
    }

    public void sendDevsMessage(TextChannel channel, User user) {
        if(channel == null) {
            Logger.getLogger().log("Tried to send a message to a null channel");
            return;
        }

        if(!channel.getId().equalsIgnoreCase("317745778217058306") && !channel.getId().equalsIgnoreCase(Secrets.TEST_CHANNEL_ID)) {
            Logger.getLogger().log("Tried to use a forbidden channel for !devs");
            return;
        }

        if (user == null) {
            Logger.getLogger().log("Tried to mention a null user");
            return;
        }

        String devs = "";
        for (Member member : channel.getMembers()) {
            for (Role role : member.getRoles()) {
                if(role.getName().equalsIgnoreCase("Developers")) {
                    devs += member.getAsMention() + " ";
                }
            }
        }

        if(devs != "") {
            channel.sendMessage(user.getName() + " is requesting help! Tagging eligible online devs to help! " + devs).queue();
        } else {
            channel.sendMessage(user.getAsMention() + ", no available devs could be found!").queue();
        }

    }
}
