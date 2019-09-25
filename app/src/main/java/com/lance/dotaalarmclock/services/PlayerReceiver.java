package com.lance.dotaalarmclock.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

/**
 * Created by Corwin on 10.01.2018.
 */

public class PlayerReceiver extends WakefulBroadcastReceiver {
    public static final String TAG = "BroadcastReceiver";
    public static final String BROADCAST_PLAYER = "com.lance.dotaalarmclock.broadcast_player";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, TAG + ": onReceive()");
        ComponentName comp = new ComponentName(context.getPackageName(),
                PlayerService.class.getName());
        intent.setComponent(comp);
        startWakefulService(context, intent);
    }
}
