package com.catfish.insect.module;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.catfish.insect.utils.LOG;
import com.catfish.insect.utils.Util;

/**
 * Created by wzhfang on 6/10/15.
 */
public class Task extends Handler {
    private static final int MSG_START = 0;
    private static final int MSG_LOAD_RESOURCE = 1;
    private static final int MSG_SHOW_ADS = 2;
    private static final int MSG_EXIT_ADS = 3;
    private static final int MSG_STOP_DESTROY = 4;

    protected Context mContext = null;
    private boolean isRunning = false;

    public Task(Context context) {
        mContext = context;
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case MSG_START:
            case MSG_LOAD_RESOURCE:
                isRunning = true;
                LOG.d("Task load resource");
                handleLoadResource();
                sendEmptyMessageDelayed(MSG_SHOW_ADS, 5000);
                break;
            case MSG_SHOW_ADS:
                LOG.d("Task show ad");
                handleShow();
                sendEmptyMessageDelayed(MSG_EXIT_ADS, Util.generateRandom(3000, 5000));
                break;
            case MSG_EXIT_ADS:
                LOG.d("Task exit ad");
                handleDismiss();
                sendEmptyMessageDelayed(MSG_STOP_DESTROY, Util.generateRandom(1000, 2000));
                break;
            case MSG_STOP_DESTROY:
                LOG.d("Task exit ad");
                handleExit();
                isRunning = false;
                break;
        }
    }

    protected void handleLoadResource() {
    }

    protected void handleShow() {
    }

    protected void handleDismiss() {
    }

    protected void handleExit() {
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void start() {
        sendEmptyMessage(MSG_START);
    }
}
