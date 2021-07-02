package com.globbo.sutt.client.stub;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.globbo.sutt.helper.utils.ComponentUtils;
import com.globbo.sutt.os.VUserHandle;

/**
 * @author Lody
 */

public class StubPendingReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
                Intent realIntent = intent.getParcelableExtra("_VA_|_intent_");
        int userId = intent.getIntExtra("_VA_|_user_id_", VUserHandle.USER_ALL);
        if (realIntent != null) {
            Intent newIntent = ComponentUtils.redirectBroadcastIntent(realIntent, userId);
            if (newIntent != null) {
                context.sendBroadcast(newIntent);
            }
        }
    }
}
