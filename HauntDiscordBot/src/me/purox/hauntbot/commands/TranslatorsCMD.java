package me.purox.hauntbot.commands;

import me.purox.hauntbot.utils.Logger;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;


/**
 * Created by Daniel on 6/24/2017.
 */
public class TranslatorsCMD {

    static TranslatorsCMD instance;

    public static TranslatorsCMD getInstance() {
        if(instance == null) {
            instance = new TranslatorsCMD();
        }
        return instance;
    }

    public void sendTranslatorMSG(TextChannel channel, User user, String language) {
        if(channel == null) {
            Logger.getLogger().log("Tried to send a message to a null channel");
            return;
        }
        if (user == null) {
            Logger.getLogger().log("Tried to mention a null user");
            return;
        }
        if(language != "german" || language != "spanish" || language != "italian" || language != "french"){
            Logger.getLogger().log("A not valid language has been detected! ("+ language +")");
            channel.sendMessage(user.getAsMention() + ", '"+language+"' is not a valid language!").queue();
            return;
        }

        channel.sendMessage(user.getName() + " is requesting translation help in " + language.toUpperCase() + "! Tagging eligible online translators to help!").queue();


    }
}
