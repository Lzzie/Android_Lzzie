package com.saijie.youka.fn;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.saijie.youka.R;
import com.saijie.youka.adapter.YuleAdapter;
import com.saijie.youka.base.BaseActivity;
import com.saijie.youka.bean.GoodsInfoYule;
import com.saijie.youka.reservation.ExpandTabView;
import com.saijie.youka.reservation.ViewFilter;
import com.saijie.youka.reservation.ViewLeft2;
import com.saijie.youka.reservation.ViewMiddle;
import com.saijie.youka.reservation.ViewRight;

import java.util.ArrayList;
import java.util.List;


public class YuleActivity extends BaseActivity {

	private ExpandTabView expandTabView;
	private ArrayList<View> mViewArray = new ArrayList<View>();
	private ViewLeft2 viewLeft2;
	private ViewMiddle viewMiddle;
	private ViewRight viewRight;
	private ViewFilter viewFilter;

	ListView goodsLv;
	private List<GoodsInfoYule> list;
	private YuleAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_yule);

		initView();
		initVaule();
		initListener();

		initData();//goodsLv

	}

	private void initData() {
		list = new ArrayList<>();
		adapter = new YuleAdapter(this,list);
		goodsLv.setAdapter(adapter);
		for(int i =0;i<8;i++){
			GoodsInfoYule goodsInfoYule = new GoodsInfoYule();
			goodsInfoYule.setYule_seller_name("百丽好声音量贩KTV"+(i+1)+"店");
			goodsInfoYule.setYule_seller_pf("5.0分");
			goodsInfoYule.setYule_seller_jg("￥2"+i+"起");
			goodsInfoYule.setYule_seller_jl("人民广场 "+(500+i*i)+"m");
			goodsInfoYule.setYule_seller_huodong("迷你小包3小时39元，中包3小时6"+i+"元");

			list.add(goodsInfoYule);
		}
		adapter.notifyDataSetChanged();
	}


	private void initView() {

		goodsLv =(ListView)findViewById(R.id.yule_goods_lv);//初始化

		expandTabView = (ExpandTabView) findViewById(R.id.expandtab_view);
		viewLeft2 = new ViewLeft2(this);
		viewMiddle = new ViewMiddle(this);
		viewRight = new ViewRight(this);
		viewFilter = new ViewFilter(this);

	}

	//	初始化
	private void initVaule() {

		mViewArray.add(viewLeft2);
		mViewArray.add(viewMiddle);
		mViewArray.add(viewRight);
		mViewArray.add(viewFilter);
		ArrayList<String> mTextArray = new ArrayList<String>();
		mTextArray.add("附近");
		mTextArray.add("KTV");
		mTextArray.add("智能排序");
		mTextArray.add("筛选");
		expandTabView.setValue(mTextArray, mViewArray);
		expandTabView.setTitle(viewLeft2.getShowText(), 0);
		expandTabView.setTitle(viewMiddle.getShowText(), 1);
		expandTabView.setTitle(viewRight.getShowText(), 2);
		expandTabView.setTitle(viewFilter.getShowText(), 3);

	}

	private void initListener() {

		viewLeft2.setOnSelectListener(new ViewLeft2.OnSelectListener() {

			@Override
			public void getValue(String distance, String showText) {
				onRefresh(viewLeft2, showText);
			}
		});

		viewMiddle.setOnSelectListener(new ViewMiddle.OnSelectListener() {

			@Override
			public void getValue(String showText) {onRefresh(viewMiddle,showText);

			}
		});

		viewRight.setOnSelectListener(new ViewRight.OnSelectListener() {

			@Override
			public void getValue(String distance, String showText) {
				onRefresh(viewRight, showText);
			}
		});

		viewFilter.setOnSelectListener(new ViewFilter.OnSelectListener() {

			@Override
			public void getValue(String distance, String showText) {
				onRefresh(viewFilter, showText);
			}
		});

	}

	private void onRefresh(View view, String showText) {

		expandTabView.onPressBack();
		int position = getPositon(view);
		if (position >= 0 && !expandTabView.getTitle(position).equals(showText)) {
			expandTabView.setTitle(showText, position);
		}

		Toast.makeText(YuleActivity.this, showText, Toast.LENGTH_SHORT).show();

	}

	private int getPositon(View tView) {
		for (int i = 0; i < mViewArray.size(); i++) {
			if (mViewArray.get(i) == tView) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void onBackPressed() {

		if (!expandTabView.onPressBack()) {
			finish();
		}

	}


}
