package com.lance.dotaalarmclock.presentation.presenters;

import android.content.Context;
import android.view.View;

import com.lance.dotaalarmclock.presentation.presenters.base.Presenter;

/**
 * Created by Corwin on 15.01.2018.
 */

public interface MainPresenter extends Presenter<MainPresenter.MainView> {
    String ALARM_TIME = "alarmTime";
    String ALARM_HOUR = "alarmHour";
    String ALARM_MINUTE = "alarmMinute";

    void onAlarmTriggered(int alarmHour, int alarmMinute);
    void onAlarmCancelled();

    boolean isAlarmSet();

    interface MainView {
        void onAlarmStopped();

        Context getContext();
        void onStartAlarmClicked(View view);
        void onCancelAlarmClicked(View view);

        void onAlarmStarted();
    }
}
