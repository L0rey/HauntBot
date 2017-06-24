package me.purox.hauntbot.commands;

import me.purox.hauntbot.options.Secrets;
import me.purox.hauntbot.utils.Logger;
import net.dv8tion.jda.core.entities.*;

/**
 * Created by Lorenzo on 24/06/2017.
 */
public class MinigamesStaffCMD {

    static MinigamesStaffCMD instance;

    public static MinigamesStaffCMD getInstance() {
        if(instance == null) {
            instance = new MinigamesStaffCMD();
        }
        return instance;
    }

    public void sendMinigamesStaffMessage (TextChannel channel, User user) {
        if(channel == null) {
            Logger.getLogger().log(" tried to send a message in a null channel ");
            return;
        }

        if (!channel.getId().equalsIgnoreCase("319509836855246858") && !channel.getId().equalsIgnoreCase(Secrets.TEST_CHANNEL_ID)) {
            Logger.getLogger().log(" Tried to use a forbidden channel for !minigamestaff");
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

        String minigamesstaff = "";
        for (Member member : channel.getMembers()) {
            for (Role role : member.getRoles()) {
                if(role.getName().contains("Minigames")) {
                    minigamesstaff += member.getAsMention() + " ";
                }
            }
        }

        if(allow){
            if(minigamesstaff != "") {
                channel.sendMessage(user.getName() + " is requesting help! Tagging eligible online Minigames Staff to help! " + minigamesstaff).queue();
            } else {
                channel.sendMessage(user.getAsMention() + ", no available Minigames Staff could be found ").queue();
            }
        }
    }
}

