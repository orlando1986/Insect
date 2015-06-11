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
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        LOG.d("now time is " + hour);
        if (hour > 0 && hour < 7) {
            return 0;
        }
        long internal = generateRandom(5, 60 * 60) * 1000;
        calendar.setTimeInMillis(time + internal);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        LOG.d("next time is " + hour + ":" + minute);
        return internal;
    }

}
