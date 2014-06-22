package com.peter.yin;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class YinService extends Service {

	public static final String TARGET_PACKAGE_NAME = "com.peter.yang";
	public static final String TARGET_ACTION = "com.peter.yang";
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Toast.makeText(this, "YinService onStartCommand()", Toast.LENGTH_SHORT).show();
		return START_STICKY;
	}

	@Override
	public void onCreate() {
		Toast.makeText(this, "YinService onCreate()", Toast.LENGTH_SHORT).show();
		startService(new Intent(TARGET_ACTION));
	}

	@Override
	public void onDestroy() {
		Toast.makeText(this, "YinService onDestroy()", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(getApplicationContext(), YinService.class);
		startService(intent);
	}
}
