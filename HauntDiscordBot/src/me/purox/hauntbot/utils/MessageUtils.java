package me.purox.hauntbot.utils;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;

/**
 * Created by Daniel on 6/24/2017.
 */
public class MessageUtils {

    static MessageUtils instance;

    public static MessageUtils getInstance() {
        if(instance == null) {
            instance = new MessageUtils();
        }
        return instance;
    }

    public String ERROR = "000";

    public void PM(User user, Guild guild, String message) {
        user.openPrivateChannel().queue();
        user.getPrivateChannel().sendMessage(message).queue(
                success -> {
                    Logger.getLogger().log("[PM] Bot -> " + user.getName() + " " + message);
                    ERROR = "002";
                    return;
                },
                error -> {
                    guild.getOwner().getUser().openPrivateChannel();
                    guild.getOwner().getUser().getPrivateChannel().sendMessage("Could not message " + user.getName() + " in a private channel! ("+user.getName()+"'s ID: " + user.getId() +")").queue();
                    Logger.getLogger().log("Could not message " + user.getName() + "'s in a direct message! ("+user.getName()+"'s ID: " + user.getId() +")");
                    ERROR = "001";
                    return;
                });
    }
}
