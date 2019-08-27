package serdar.oz.loodostestapp.ui.splash;

import android.content.BroadcastReceiver;
import android.content.Context;

import serdar.oz.loodostestapp.components.NetworkChangeReceiver;
import serdar.oz.loodostestapp.ui.base.BasePresenter;
import serdar.oz.loodostestapp.ui.base.BaseView;


public interface SplashContract {

    interface View extends BaseView {

        void fetchSuccessMessage();

        void fetchFailedMessage();

        void onSplashAnimationEnd();

        void internetErrorLayout();

        void initListeners();

        void onActivityPause();

        void onActivityDestroy();

        void setSplashTextAndStartAnimation(String text);


    }

    interface Presenter extends BasePresenter {

        void fetchFirebase();

        void startMainActivity();

        BroadcastReceiver checkNetworkState();

        NetworkChangeReceiver registerReceiver(Context context, BroadcastReceiver mReceiver);

        void unregisterReceiver(Context context, NetworkChangeReceiver mReceiver);

    }
}
