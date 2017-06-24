package me.purox.hauntbot.commands;

import me.purox.hauntbot.options.Secrets;
import me.purox.hauntbot.utils.Logger;
import net.dv8tion.jda.core.entities.*;

/**
 * Created by Lorenzo on 24/06/2017.
 */
public class UHCSeniorCMD {

    static UHCSeniorCMD instance;

    public static UHCSeniorCMD getInstance() {
        if (instance == null) {
            instance = new UHCSeniorCMD();
        }

        return instance;
    }

    public void sendUHCSeniorMessage(TextChannel channel, User user) {
        if (channel == null) {
            Logger.getLogger().log(" tried to send a message in a null channel ");
            return;
        }

        if (!channel.getId().equalsIgnoreCase("317742712390549504") && !channel.getId().equalsIgnoreCase(Secrets.TEST_CHANNEL_ID)) {
            Logger.getLogger().log(" Tried to use a forbidden channel for !uhcseniors");
            return;
        }

        if (user == null) {
            Logger.getLogger().log("Tried to mention a null user");
            return;
        }

        String uhcseniors = "";
        for (Member member : channel.getMembers()) {
            for (Role role : member.getRoles()) {
                if(role.getName().contains("UHC Seniors")) {
                    uhcseniors += member.getAsMention() + "";
                }
            }
        }

        if(uhcseniors != "") {
            channel.sendMessage(user.getName() + " is requesting help! Tagging eligible online UHCSeniors to help!").queue();
        } else {
            channel.sendMessage(user.getName() + " no available UHCStaff could be found ").queue();
        }
    }
}