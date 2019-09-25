package com.lance.dotaalarmclock.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import com.lance.dotaalarmclock.presentation.ui.activities.PuzzleActivity;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

/**
 * Created by User on 10/9/2017.
 */

public class AlarmService extends IntentService {
    public static final String TAG = "AlarmService";
    public static final int NOTIFICATION_ALARM_ID = 1;

    public AlarmService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d(TAG, TAG + ": onHandle");
        Intent puzzleActivityIntent = new Intent(this, PuzzleActivity.class);
        puzzleActivityIntent.setFlags(FLAG_ACTIVITY_NEW_TASK);
        startActivity(puzzleActivityIntent);
        AlarmReceiver.completeWakefulIntent(intent);
    }

}
