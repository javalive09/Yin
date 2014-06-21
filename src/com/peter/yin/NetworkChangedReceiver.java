package com.peter.yin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class NetworkChangedReceiver extends BroadcastReceiver {
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "YinService onReceive()", Toast.LENGTH_LONG).show();
		Intent in = new Intent(context, YinService.class);
	    context.startService(in);
	}
}