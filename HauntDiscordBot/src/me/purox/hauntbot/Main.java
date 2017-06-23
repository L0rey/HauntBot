package me.purox.hauntbot;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;

public class Main {

    private static String TOKEN = "****************************************" ;

    public static void main(String[] Args) {
        JDABuilder builder = new JDABuilder(AccountType.BOT);

        builder.setToken(TOKEN);
        builder.setAutoReconnect(true);
        builder.setStatus(OnlineStatus.DO_NOT_DISTURB);
        builder.setGame(Game.of("@HauntNetwork"));

        try {
            builder.buildBlocking();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (RateLimitedException e) {
            e.printStackTrace();
        }
    }
}
