package com.saijie.youka.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.saijie.youka.R;
import com.saijie.youka.details.SellerActivity;
import com.saijie.youka.fn.AddressActivity;
import com.saijie.youka.fn.ChaozhiActivity;
import com.saijie.youka.fn.ChongzhiActivity;
import com.saijie.youka.fn.DianyingActivity;
import com.saijie.youka.fn.DytuijianActivity;
import com.saijie.youka.fn.HuiyuanActivity;
import com.saijie.youka.fn.JiayuActivity;
import com.saijie.youka.fn.JiudianActivity;
import com.saijie.youka.fn.JshipaiActivity;
import com.saijie.youka.fn.RemaiActivity;
import com.saijie.youka.fn.SearchActivity;
import com.saijie.youka.fn.TiantianActivity;
import com.saijie.youka.fn.YuleActivity;
import com.saijie.youka.reservation.DeliverActivity;
import com.saijie.youka.reservation.ReservationActivity;
import com.saijie.youka.util.BeanUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by qiancheng on 2017/1/12.
 */

public class FirstpageFragment extends Fragment {
	@BindView(R.id.jishipai)
	LinearLayout jishipai;
	@BindView(R.id.showAddress)
	TextView showAddress;
	@BindView(R.id.showSearch)
	ImageView showSearch;
	@BindView(R.id.iv_show_Pop)
	ImageView ivShowPop;
	@BindView(R.id.dingcan)
	TextView dingcan;
	@BindView(R.id.waimai)
	TextView waimai;
	@BindView(R.id.jingu)
	LinearLayout jingu;
	@BindView(R.id.jingu2)
	LinearLayout jingu2;
	private Context context;
	@BindView(R.id.yule)
	TextView yule;
	@BindView(R.id.jiudian)
	TextView jiudian;
	@BindView(R.id.chongzhi)
	TextView chongzhi;
	@BindView(R.id.jiayu)
	TextView jiayu;
	@BindView(R.id.huiyuanzhuanqu)
	LinearLayout huiyuanzhuanqu;
	@BindView(R.id.dianying)
	TextView dianying;
	@BindView(R.id.remai)
	LinearLayout remai;
	@BindView(R.id.chaozhi)
	LinearLayout chaozhi;
	@BindView(R.id.tiantian)
	LinearLayout tiantian;
	@BindView(R.id.dytuijian)
	LinearLayout dytuijian;
	@BindView(R.id.more)
	TextView more;
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.page_01, container, false);
		ButterKnife.bind(this, view);
		return view;

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		context = getActivity();

		TextView textView = (TextView)getActivity().findViewById(R.id.test_main);
		TextView textView2 = (TextView)getActivity().findViewById(R.id.test_main2);

		textView.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
		textView2.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);

	}


	@OnClick({R.id.showAddress, R.id.showSearch, R.id.iv_show_Pop, R.id.dingcan, R.id.waimai, R.id.jishipai, R.id.jingu, R.id.jingu2,
			R.id.yule, R.id.jiudian, R.id.chongzhi, R.id.jiayu, R.id.huiyuanzhuanqu ,R.id.dianying ,R.id.remai,R.id.chaozhi,R.id.tiantian,R.id.dytuijian,R.id.more})
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.showAddress:
				showAddress();
				break;
			case R.id.showSearch:
				showSearch();
				break;
			case R.id.iv_show_Pop:
				new BeanUtil().showPop(ivShowPop,context);
				break;
			case R.id.dingcan:
				showDingcan();
				break;
			case R.id.waimai:
				showDeliver();
				break;
			case R.id.jishipai:
				showJshipai();
				break;
			case R.id.jingu:
				showJingu();
				break;
			case R.id.jingu2:
				showJingu();
				break;
			case R.id.yule:
				showYule();
				break;
			case R.id.jiudian:
				showJiudian();
				break;
			case R.id.chongzhi:
				showChongzhi();
				break;
			case R.id.jiayu:
				showJiayu();
				break;
			case R.id.huiyuanzhuanqu:
				showHuiyuan();
				break;
			case R.id.dianying:
				showDianying();
				break;
			case R.id.remai:
				showRemai();
				break;
			case R.id.chaozhi:
				showChaozhi();
				break;
			case R.id.tiantian:
				showTiantian();
				break;
			case R.id.dytuijian:
				showDytuijian();
				break;
			case R.id.more:

//				CustomPopupWindow popupWindow = new CustomPopupWindow(getActivity());
//				popupWindow.showAtDropDownCenter(more);

				new BeanUtil().showPop2(more,context);

				break;
		}
	}
	//搜索
	public void showSearch(){
		Intent intent = new Intent(context, SearchActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
		startActivity(intent);

	}
	//地址
	public void showAddress(){
		Intent intent = new Intent(context, AddressActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
		startActivity(intent);

	}
	//及时拍
	public void showJshipai(){
		Intent intent = new Intent(context, JshipaiActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
		startActivity(intent);

	}
	//会员专区
	public void showHuiyuan(){
		Intent intent = new Intent(context, HuiyuanActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
		startActivity(intent);
	}
	//热卖美食
	public void showRemai(){
		Intent intent = new Intent(context, RemaiActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
		startActivity(intent);
	}
	//超值优惠
	public void showChaozhi(){
		Intent intent = new Intent(context, ChaozhiActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
		startActivity(intent);
	}
	//天天特价
	public void showTiantian(){
		Intent intent = new Intent(context, TiantianActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
		startActivity(intent);
	}
	//电影推荐
	public void showDytuijian(){
		Intent intent = new Intent(context, DytuijianActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
		startActivity(intent);
	}
	//订餐
	public void showDingcan(){
		Intent intent = new Intent(context, ReservationActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
		startActivity(intent);
	}
	//外卖
	public void showDeliver(){
		Intent intent = new Intent(context, DeliverActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
		startActivity(intent);
	}
	//金谷
	public void showJingu(){
		Intent intent = new Intent(context, SellerActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
		startActivity(intent);
	}
	//娱乐
	public void showYule(){
		Intent intent = new Intent(context, YuleActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
		startActivity(intent);
	}
	//加油
	public void showJiayu(){
		Intent intent = new Intent(context, JiayuActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
		startActivity(intent);
	}
	//酒店
	public void showJiudian(){
		Intent intent = new Intent(context, JiudianActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
		startActivity(intent);
	}
	//电影
	public void showDianying(){
		Intent intent = new Intent(context, DianyingActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
		startActivity(intent);
	}

	//充值
	public void showChongzhi(){
		Intent intent = new Intent(context, ChongzhiActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
		startActivity(intent);
	}



}
