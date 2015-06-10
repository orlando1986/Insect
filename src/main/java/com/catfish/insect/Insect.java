package com.catfish.insect;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.catfish.insect.module.Task;
import com.catfish.insect.module.YoumiTask;

import java.util.List;

/**
 * Created by wzhfang on 6/10/15.
 */
public class Insect extends Handler {
    private final static int MSG_START = 0;

    private static boolean isRunning = false;
    private List<Task> mTasks = Task.getTasks();
    private Context mContext = null;

    private Insect(Context context) {
        mContext = context;
    }

    public static void go(Context context) {
        if (!isRunning) {
            if (context == null) {
                throw new IllegalArgumentException("context can't be null");
            }
            initAllTasks(context);
            new Insect(context).sendEmptyMessage(MSG_START);
            isRunning = true;
        }
    }

    private static void initAllTasks(Context context) {
        // will be added to task list in constructor
        new YoumiTask(context);
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case MSG_START:
                break;

        }
    }
}