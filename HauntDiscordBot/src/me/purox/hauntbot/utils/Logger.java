package me.purox.hauntbot.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Daniel on 6/24/2017.
 */
public class Logger {

    static Logger logger;

    public static Logger getLogger() {
        if(logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    public void log(String string) {
        SimpleDateFormat format = new SimpleDateFormat("DD-MM-YYYY HH:mm:ss:SSSSS");
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        System.out.println("[" + format.format(new Date()) + "] [Logger] " + string);
    }
}
