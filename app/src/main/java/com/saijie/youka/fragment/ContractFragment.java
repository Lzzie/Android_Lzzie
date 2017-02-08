package com.saijie.youka.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.saijie.youka.R;
import com.saijie.youka.bean.MyApplication;
import com.saijie.youka.layout.MyLinearLayout;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by qiancheng on 2017/1/12.
 */

public class ContractFragment extends Fragment {
	@BindView(R.id.square)
	TextView square;
	@BindView(R.id.organization)
	TextView organization;
	@BindView(R.id.intimacy)
	TextView intimacy;
	@BindView(R.id.content2)
	FrameLayout content2;
	@BindView(R.id.id_tab_line_iv)
	ImageView mTabLineIv;
	@BindView(R.id.tab_layout)
	RelativeLayout tabLayout;
	private Context context;
	private QZ_SquareFragment squareFragment;
	private QZ_OrganizationFragment organizationFragment;
	private QZ_IntimacyFragment intimacyFragment;
	private Map<Integer, Fragment> map = new HashMap<>();
	private int conventFragment;
	private GestureDetector gesture;//手势识别
	private MyLinearLayout myLinearLayout;
	private int screenWidth;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		myLinearLayout = (MyLinearLayout) inflater.inflate(R.layout.page_02, container, false);
		ButterKnife.bind(this, myLinearLayout);
//设置手势监听事件
		initTabLineWidth();

		return myLinearLayout;
	}

	private void initListener(View view) {
		gesture = new GestureDetector(MyApplication.getContext(), new MyOnGestureListener());
		view.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				return gesture.onTouchEvent(motionEvent);//返回手势识别触发的事件
			}


		});
	}


	private void setDefaultFragment() {

		FragmentManager fm = getFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();
		squareFragment = new QZ_SquareFragment();
		map.put(0, squareFragment);
		conventFragment = 0;
		transaction.add(R.id.content2, squareFragment);
		transaction.commit();
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		if (savedInstanceState == null) {
			setDefaultFragment();
		}
		initListener(myLinearLayout);

	}

	@OnClick({  R.id.square, R.id.organization, R.id.intimacy})
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.square:
				initFragments(0);
				break;
			case R.id.organization:
				initFragments(1);
				break;
			case R.id.intimacy:
				initFragments(2);
				break;
		}
	}


	//实现切换界面
	private void initFragments(int i) {
		FragmentManager fm = getFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();
		LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) tabLayout
				.getLayoutParams();
		int lr = i-conventFragment;//根据大小判断滑动方向
		int temp =screenWidth/3;
		lp.leftMargin=i*temp;
		TranslateAnimation translateAnimation = new TranslateAnimation(temp*conventFragment,(conventFragment+lr)*temp,0,0);
		translateAnimation.setDuration(500);
		translateAnimation.setFillAfter(true);
		switch (i) {
			case 0:
				if (squareFragment == null) {
					squareFragment = new QZ_SquareFragment();
					map.put(0, squareFragment);
					transaction.add(R.id.content2, squareFragment);
				} else if (conventFragment == 0) {


				} else {
					for (Map.Entry<Integer, Fragment> entry : map.entrySet()) {
						transaction.hide(entry.getValue());
					}
					transaction.show(squareFragment);
				}
				conventFragment = 0;

				break;
			case 1:
				if (organizationFragment == null) {
					organizationFragment = new QZ_OrganizationFragment();
					map.put(1, organizationFragment);
					transaction.add(R.id.content2, organizationFragment);
				} else if (conventFragment == 1) {

				} else {
					for (Map.Entry<Integer, Fragment> entry : map.entrySet()) {
						transaction.hide(entry.getValue());
					}
					transaction.show(organizationFragment);
				}
				conventFragment = 1;

				break;
			case 2:
				if (intimacyFragment == null) {
					intimacyFragment = new QZ_IntimacyFragment();
					map.put(2, intimacyFragment);
					transaction.add(R.id.content2, intimacyFragment);
				} else if (conventFragment == 2) {

				} else {
					for (Map.Entry<Integer, Fragment> entry : map.entrySet()) {
						transaction.hide(entry.getValue());
						Log.i(entry.getKey() + "", "hide");
					}

					Log.i("2", "show");
					transaction.show(intimacyFragment);
				}
				conventFragment = 2;

				break;
		}
		tabLayout.startAnimation(translateAnimation);
		transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		transaction.commit();


	}

	//设置手势识别监听器
	private class MyOnGestureListener extends GestureDetector.SimpleOnGestureListener {
		private MotionEvent mLastOnDownEvent = null;

		@Override//此方法必须重写且返回真，否则onFling不起效
		public boolean onDown(MotionEvent e) {
			mLastOnDownEvent = e;
			return true;
		}

		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
			Log.i("contractFragment", "onFling");
			Log.i("contract", "速度" + velocityX);

			if (velocityX > 200) {
				Log.i("contractFragment", "向左滑动");
				if ((conventFragment > 0)) {
					initFragments(conventFragment - 1);

				}
				return true;
			} else if (velocityX < -200) {
				Log.i("contractFragment", "向右滑动");
				if (conventFragment < 2) {
					initFragments(conventFragment + 1);
				}
				return true;
			}
			return false;
		}

	}

	/*
	设置TAB下划线的宽度
	 */
	private void initTabLineWidth() {
		WindowManager manager = (WindowManager) MyApplication.getContext().getSystemService(Context.WINDOW_SERVICE);
		Display display = manager.getDefaultDisplay();
		screenWidth = display.getWidth();
		LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) tabLayout
				.getLayoutParams();
		lp.width = screenWidth / 3;
		tabLayout.setLayoutParams(lp);
		RelativeLayout.LayoutParams tab = (RelativeLayout.LayoutParams) mTabLineIv.getLayoutParams();
		tab.width=screenWidth/6;
		mTabLineIv.setLayoutParams(tab);


	}

}
