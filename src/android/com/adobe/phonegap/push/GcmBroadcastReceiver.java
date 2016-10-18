package com.adobe.phonegap.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.WakefulBroadcastReceiver;

import com.adobe.phonegap.push.GCMIntentService;

/**
 * Created by ago on 18/10/16.
 */
public class GcmBroadcastReceiver
        extends WakefulBroadcastReceiver {
    @Override
    public void onReceive(Context paramContext, Intent paramIntent) {
        Bundle localBundle = paramIntent.getExtras();
        if (!localBundle.containsKey("tinaba")) {
            return;
        }

        if (isOrderedBroadcast())
        {
            setResultCode(0);
            abortBroadcast();
        }
        ComponentName localComponentName = new ComponentName(paramContext.getPackageName(), GCMIntentService.class.getName());

        startWakefulService(paramContext, paramIntent.setComponent(localComponentName));

    }
}
