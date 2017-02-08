package com.saijie.youka.bean;

import android.app.Application;
import android.content.Context;

/**
 * Created by qiancheng on 2017/1/14.
 */

public class MyApplication extends Application {
	private static Context context;
	@Override
	public void onCreate() {
		super.onCreate();
		context=getApplicationContext();
	}
	public  static Context getContext(){
		return  context;
	}
}
