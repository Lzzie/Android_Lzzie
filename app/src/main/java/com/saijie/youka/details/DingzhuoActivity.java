package com.saijie.youka.details;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.saijie.youka.R;
import com.saijie.youka.base.BaseActivity;

public class DingzhuoActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dingzhuo);

		final ImageView select =(ImageView)findViewById(R.id.dz_img_select_1);
     	final ImageView un =(ImageView)findViewById(R.id.dz_img_un_1);
		final ImageView select2 =(ImageView)findViewById(R.id.dz_img_select_2);
		final ImageView un2 =(ImageView)findViewById(R.id.dz_img_un_2);
		final ImageView select3 =(ImageView)findViewById(R.id.dz_img_select_3);
		final ImageView un3 =(ImageView)findViewById(R.id.dz_img_un_3);

		final LinearLayout xiangqing_1 =(LinearLayout) findViewById(R.id.xiangqing_1);
		final LinearLayout xiangqing_2 =(LinearLayout) findViewById(R.id.xiangqing_2);
		final LinearLayout xiangqing_3 =(LinearLayout) findViewById(R.id.xiangqing_3);

		final ImageView down =(ImageView)findViewById(R.id.dingzhuo_down);
		final ImageView up =(ImageView)findViewById(R.id.dingzhuo_up);
		final ImageView down2 =(ImageView)findViewById(R.id.dingzhuo_down2);
		final ImageView up2 =(ImageView)findViewById(R.id.dingzhuo_up2);
		final ImageView down3 =(ImageView)findViewById(R.id.dingzhuo_down3);
		final ImageView up3 =(ImageView)findViewById(R.id.dingzhuo_up3);

		un.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view) {
				un.setVisibility(View.GONE);
				select.setVisibility(View.VISIBLE);
				un2.setVisibility(View.VISIBLE);
				select2.setVisibility(View.GONE);
				un3.setVisibility(View.VISIBLE);
				select3.setVisibility(View.GONE);

				xiangqing_1.setVisibility(View.VISIBLE);
				xiangqing_2.setVisibility(View.GONE);
				xiangqing_3.setVisibility(View.GONE);

				down.setVisibility(View.GONE);
				up.setVisibility(View.VISIBLE);
				down2.setVisibility(View.VISIBLE);
				up2.setVisibility(View.GONE);
				down3.setVisibility(View.VISIBLE);
				up3.setVisibility(View.GONE);
			}});
		un2.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view) {
				un.setVisibility(View.VISIBLE);
				select.setVisibility(View.GONE);
				un2.setVisibility(View.GONE);
				select2.setVisibility(View.VISIBLE);
				un3.setVisibility(View.VISIBLE);
				select3.setVisibility(View.GONE);

				xiangqing_1.setVisibility(View.GONE);
				xiangqing_2.setVisibility(View.VISIBLE);
				xiangqing_3.setVisibility(View.GONE);

				down.setVisibility(View.VISIBLE);
				up.setVisibility(View.GONE);
				down2.setVisibility(View.GONE);
				up2.setVisibility(View.VISIBLE);
				down3.setVisibility(View.VISIBLE);
				up3.setVisibility(View.GONE);
			}});
		un3.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view) {
				un.setVisibility(View.VISIBLE);
				select.setVisibility(View.GONE);
				un2.setVisibility(View.VISIBLE);
				select2.setVisibility(View.GONE);
				un3.setVisibility(View.GONE);
				select3.setVisibility(View.VISIBLE);

				xiangqing_1.setVisibility(View.GONE);
				xiangqing_2.setVisibility(View.GONE);
				xiangqing_3.setVisibility(View.VISIBLE);

				down.setVisibility(View.VISIBLE);
				up.setVisibility(View.GONE);
				down2.setVisibility(View.VISIBLE);
				up2.setVisibility(View.GONE);
				down3.setVisibility(View.GONE);
				up3.setVisibility(View.VISIBLE);
			}});

	}




}
