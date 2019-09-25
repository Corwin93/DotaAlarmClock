package com.lance.dotaalarmclock.presentation.presenters.impl;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.lance.dotaalarmclock.App;
import com.lance.dotaalarmclock.R;
import com.lance.dotaalarmclock.domain.executor.Executor;
import com.lance.dotaalarmclock.domain.executor.MainThread;
import com.lance.dotaalarmclock.presentation.presenters.MainPresenter;
import com.lance.dotaalarmclock.presentation.presenters.base.AbstractPresenter;
import com.lance.dotaalarmclock.presentation.ui.activities.PuzzleActivity;
import com.lance.dotaalarmclock.services.AlarmReceiver;
import com.lance.dotaalarmclock.services.AlarmService;
import com.lance.dotaalarmclock.services.PlayerService;

import java.util.Calendar;

import javax.inject.Inject;

import static android.content.Context.ALARM_SERVICE;

/**
 * Created by Corwin on 15.01.2018.
 */

public class MainPresenterImpl extends AbstractPresenter implements MainPresenter {
    private static final String TAG = "MainPresenterImpl";

    private MainView mMainView;
    @Inject
    public Context mAppContext;
    private AlarmManager mAlarmManager;
    private PendingIntent mAlarmPending;
    private boolean alarmSet = false;

    public MainPresenterImpl(Executor executor, MainThread mainThread) {
        super(executor, mainThread);
        App.getComponent().inject(this);
    }

    @Override
    public void bindView(MainView view) {
        Log.d(TAG, "bindView(MainView view)");
        mMainView = view;
        PendingIntent pi = PendingIntent.getBroadcast(mMainView.getContext(), 0,
                new Intent(mMainView.getContext(), AlarmReceiver.class),
                PendingIntent.FLAG_NO_CREATE);
        if (pi != null) {
            alarmSet = true;
        }
//        if (isMyServiceRunning(AlarmService.class)) {
//            alarmSet = true;
//        }
    }

    @Override
    public void unbindView() {
        Log.d(TAG, "unbindView()");
        mMainView = null;
    }

    @Override
    public boolean isBinded() {
        Log.d(TAG, "isBinded()");
        return mMainView != null;
    }

    @Override
    public void resume() {
        Log.d(TAG, "resume()");
        if (isMyServiceRunning(PlayerService.class)) {
            alarmSet = false;
            mMainView.getContext().startActivity(new Intent(mMainView.getContext(), PuzzleActivity.class));
        }
    }

    @Override
    public void pause() {
        Log.d(TAG, "pause()");
    }

    @Override
    public void stop() {
        Log.d(TAG, "stop()");
    }

    @Override
    public void destroy() {
        Log.d(TAG, "destroy()");
    }

    @Override
    public void onError(String message) {
        Log.d(TAG, "onError(String message)");
    }

    @Override
    public void onAlarmTriggered(int alarmHour, int alarmMinute) {
        Log.d(TAG, "onAlarmTriggered(int alarmHour, int alarmMinute)");
        final long TWENTY_FOUR_HOURS = 86400000;
        mAlarmManager = (AlarmManager) mMainView.getContext().getSystemService(ALARM_SERVICE);
        Intent alarmIntent = new Intent(mMainView.getContext(), AlarmReceiver.class);
        mAlarmPending = PendingIntent.getBroadcast(mMainView.getContext(), 0, alarmIntent, 0);
        Calendar now = Calendar.getInstance();
        Calendar alarmTime = Calendar.getInstance();
        alarmTime.set(Calendar.HOUR_OF_DAY, alarmHour);
        alarmTime.set(Calendar.MINUTE, alarmMinute);
        mMainView.getContext().getSharedPreferences(ALARM_TIME, Context.MODE_PRIVATE)
                .edit().putInt(ALARM_HOUR, alarmHour).apply();
        mMainView.getContext().getSharedPreferences(ALARM_TIME, Context.MODE_PRIVATE)
                .edit().putInt(ALARM_MINUTE, alarmMinute).apply();
        if (alarmHour < now.get(Calendar.HOUR_OF_DAY) ||
                (alarmHour == now.get(Calendar.HOUR_OF_DAY) && alarmMinute <= now.get(Calendar.MINUTE))) {
            alarmTime.setTimeInMillis(alarmTime.getTimeInMillis() + TWENTY_FOUR_HOURS);
        }
        Log.d(TAG, "Alarm alarmHour = " + alarmHour);
        Log.d(TAG, "Alarm minute = " + alarmMinute);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            mAlarmManager.setExact(AlarmManager.RTC_WAKEUP, alarmTime.getTimeInMillis(), mAlarmPending);
        } else {
            mAlarmManager.set(AlarmManager.RTC_WAKEUP, alarmTime.getTimeInMillis(), mAlarmPending);
        }
//        mAlarmManager.set(AlarmManager.RTC_WAKEUP, Calendar.getInstance().getTimeInMillis()+15000, mAlarmPending);
        alarmSet = true;
        showNotification(alarmHour, alarmMinute);
        mMainView.onAlarmStarted();
    }

    @SuppressWarnings("StringBufferReplaceableByString")
    private void showNotification(int alarmHour, int alarmMinute) {
         StringBuilder stringBuilder = new StringBuilder().append(alarmHour)
                .append(':');
        if (alarmMinute < 10) {
            stringBuilder.append(0);
        }
        stringBuilder.append(alarmMinute);
        String alarmTime = stringBuilder.toString();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(mAppContext)
                .setSmallIcon(R.drawable.ic_notification_alarm)
                .setLargeIcon(BitmapFactory.decodeResource(mAppContext.getResources(), R.mipmap.ic_launcher_round))
                .setContentTitle(mAppContext.getString(R.string.alarm_set))
                .setContentText(alarmTime)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setAutoCancel(false)
                .setOngoing(true);
        Intent resultIntent = new Intent(mAppContext, mMainView.getClass());
        PendingIntent resultPendingIntent = PendingIntent.getActivity(mAppContext,
                AlarmService.NOTIFICATION_ALARM_ID, resultIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(resultPendingIntent);
        NotificationManager manager = (NotificationManager) mAppContext
                .getSystemService(Context.NOTIFICATION_SERVICE);
        if (manager != null) {
            manager.notify(AlarmService.NOTIFICATION_ALARM_ID, builder.build());
        }
    }

    private void dismissNotification() {
        NotificationManager manager = (NotificationManager) mAppContext
                .getSystemService(Context.NOTIFICATION_SERVICE);
        if (manager != null) {
            manager.cancel(AlarmService.NOTIFICATION_ALARM_ID);
        }
    }

    @Override
    public void onAlarmCancelled() {
        Log.d(TAG, "onAlarmCancelled()");
        PendingIntent pi = PendingIntent.getBroadcast(mMainView.getContext(), 0,
                new Intent(mMainView.getContext(), AlarmReceiver.class),
                PendingIntent.FLAG_NO_CREATE);
        if (pi != null) {
            if (mMainView.getContext().getSystemService(ALARM_SERVICE) != null) {
                ((AlarmManager)mMainView.getContext().getSystemService(ALARM_SERVICE)).cancel(pi);
                pi.cancel();
            }
        }
        dismissNotification();
        mAlarmPending = null;
        alarmSet = false;
        mMainView.onAlarmStopped();
    }

    @Override
    public boolean isAlarmSet() {
        Log.d(TAG, "isAlarmSet()");
        return alarmSet;
    }

    private boolean isMyServiceRunning(Class<?> serviceClass) {
        Log.d(TAG, "isMyServiceRunning(Class<?> serviceClass)");
        ActivityManager manager = (ActivityManager) mMainView.getContext().getSystemService(Context.ACTIVITY_SERVICE);
        if (manager != null) {
            for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
                if (serviceClass.getName().equals(service.service.getClassName())) {
                    return true;
                }
            }
        }
        return false;
    }
}
