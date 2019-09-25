package com.lance.dotaalarmclock.presentation.ui.activities;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.core.CrashlyticsCore;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lance.dotaalarmclock.BuildConfig;
import com.lance.dotaalarmclock.R;
import com.lance.dotaalarmclock.presentation.presenters.MainPresenter;
import com.lance.dotaalarmclock.presentation.presenters.impl.MainPresenterImpl;
import com.lance.dotaalarmclock.presentation.presenters.persistence.PresenterCache;
import com.lance.dotaalarmclock.presentation.presenters.persistence.factories.impl.MainPresenterFactory;
import com.vansuita.materialabout.builder.AboutBuilder;
import com.vansuita.materialabout.views.AboutView;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity implements MainPresenter.MainView {
    public static final String TAG = "MainActivity";

    private Button btnStartAlarm;
    private Button btnCancelAlarm;
    private TimePicker timePicker;
    private TextView tvAlarmTime;
    private int alarmHour;
    private int alarmMinute;
    private MainPresenter mPresenter;
    private MainPresenterFactory mMainPresenterFactory = new MainPresenterFactory();
    private FirebaseAnalytics mFirebaseAnalytics;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle savedInstanceState)");
        setContentView(R.layout.activity_main);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        CrashlyticsCore core = new CrashlyticsCore.Builder().disabled(BuildConfig.DEBUG).build();
        Crashlytics kit = new Crashlytics.Builder().core(core).build();
        Fabric.with(this, kit);
        MobileAds.initialize(this, getString(R.string.admob_app_id));
        linking();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()");
        mPresenter = PresenterCache.getInstance().getPresenter(MainPresenterImpl.class.getName(), mMainPresenterFactory);
        mPresenter.bindView(this);
        if (DateFormat.is24HourFormat(this)) {
            timePicker.setIs24HourView(true);
        }
        if (mPresenter.isAlarmSet()) {
            onAlarmStarted();
        } else {
            onAlarmStopped();
        }
        mPresenter.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()");
        mPresenter.pause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop()");
        mPresenter.stop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart()");
    }

    void linking() {
        btnStartAlarm = findViewById(R.id.btnStartAlarm);
        btnCancelAlarm = findViewById(R.id.btnCancelAlarm);
        timePicker = findViewById(R.id.timePicker);
        tvAlarmTime = findViewById(R.id.alarmTime);
    }

    public void onCancelAlarmClicked(View view) {
        Log.d(TAG, "onCancelAlarmClicked(View view)");
        mPresenter.onAlarmCancelled();
    }

    @Override
    public Context getContext() {
        return this;
    }

    public void onStartAlarmClicked(View view) {
        Log.d(TAG, "onStartAlarmClicked(View view)");
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, String.valueOf(view.getId()));
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, view.toString());
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "button");
        mFirebaseAnalytics.logEvent("Start_button_clicked", bundle);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmHour = timePicker.getHour();
            alarmMinute = timePicker.getMinute();
        } else {
            alarmHour = timePicker.getCurrentHour();
            alarmMinute = timePicker.getCurrentMinute();
        }
        Log.d(TAG, "Alarm alarmHour = " + alarmHour);
        Log.d(TAG, "Alarm minute = " + alarmMinute);
        mPresenter.onAlarmTriggered(alarmHour, alarmMinute);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                displayInterstitial(mInterstitialAd);
            }
        });
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }

    public void onInfoClicked(View view) {
        Log.d(TAG, "onInfoClicked(View view)");
        showInfoDialog();
    }

    public void onAboutClicked(View view) {
        Log.d(TAG, "onAboutClicked(View view)");
        showAboutDialog();
    }

    private void showInfoDialog() {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        ScrollView view = (ScrollView) getLayoutInflater()
                .inflate(R.layout.dialog_info, null);
        adb.setView(view);
        adb.create().show();
    }

    private void showAboutDialog() {
        AboutView aboutView = AboutBuilder.with(this)
                .setPhoto(R.drawable.my_photo)
                .setCover(R.mipmap.profile_cover)
                .setName(R.string.my_name)
                .setSubTitle(R.string.my_subtitle)
                .setBrief(R.string.my_brief_description)
                .setAppIcon(R.mipmap.ic_launcher)
                .setAppName(R.string.app_name)
                .addGitHubLink(R.string.my_github)
                .addLinkedInLink(R.string.my_linkedin)
                .addEmailLink(R.string.my_email)
                .addFiveStarsAction()
                .setVersionNameAsAppSubTitle()
                .addShareAction(R.string.app_name)
                .setWrapScrollView(true)
                .setLinksAnimated(true)
                .setShowAsCard(true)
                .setLinksAnimated(true)
                .setActionsColumnsCount(2)
                .setDividerDashGap(16)
                .build();
        AlertDialog dialog = new AlertDialog.Builder(this).create();
        dialog.setView(aboutView);
        dialog.show();
    }

    @Override
    public void onAlarmStarted() {
        Log.d(TAG, "onAlarmStarted()");
        updateConstraints(R.layout.activity_main_activated);
        btnStartAlarm.setVisibility(View.GONE);
        btnCancelAlarm.setVisibility(View.VISIBLE);
        timePicker.setEnabled(false);
        int alarmHour = getSharedPreferences
                (MainPresenter.ALARM_TIME, MODE_PRIVATE).getInt(MainPresenter.ALARM_HOUR, 0);
        int alarmMinute = getSharedPreferences
                (MainPresenter.ALARM_TIME, MODE_PRIVATE).getInt(MainPresenter.ALARM_MINUTE, 0);
        String formattedAlarmHour =
                alarmHour < 10 ? "0".concat(String.valueOf(alarmHour)) : String.valueOf(alarmHour);
        String formattedAlarmMinute =
                alarmMinute < 10 ? "0".concat(String.valueOf(alarmMinute)) : String.valueOf(alarmMinute);
        tvAlarmTime.setText(formattedAlarmHour.concat(" : ").concat(formattedAlarmMinute));
    }

    @Override
    public void onAlarmStopped() {
        Log.d(TAG, "onAlarmStopped()");
        updateConstraints(R.layout.activity_main);
        btnStartAlarm.setVisibility(View.VISIBLE);
        btnCancelAlarm.setVisibility(View.GONE);
        timePicker.setEnabled(true);
    }

    private void updateConstraints(@LayoutRes int id) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            ConstraintLayout root = findViewById(R.id.main_root);
            ConstraintSet newConstraintSet = new ConstraintSet();
            newConstraintSet.clone(this, id);
            newConstraintSet.applyTo(root);
            Transition transition = new ChangeBounds();
            transition.setInterpolator(new OvershootInterpolator());
            TransitionManager.beginDelayedTransition(root, transition);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
        mPresenter.destroy();
    }

    private void displayInterstitial(InterstitialAd interstitialAd) {
        if (interstitialAd.isLoaded()) {
            interstitialAd.show();
        } else {
            Log.d(TAG, "The interstitial wasn't loaded yet.");
        }
    }
}
