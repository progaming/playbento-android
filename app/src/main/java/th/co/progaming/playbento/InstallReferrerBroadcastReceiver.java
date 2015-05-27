package th.co.progaming.playbento;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.unity3d.player.UnityPlayer;

/**
 * Created by Chatpong on 5/27/15 AD.
 */
public class InstallReferrerBroadcastReceiver extends BroadcastReceiver {
    private static final String DEBUG_TAG = "InstallReferrerBroadcastReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        String referrer = intent.getStringExtra("referrer");
        if (referrer != null) {
            Log.d(DEBUG_TAG, "Referrer : " + referrer);
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
            if (!prefs.getBoolean("postback_sent", false)) {
                UnityPlayer.UnitySendMessage("Android Listener", "OnInstallReceived", referrer);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean("postback_sent", true);
                editor.commit();
            }
        } else {
            Log.e(DEBUG_TAG, "referrer is null");
        }
    }
}