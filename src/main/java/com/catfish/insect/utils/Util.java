package com.catfish.insect.utils;

/**
 * Created by Lucia&Orlando on 2015/6/10.
 */
public class Util {
    public static int generateRandom(int min, int max) {
        return (int) (min + Math.random() * (max - min + 1));
    }
}
