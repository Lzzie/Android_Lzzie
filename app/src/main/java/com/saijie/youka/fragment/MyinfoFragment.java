package com.saijie.youka.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.saijie.youka.R;
import com.saijie.youka.fn.MyaddressActivity;
import com.saijie.youka.fn.MyexchangeActivity;
import com.saijie.youka.fn.MyinfoActivity;
import com.saijie.youka.fn.MyintegralActivity;
import com.saijie.youka.fn.MymoneyActivity;
import com.saijie.youka.fn.MyordeActivity;
import com.saijie.youka.fn.MypreferentialActivity;
import com.saijie.youka.fn.MywalletActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by qiancheng on 2017/1/12.
 */

public class MyinfoFragment extends Fragment {

	@BindView(R.id.myPreferential)
	LinearLayout myPreferential;
	@BindView(R.id.myIntegral)
	LinearLayout myIntegral;
	@BindView(R.id.showMyorder)
	LinearLayout showMyorder;
	@BindView(R.id.myWallet)
	LinearLayout myWallet;
	@BindView(R.id.myExchange)
	LinearLayout myExchange;
	@BindView(R.id.myAddress)
	LinearLayout myAddress;
	@BindView(R.id.showMyInfo)
	LinearLayout showMyInfo;
	@BindView(R.id.showMymoney)
	LinearLayout showMymoney;
	@BindView(R.id.mykaquan)
	LinearLayout showmykaquan;

	private Context context;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.page_04, container, false);
		ButterKnife.bind(this, view);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		context = getActivity();
	}

	@OnClick({ R.id.myPreferential, R.id.myIntegral, R.id.showMyorder, R.id.myWallet, R.id.myExchange, R.id.myAddress,R.id.showMyInfo,R.id.showMymoney,R.id.mykaquan})
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.myPreferential:
				showMypreferential();
				break;
			case R.id.myIntegral:
				showMyintegral();
				break;
			case R.id.showMyorder:
				showMyorder();
				break;
			case R.id.myWallet:
				showMywallet();
				break;
			case R.id.myExchange:
				showMyexchange();
				break;
			case R.id.myAddress:
				showMyaddress();
				break;
			case R.id.showMyInfo:
				showMyinfo();
				break;
			case R.id.showMymoney:
				showMymoney();
				break;
			case R.id.mykaquan:
				showMypreferential();
				break;

		}
	}



	//我的订单
	public void showMyorder() {
		Intent intent = new Intent(context, MyordeActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
		startActivity(intent);
	}

	//我的钱包
	public void showMywallet() {
		Intent intent = new Intent(context, MywalletActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
		startActivity(intent);
	}

	//我的优惠券
	public void showMypreferential() {
		Intent intent = new Intent(context, MypreferentialActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
		startActivity(intent);
	}

	//我的积分
	public void showMyintegral() {
		Intent intent = new Intent(context, MyintegralActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
		startActivity(intent);
	}

	//积分兑换
	public void showMyexchange() {
		Intent intent = new Intent(context, MyexchangeActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
		startActivity(intent);
	}

	//收货地址
	public void showMyaddress() {
		Intent intent = new Intent(context, MyaddressActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
		startActivity(intent);
	}
	//个人信息
	public void showMyinfo(){
		Intent intent = new Intent(context, MyinfoActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
		startActivity(intent);
	}
	//我的余额
	public void showMymoney(){
		Intent intent = new Intent(context, MymoneyActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
		startActivity(intent);
	}


}
