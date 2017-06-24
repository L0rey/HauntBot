package me.purox.hauntbot.events;

import me.purox.hauntbot.utils.Logger;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * Created by Daniel on 6/24/2017.
 */
public class GuildEvents extends ListenerAdapter{

    public void onGuildMemberJoin(GuildMemberJoinEvent e) {
        System.out.println(1);
        Guild guild = e.getGuild();
        Member member = e.getMember();
        member.getUser().openPrivateChannel().queue();
        member.getUser().getPrivateChannel().sendMessage("Hello " + member.getUser().getName() + "! Welcome in HauntNetwork's official discord server.\nI am the HauntBot and I will be your best friend on Haunt's discord server.\nDo !help to get a list of all available commands! :)").queue(
                success -> {
                  return;
                },
                error -> {
                    guild.getOwner().getUser().openPrivateChannel();
                    guild.getOwner().getUser().getPrivateChannel().sendMessage("Could not message " + member.getUser().getName() + " in a private channel! ("+member.getUser().getName()+"'s ID: " + member.getUser().getId() +")").queue();
                    Logger.getLogger().log("Could not message " + member.getUser().getName() + "'s in a direct message! ("+member.getUser().getName()+"'s ID: " + member.getUser().getId() +")");
                    return;
                }
        );
    }
}
