package me.purox.hauntbot.commands;

import me.purox.hauntbot.events.MessageEvent;
import me.purox.hauntbot.options.Secrets;
import me.purox.hauntbot.utils.Logger;
import net.dv8tion.jda.core.entities.*;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.Queue;

/**
 * Created by Lorenzo on 24/06/2017.
 */
public class UHCStaffCMD {

    static UHCStaffCMD instace;

    public static UHCStaffCMD getInstance() {

        if(instace == null) {
            instace = new UHCStaffCMD();
        }
        return instace;
    }

    public void sendUHCStaffMessage (TextChannel channel, User user) {

        if (channel == null) {
            Logger.getLogger().log("tried to send a message in a null channel");
            return;
        }

        if (!channel.getId().equalsIgnoreCase("317742712390549504") && !channel.getId().equalsIgnoreCase(Secrets.TEST_CHANNEL_ID)) {
            Logger.getLogger().log("Tried to use a forbidden channel for !devs");
            return;
        }

        if (user == null) {
            Logger.getLogger().log("Tried to mention a null user");
            return;
        }

        Guild guild = channel.getGuild();
        String[] ID = new String[]{"UHC Seniors", "UHC Managers", "Admins", "Owners", "God"};
        Member Member = guild.getMemberById(user.getId());

        boolean allow = false;
        for (Role r : Member.getRoles()){
            for(String s : ID) {
                if(r.getName().toLowerCase().equals(s.toLowerCase())) {
                    allow = true;
                }
            }
        }

        String uhcstaff = "";
        for (Member member : channel.getMembers()) {
            for (Role role : member.getRoles()) {
                if(role.getName().contains("UHC")) {
                    uhcstaff += member.getAsMention() + " ";
                }
            }
        }

        if(allow) {
            if (uhcstaff != "") {
                channel.sendMessage(user.getName() + " is requesting help! Tagging eligible online UHC Staffs to help! " + uhcstaff).queue();
            } else {
                channel.sendMessage(user.getAsMention() + ", no available UHCStaff could be found").queue();
            }
        }
    }

}
