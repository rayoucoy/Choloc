package com.skripsi.yudha.choloc;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
/**
 * Created by yudha on 05/06/2016.
 */
public class GcmBroadcastReceiver extends WakefulBroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("GcmBroadcastReceiver",
                "onReceive: notification received.");
        ComponentName comp = new ComponentName(context.getPackageName(),
                GCMNotifIntentService.class.getName());
        startWakefulService(context, (intent.setComponent(comp)));
        setResultCode(Activity.RESULT_OK);
    }
}