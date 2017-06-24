package me.purox.hauntbot.commands;

import me.purox.hauntbot.options.Secrets;
import me.purox.hauntbot.utils.Logger;
import net.dv8tion.jda.core.entities.*;


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
        if(!channel.getId().equalsIgnoreCase("317754878112038912") && !channel.getId().equalsIgnoreCase(Secrets.TEST_CHANNEL_ID)) {
            Logger.getLogger().log("Tried to use a forbidden channel for !translate!");
            return;
        }
        if(channel == null) {
            Logger.getLogger().log("Tried to send a message to a null channel");
            return;
        }
        if (user == null) {
            Logger.getLogger().log("Tried to mention a null user");
            return;
        }

        if (language == null){
            Logger.getLogger().log("Tried to use a null language");
            channel.sendMessage(user.getAsMention() + ", wrong usage! use !translate [language] to request translating help!").queue();
            return;
        }

        if(!language.equalsIgnoreCase("german")
                && !language.equalsIgnoreCase("italian")
                && !language.equalsIgnoreCase("spanish")
                && !language.equalsIgnoreCase("french")){
            Logger.getLogger().log("A not valid language has been detected! ("+ language +")");
            channel.sendMessage(user.getAsMention() + ", '"+language+"' is not a valid language!").queue();
            return;
        }

        String translators = "";
        for (Member member : channel.getMembers()) {
            for (Role role : member.getRoles()) {
                if(role.getName().equalsIgnoreCase("Translators")) {
                    translators += member.getAsMention() + " ";
                }
            }
        }
        if(translators != "") {
            channel.sendMessage(user.getName() + " is requesting translation help in " + language.toUpperCase() + "! Tagging eligible online translators to help! " + translators).queue();
        } else {
            channel.sendMessage(user.getAsMention() + ", no available translators could be found!").queue();
        }
    }
}
