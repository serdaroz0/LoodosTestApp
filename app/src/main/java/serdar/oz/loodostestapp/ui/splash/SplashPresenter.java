package serdar.oz.loodostestapp.ui.splash;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.util.Log;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

import java.util.HashMap;
import java.util.Map;

import serdar.oz.loodostestapp.R;
import serdar.oz.loodostestapp.components.NetworkChangeReceiver;
import serdar.oz.loodostestapp.ui.main.MainActivity;

import static android.content.ContentValues.TAG;
import static serdar.oz.loodostestapp.constants.FirebaseConstants.CACHE_EXPIRATION;
import static serdar.oz.loodostestapp.constants.FirebaseConstants.SPLASH_TEXT;
import static serdar.oz.loodostestapp.constants.GlobalConstants.NETWORK_CONNECTED;
import static serdar.oz.loodostestapp.constants.GlobalConstants.NO_NETWORK;

public class SplashPresenter implements SplashContract.Presenter {
    private final SplashContract.View mView;
    private final Context context;

    SplashPresenter(Context context, SplashContract.View mView) {
        this.mView = mView;
        this.context = context;
    }


    @Override
    public void fetchFirebase() {
        FirebaseRemoteConfig mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        Map<String, Object> map = new HashMap<>();
        map.put(SPLASH_TEXT, context.getString(R.string.splash_text));
        mFirebaseRemoteConfig.setConfigSettingsAsync(new FirebaseRemoteConfigSettings.Builder().setMinimumFetchIntervalInSeconds(CACHE_EXPIRATION).build());
        mFirebaseRemoteConfig.setDefaults(R.xml.default_splash);
        mFirebaseRemoteConfig.setDefaultsAsync(map);
        String splashText = mFirebaseRemoteConfig.getString(SPLASH_TEXT);
        /*Set Splash text here*/
        mView.setSplashTextAndStartAnimation(splashText);
         /*  This will initiate fetching of parameters. We have set the expiry time as 0
             which will ensure we get fresh parameters every time */
        mFirebaseRemoteConfig.fetch().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                mView.fetchSuccessMessage();
                // After config data is successfully fetched, it must be activated before newly fetched
                // values are returned.
                mFirebaseRemoteConfig.activate();
            } else
                mView.fetchFailedMessage();
        });
    }

    @Override
    public BroadcastReceiver checkNetworkState() {
        return new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                try {
                    if (intent.getAction() != null) {
                        Log.e(TAG, "onReceive: " + intent.getAction());
                        if (intent.getAction().equals(NO_NETWORK))
                            mView.internetErrorLayout();
                        else
                            fetchFirebase();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
    }

    @Override
    public NetworkChangeReceiver registerReceiver(Context context, BroadcastReceiver mReceiver) {
        NetworkChangeReceiver networkChangeReceiver = new NetworkChangeReceiver();
        try {
            context.registerReceiver(networkChangeReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
            LocalBroadcastManager.getInstance(context).registerReceiver(mReceiver, new IntentFilter(NETWORK_CONNECTED));
            LocalBroadcastManager.getInstance(context).registerReceiver(mReceiver, new IntentFilter(NO_NETWORK));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return networkChangeReceiver;
    }

    @Override
    public void unregisterReceiver(Context context, NetworkChangeReceiver mReceiver) {
        try {
            context.unregisterReceiver(mReceiver);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startMainActivity() {
        context.startActivity(new Intent(context, MainActivity.class));
        /*Splash Animation*/
        Animatoo.animateZoom(context);
        ((Activity) context).finish();
    }


    @Override
    public void created() {
        mView.bindViews();
        mView.initListeners();
    }
}
