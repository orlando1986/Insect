package com.catfish.insect;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.catfish.insect.module.Task;
import com.catfish.insect.module.YoumiTask;
import com.catfish.insect.utils.LOG;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wzhfang on 6/10/15.
 */
public class Insect extends Handler {
    private final static int MSG_START = 0;
    private final static int MSG_REAL_RUN = 1;

    private static boolean isRunning = false;
    private static List<Task> sTasks = new ArrayList<Task>();

    private Insect() {
    }

    public static void go(Context context) {
        if (!isRunning) {
            if (context == null) {
                throw new IllegalArgumentException("context can't be null");
            }
            initAllTasks(context);
            new Insect().sendEmptyMessage(MSG_START);
            isRunning = true;
        }
    }

    private static void initAllTasks(Context context) {
        sTasks.add(new YoumiTask(context));
    }

    private Task pickOneTask() {
        // need to check whether a task is running, don't use for now
        Task task = sTasks.get(0);
        if (!task.isRunning()) {
            return task;
        }
        return null;
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case MSG_START:
                handleStart();
                break;
            case MSG_REAL_RUN:
                handleRealRun((Task) msg.obj);
                sendEmptyMessageDelayed(MSG_START, 20 * 1000);// trigger another ad show
                break;
        }
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