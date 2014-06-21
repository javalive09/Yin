package com.peter.yin;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.widget.Toast;

public class YinService extends Service{

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		super.onStartCommand(intent, flags, startId);
		return START_STICKY;
	}
	
	@Override
	public void onCreate() {
		Toast.makeText(this, "YinService onCreate()", Toast.LENGTH_LONG).show();
		handler.sendEmptyMessageDelayed(0, 1);
	}
	
	Handler handler = new Handler(Looper.getMainLooper()) {
		public void handleMessage(android.os.Message msg) {
			Intent intent = new Intent();
			ComponentName componentName = new ComponentName("com.peter.yang", "com.peter.yang.YangService");
			intent.setComponent(componentName);
			startService(intent);
			
			sendEmptyMessageDelayed(0, 1);
		};
	};
	
	@Override
	public void onDestroy() {
		Toast.makeText(this, "YinService onDestroy()", Toast.LENGTH_LONG).show();
		Intent intent = new Intent(getApplicationContext(), YinService.class);
		startService(intent);
	}
}
