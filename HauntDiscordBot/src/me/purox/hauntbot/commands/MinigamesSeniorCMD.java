package me.purox.hauntbot.commands;

import me.purox.hauntbot.options.Secrets;
import me.purox.hauntbot.utils.Logger;
import net.dv8tion.jda.core.entities.*;

/**
 * Created by Lorenzo on 24/06/2017.
 */
public class MinigamesSeniorCMD {

    static MinigamesSeniorCMD instance;

    public static MinigamesSeniorCMD getInstance() {
        if(instance == null) {
            instance = new MinigamesSeniorCMD();
        }
        return instance;
    }

    public void sendMinigamesSeniorMessage(TextChannel channel, User user) {
        if (channel == null) {
            Logger.getLogger().log(" tried to send a message in a null channel ");
            return;
        }

        if (!channel.getId().equalsIgnoreCase("317745370916585475") && !channel.getId().equalsIgnoreCase(Secrets.TEST_CHANNEL_ID)) {
            Logger.getLogger().log(" Tried to use a forbidden channel for !minigamesseniors");
            return;
        }

        if (user == null) {
            Logger.getLogger().log("Tried to mention a null user");
            return;
        }

        Guild guild = channel.getGuild();
        String[] ID = new String[]{"Minigames Staff", "Minigames Seniors", "Minigames Managers", "Admins", "Owners", "God"};
        Member Member = guild.getMemberById(user.getId());


        boolean allow = false;
        for (Role r : Member.getRoles()){
            for(String s : ID) {
                if(r.getName().toLowerCase().equals(s.toLowerCase())) {
                    allow = true;
                }
            }
        }

        String minigamessenior = "";
        for (Member member : channel.getMembers()) {
            for (Role role : member.getRoles()) {
                if(role.getName().contains("Minigames Seniors")) {
                    minigamessenior += member.getAsMention() + " ";
                }
            }
        }

        if(allow){
            if(minigamessenior != "") {
                channel.sendMessage(user.getName() + " is requesting help! Tagging eligible online Minigames Seniors to help! " + minigamessenior).queue();
            } else {
                channel.sendMessage(user.getAsMention() + ", no available Minigames Seniors could be found ").queue();
            }
        }
    }
}

