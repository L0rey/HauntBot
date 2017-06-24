package me.purox.hauntbot.commands;

import me.purox.hauntbot.utils.Logger;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;

/**
 * Created by Lorenzo on 24/06/2017.
 */
public class authorCMD {

    static authorCMD instance;

    public static authorCMD getInstance() {
        if(instance == null) {
            instance = new authorCMD();
        }
        return instance;
    }

    public void sendauthorMessage (TextChannel channel, User user) {
        if(channel == null) {
            Logger.getLogger().log("Tried to send a message to a null channel");
            return;
        }
        if (user == null) {
            Logger.getLogger().log("Tried to mention a null user");
            return;
        }
        channel.sendMessage(user.getAsMention() + "The HauntBot is coded by '@RealPurox' and '@I0rey' check them on twitter! ").queue();
    }

}
