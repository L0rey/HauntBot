package me.purox.hauntbot.commands;

import me.purox.hauntbot.utils.Logger;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;

/**
 * Created by Lorenzo on 24/06/2017.
 */
public class MinecraftCMD {

    static MinecraftCMD instance;

    public static MinecraftCMD getInstance() { //geti

        if (instance == null) {
            instance = new MinecraftCMD();
        }

        return instance;
    }

    public void sendMinecraftMessage(MessageChannel channel, User user) {
        if(channel == null) {
            Logger.getLogger().log("Tried to send a message to a null channel");
            return;
        }
        if (user == null) {
            Logger.getLogger().log("Tried to mention a null user");
            return;
        }

        channel.sendMessage(user.getAsMention() + "This is our Server IP 'mc.hauntnetwork.eu' ").queue();
    }

}

