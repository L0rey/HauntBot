package me.purox.hauntbot.commands;

import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;

/**
 * Created by Lorenzo on 24/06/2017.
 */
public class MinecraftCMD {

    static MinecraftCMD instance;

    public static MinecraftCMD getInstance() { //geti

        if(instance == null) {
            instance = new MinecraftCMD();
        }

        return instance;
    }

    public void sendMinecraftMessage (TextChannel channel, User user) {
        channel.sendMessage(user.getAsMention() + "This is our Server IP 'mc.hauntnetwork.eu' ").queue();
    }

