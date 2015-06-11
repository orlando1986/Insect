package com.catfish.insect.utils;

import java.util.Calendar;

/**
 * Created by Lucia&Orlando on 2015/6/10.
 */
public class Util {
    public static int generateRandom(int min, int max) {
        return (int) (min + Math.random() * (max - min + 1));
    }

    public static long fetchNextRoundTime() {
        long time = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        int hour = calendar.get(Calendar.HOUR);
        LOG.d("now time is " + hour);
        if (hour > 0 && hour < 8) {
            return -1;
        }
        long next = time + generateRandom(5, 60 * 60) * 1000;
        calendar.setTimeInMillis(next);
        hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        LOG.d("next time is " + hour + ":" + minute);
        return next;
    }

}
