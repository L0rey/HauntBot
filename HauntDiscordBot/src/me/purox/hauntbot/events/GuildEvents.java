package me.purox.hauntbot.events;

import me.purox.hauntbot.utils.Logger;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.core.events.guild.member.GuildMemberRoleAddEvent;
import net.dv8tion.jda.core.events.guild.member.GuildMemberRoleRemoveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.List;

/**
 * Created by Daniel on 6/24/2017.
 */
public class GuildEvents extends ListenerAdapter{

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent e) {
        Guild guild = e.getGuild();
        Member member = e.getMember();
        String message = "Hello " + member.getUser().getName() + "! Welcome in HauntNetwork's official discord server.\n"
        + "I am the HauntBot and I will be your best friend on Haunt's discord server.\n"
        + "Do !help to get a list of all available commands! :)";
        PM(member.getUser(), guild, message);
    }

    @Override
    public void onGuildMemberRoleAdd(GuildMemberRoleAddEvent e) {
        Member member = e.getMember();
        Guild guild = e.getGuild();
        List<Role> roles = e.getRoles();

        String rolenames = "";
        for(Role role : roles) {
            rolenames += role.getName() + " ";
        }
        String message = "You've received a new role! ( " +  rolenames + ")";
        PM(member.getUser(), guild, message);

    }

    @Override
    public void onGuildMemberRoleRemove(GuildMemberRoleRemoveEvent e) {
        Member member = e.getMember();
        Guild guild = e.getGuild();
        List<Role> roles = e.getRoles();

        String rolenames = "";
        for(Role role : roles) {
            rolenames += role.getName() + " ";
        }

        String message = "One of your roles has been removed! ( " +  rolenames + ")";
        PM(member.getUser(), guild, message);
    }

    private void PM(User user, Guild guild, String message) {
        user.openPrivateChannel().queue();
        user.getPrivateChannel().sendMessage(message).queue(
                success -> {
                    Logger.getLogger().log("[PM] Bot -> " + user.getName() + " " + message);
                    return;
                },
                error -> {
                    guild.getOwner().getUser().openPrivateChannel();
                    guild.getOwner().getUser().getPrivateChannel().sendMessage("Could not message " + user.getName() + " in a private channel! ("+user.getName()+"'s ID: " + user.getId() +")").queue();
                    Logger.getLogger().log("Could not message " + user.getName() + "'s in a direct message! ("+user.getName()+"'s ID: " + user.getId() +")");
                    return;
                });
    }
}
