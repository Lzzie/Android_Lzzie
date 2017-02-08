package com.saijie.youka.main;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.saijie.youka.R;
import com.saijie.youka.fragment.ContractFragment;
import com.saijie.youka.fragment.FindFragment;
import com.saijie.youka.fragment.FirstpageFragment;
import com.saijie.youka.fragment.MyinfoFragment;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by qiancheng on 2017/1/12.
 */

public class MainActivity extends Activity implements View.OnClickListener {
	private FirstpageFragment firstpageFragment;
	private FindFragment findFragment;
	private ContractFragment contractFragment;
	private MyinfoFragment myinfoFragment;
	@BindView(R.id.first_page)
	RadioButton firstPage;
	@BindView(R.id.find)
	RadioButton find;
	@BindView(R.id.contract)
	RadioButton contract;
	@BindView(R.id.myInfo)
	RadioButton myInfo;
	private Map<Integer, Fragment> map = new HashMap<>();
	private Fragment conventFragment;


	boolean isExit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_1);
		ButterKnife.bind(this);
		initListener();
		if (savedInstanceState == null) {
			setDefaultFragment();
		}




	}

	private void setDefaultFragment() {

		FragmentManager fm = getFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();
		firstpageFragment = new FirstpageFragment();
		map.put(0, firstpageFragment);
		transaction.replace(R.id.content, firstpageFragment);
		transaction.commit();
	}

	private void initListener() {
		firstPage.setOnClickListener(this);
		find.setOnClickListener(this);
		contract.setOnClickListener(this);
		myInfo.setOnClickListener(this);
	}

	@OnClick({R.id.first_page, R.id.find, R.id.contract, R.id.myInfo})
	public void onClick(View view) {
		FragmentManager fm = getFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();
		switch (view.getId()) {
			case R.id.first_page:
				initFragments(0);
				break;
			case R.id.find:
				initFragments(1);
				break;
			case R.id.contract:
				initFragments(2);
				break;
			case R.id.myInfo:
				initFragments(3);
				break;
		}
		transaction.commit();
	}


	private void initFragments(int i) {
		FragmentManager fm = getFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();
		switch (i) {
			case 0:
				if (firstpageFragment == null) {
					firstpageFragment = new FirstpageFragment();
					map.put(0, firstpageFragment);
					transaction.add(R.id.content, firstpageFragment);
				} else if (conventFragment == firstpageFragment) {

				} else {
					for (Map.Entry<Integer, Fragment> entry : map.entrySet()) {
						transaction.hide(entry.getValue());
					}
					transaction.show(firstpageFragment);
				}
				conventFragment = firstpageFragment;

				break;
			case 1:
				if (findFragment == null) {
					findFragment = new FindFragment();
					map.put(1, findFragment);
					transaction.add(R.id.content, findFragment);
				} else if (conventFragment == findFragment) {

				} else {
					for (Map.Entry<Integer, Fragment> entry : map.entrySet()) {
						transaction.hide(entry.getValue());
					}
					transaction.show(findFragment);
				}
				conventFragment = findFragment;

				break;
			case 2:
				if (contractFragment == null) {
					contractFragment = new ContractFragment();
					map.put(2, contractFragment);
					transaction.add(R.id.content, contractFragment);
					conventFragment = contractFragment;
				} else if (conventFragment == contractFragment) {

				} else {
					for (Map.Entry<Integer, Fragment> entry : map.entrySet()) {
						transaction.hide(entry.getValue());
						Log.i(entry.getKey()+"","hide");
					}
					transaction.show(contractFragment);
				}
				conventFragment = contractFragment;

				break;
			case 3:
				if (myinfoFragment == null) {
					myinfoFragment = new MyinfoFragment();
					map.put(3, myinfoFragment);
					transaction.add(R.id.content, myinfoFragment);
					conventFragment = myinfoFragment;
				} else if (conventFragment == myinfoFragment) {

				} else {
					for (Map.Entry<Integer, Fragment> entry : map.entrySet()) {
						transaction.hide(entry.getValue());
						Log.i(entry.getKey()+"","hide");
					}
					transaction.show(myinfoFragment);
				}
				conventFragment = myinfoFragment;

				break;
		}
		transaction.commit();
	}

	//防止自己写的应用程序不小心点击退出键而直接退出
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			exit();
			return false;
		} else {
			return super.onKeyDown(keyCode, event);
		}
	}
	public void exit(){
		if (!isExit) {
			isExit = true;
			Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
			mHandler.sendEmptyMessageDelayed(0, 3000);
		} else {
			Intent intent = new Intent(Intent.ACTION_MAIN);
			intent.addCategory(Intent.CATEGORY_HOME);
			startActivity(intent);
			overridePendingTransition(0,R.anim.main_out);
		}
	}
	Handler mHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			isExit = false;
		}

	};

}
