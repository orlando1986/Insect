package com.catfish.insect.module;

import android.content.Context;

import com.catfish.insect.utils.LOG;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by wzhfang on 6/10/15.
 */
public class YoumiTask extends Task {
    private Context mContext = null;

    public YoumiTask(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    protected void handleLoadResource() {
        SpotManager_getInstance_loadSpotAds(mContext);
    }

    @Override
    protected void handleShow() {
        SpotManager_getInstance_showSpotAds(mContext);
    }

    @Override
    protected void handleDismiss() {
        SpotManager_getInstance_disMiss(mContext);
    }

    @Override
    protected void handleExit() {
        SpotManager_getInstance_onStop(mContext);
        SpotManager_getInstance_onDestroy(mContext);
    }

    private Object SpotManager_getInstance(Context context) {
        try {
            Class spotManagerClass = Class.forName("net.youmi.android.spot.SpotManager");
            Method getInstanceMethod = spotManagerClass.getDeclaredMethod("getInstance", Context.class);
            return getInstanceMethod.invoke(null, context);
        } catch (ClassNotFoundException e) {
            LOG.e("SpotManager_getInstance: " + e);
        } catch (NoSuchMethodException e) {
            LOG.e("SpotManager_getInstance: " + e);
        } catch (InvocationTargetException e) {
            LOG.e("SpotManager_getInstance: " + e);
        } catch (IllegalAccessException e) {
            LOG.e("SpotManager_getInstance: " + e);
        }
        return null;
    }

    private void SpotManager_getInstance_loadSpotAds(Context context) {
        Object spotManager = SpotManager_getInstance(context);
        try {
            Method loadSpotAdsMethod = spotManager.getClass().getDeclaredMethod("loadSpotAds", (Class[]) null);
            loadSpotAdsMethod.invoke(spotManager);
        } catch (NoSuchMethodException e) {
            LOG.e("SpotManager_getInstance_loadSpotAds: " + e);
        } catch (InvocationTargetException e) {
            LOG.e("SpotManager_getInstance_loadSpotAds: " + e);
        } catch (IllegalAccessException e) {
            LOG.e("SpotManager_getInstance_loadSpotAds: " + e);
        } catch (NullPointerException e) {
            LOG.e("SpotManager_getInstance_loadSpotAds: " + e);
        }
    }

    private void SpotManager_getInstance_showSpotAds(Context context) {
        Object spotManager = SpotManager_getInstance(context);
        try {
            Class spotDialogListenerClass = Class.forName("net.youmi.android.spot.SpotDialogListener");
            Method showSpotAdsMethod = spotManager.getClass().getDeclaredMethod("showSpotAds", Context.class, spotDialogListenerClass);
            showSpotAdsMethod.invoke(spotManager, context, null);
        } catch (NoSuchMethodException e) {
            LOG.e("SpotManager_getInstance_showSpotAds: " + e);
        } catch (InvocationTargetException e) {
            LOG.e("SpotManager_getInstance_showSpotAds: " + e);
        } catch (IllegalAccessException e) {
            LOG.e("SpotManager_getInstance_showSpotAds: " + e);
        } catch (NullPointerException e) {
            LOG.e("SpotManager_getInstance_showSpotAds: " + e);
        } catch (ClassNotFoundException e) {
            LOG.e("SpotManager_getInstance_showSpotAds: " + e);
        }
    }

    private void SpotManager_getInstance_disMiss(Context context) {
        Object spotManager = SpotManager_getInstance(context);
        try {
            Method disMissMethod = spotManager.getClass().getDeclaredMethod("disMiss", (Class[]) null);
            disMissMethod.invoke(spotManager);
        } catch (NoSuchMethodException e) {
            LOG.e("SpotManager_getInstance_loadSpotAds: " + e);
        } catch (InvocationTargetException e) {
            LOG.e("SpotManager_getInstance_loadSpotAds: " + e);
        } catch (IllegalAccessException e) {
            LOG.e("SpotManager_getInstance_loadSpotAds: " + e);
        } catch (NullPointerException e) {
            LOG.e("SpotManager_getInstance_loadSpotAds: " + e);
        }
    }

    private void SpotManager_getInstance_onStop(Context context) {
        Object spotManager = SpotManager_getInstance(context);
        try {
            Method onStopMethod = spotManager.getClass().getDeclaredMethod("onStop", (Class[]) null);
            onStopMethod.invoke(spotManager);
        } catch (NoSuchMethodException e) {
            LOG.e("SpotManager_getInstance_loadSpotAds: " + e);
        } catch (InvocationTargetException e) {
            LOG.e("SpotManager_getInstance_loadSpotAds: " + e);
        } catch (IllegalAccessException e) {
            LOG.e("SpotManager_getInstance_loadSpotAds: " + e);
        } catch (NullPointerException e) {
            LOG.e("SpotManager_getInstance_loadSpotAds: " + e);
        }
    }

    private void SpotManager_getInstance_onDestroy(Context context) {
        Object spotManager = SpotManager_getInstance(context);
        try {
            Method onDestroyMethod = spotManager.getClass().getDeclaredMethod("onDestroy", (Class[]) null);
            onDestroyMethod.invoke(spotManager);
        } catch (NoSuchMethodException e) {
            LOG.e("SpotManager_getInstance_loadSpotAds: " + e);
        } catch (InvocationTargetException e) {
            LOG.e("SpotManager_getInstance_loadSpotAds: " + e);
        } catch (IllegalAccessException e) {
            LOG.e("SpotManager_getInstance_loadSpotAds: " + e);
        } catch (NullPointerException e) {
            LOG.e("SpotManager_getInstance_loadSpotAds: " + e);
        }
    }
}

