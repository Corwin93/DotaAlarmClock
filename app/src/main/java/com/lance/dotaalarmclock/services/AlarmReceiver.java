package com.lance.dotaalarmclock.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

/**
 * Created by User on 10/15/2017.
 */

public class AlarmReceiver extends WakefulBroadcastReceiver {
    public static final String TAG = "AlarmReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, TAG + ": onReceive()");
        ComponentName comp = new ComponentName(context.getPackageName(),
                AlarmService.class.getName());
        intent.setComponent(comp);
        startWakefulService(context, intent);
    }
}
