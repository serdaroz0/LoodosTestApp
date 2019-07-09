package serdar.oz.loodostestapp.control;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import serdar.oz.loodostestapp.Constants;

public class NetworkChangeReceiver extends BroadcastReceiver {
    @SuppressLint("UnsafeProtectedBroadcastReceiver")
    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            if (isOnline(context))
                LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent(Constants.NETWORK_CONNECTED));
            else
                LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent(Constants.NO_NETWORK));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private boolean isOnline(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            assert cm != null;
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            return (netInfo != null && netInfo.isConnected());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return false;
    }
}