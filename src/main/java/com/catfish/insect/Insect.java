package com.catfish.insect;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.catfish.insect.module.Task;
import com.catfish.insect.module.YoumiTask;
import com.catfish.insect.utils.LOG;
import com.catfish.insect.utils.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wzhfang on 6/10/15.
 */
public class Insect extends Handler {
    private final static int MSG_START = 0;
    private final static int MSG_REAL_RUN = 1;

    private static List<Task> sTasks = new ArrayList<Task>();
    private static Insect sInsect = null;

    private Insect() {
    }

    public static void go(Context context) {
        if (sInsect == null) {
            if (context == null) {
                throw new IllegalArgumentException("context can't be null");
            }
            initAllTasks(context);
            sInsect = new Insect();
        }
        if (!sInsect.hasMessages(MSG_START) && !sInsect.hasMessages(MSG_REAL_RUN)) {
            sInsect.sendEmptyMessage(MSG_START);
        }
    }

    private static void initAllTasks(Context context) {
        sTasks.add(new YoumiTask(context));
    }

    public static void halt() {
        LOG.d("Insect stop");
        if (sInsect == null) {
            LOG.d("insect has not been init yet, please invoke go() first");
        } else {
            sInsect.removeMessages(MSG_START);
            sInsect.removeMessages(MSG_REAL_RUN);
        }
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case MSG_START:
                handleStart();
                break;
            case MSG_REAL_RUN:
                handleRealRun((Task) msg.obj);
                long nextTime = Util.fetchNextRoundTime();
                if (nextTime == 0) {
                    LOG.d("see you tomorrow");
                    sendEmptyMessageDelayed(MSG_START, 8 * 60 * 60 * 1000);
                }// trigger the ad show next day
                sendEmptyMessageDelayed(MSG_START, nextTime);
                break;
        }
    }

    private Task pickOneTask() {
        // need to check whether a task is running, don't use for now
        Task task = sTasks.get(Util.generateRandom(0, sTasks.size() - 1));
        if (!task.isRunning()) {
            return task;
        }
        return null;
    }

    private void handleStart() {
        LOG.d("Insect start");
        Task task = pickOneTask();
        if (task != null) {
            // got a valid task, run it
            sendMessage(Message.obtain(this, MSG_REAL_RUN, task));
        } else {
            // no valid task to use, re-start lately
            sendEmptyMessageDelayed(MSG_START, 20 * 1000);
        }
    }

    private void handleRealRun(Task task) {
        LOG.d("Insect real run");
        task.start();
    }
}