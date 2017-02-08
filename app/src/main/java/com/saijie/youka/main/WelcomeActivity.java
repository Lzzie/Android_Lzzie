package com.saijie.youka.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import com.saijie.youka.R;
import com.saijie.youka.fn.LoginActivity;

public class WelcomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_welcome);

		new Thread(new Runnable() {
			@Override
			public void run() {
				//此处运行耗时任务
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
						startActivity(intent);
						WelcomeActivity.this.finish();
					}
				});
			}
		}).start();





	}


}

