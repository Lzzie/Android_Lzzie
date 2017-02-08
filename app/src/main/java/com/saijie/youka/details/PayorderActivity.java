package com.saijie.youka.details;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.saijie.youka.R;
import com.saijie.youka.base.BaseActivity;

public class PayorderActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_payorder);
	}


	public void showPaysuccess(View view){
		Intent intent = new Intent(PayorderActivity.this, PaysuccessActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
		startActivity(intent);
		finish();

	}

}
