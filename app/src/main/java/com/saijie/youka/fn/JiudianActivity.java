package com.saijie.youka.fn;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.saijie.youka.R;
import com.saijie.youka.adapter.JiudianAdapter;
import com.saijie.youka.base.BaseActivity;
import com.saijie.youka.bean.GoodsInfoJiudian;
import com.saijie.youka.reservation.ExpandTabView;
import com.saijie.youka.reservation.ViewFilter;
import com.saijie.youka.reservation.ViewLeft3;
import com.saijie.youka.reservation.ViewMiddle;
import com.saijie.youka.reservation.ViewRight;

import java.util.ArrayList;
import java.util.List;

public class JiudianActivity extends BaseActivity {

	private ExpandTabView expandTabView;
	private ArrayList<View> mViewArray = new ArrayList<View>();
	private ViewLeft3 viewLeft3;
	private ViewMiddle viewMiddle;
	private ViewRight viewRight;
	private ViewFilter viewFilter;


	ListView goodsLv;
	private List<GoodsInfoJiudian> list;
	private JiudianAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jiudian);

		initView();
		initVaule();
		initListener();

		initData();//goodsLv

	}

	private void initData() {
		list = new ArrayList<>();
		adapter = new JiudianAdapter(this,list);
		goodsLv.setAdapter(adapter);
		for(int i =0;i<8;i++){
			GoodsInfoJiudian goodsInfoJiudian = new GoodsInfoJiudian();
			goodsInfoJiudian.setJiudian_seller_name("金谷大酒店"+(i+1)+"店");
			goodsInfoJiudian.setJiudian_seller_type("豪华型"+(i+1));
			goodsInfoJiudian.setJiudian_seller_pf("5.0分");
			goodsInfoJiudian.setJiudian_seller_jg("￥29"+(i+1));
			goodsInfoJiudian.setJiudian_seller_jl("蒙山大道"+" "+(i+1)+"Km");

			list.add(goodsInfoJiudian);
		}
		adapter.notifyDataSetChanged();
	}


	private void initView() {

		goodsLv =(ListView)findViewById(R.id.jiudian_goods_lv);//初始化

		expandTabView = (ExpandTabView) findViewById(R.id.expandtab_view);
		viewLeft3 = new ViewLeft3(this);
		viewMiddle = new ViewMiddle(this);
		viewRight = new ViewRight(this);
		viewFilter = new ViewFilter(this);

	}

	//	初始化
	private void initVaule() {

		mViewArray.add(viewLeft3);
		mViewArray.add(viewMiddle);
		mViewArray.add(viewRight);
		mViewArray.add(viewFilter);
		ArrayList<String> mTextArray = new ArrayList<String>();
		mTextArray.add("附近");
		mTextArray.add("豪华型");
		mTextArray.add("智能排序");
		mTextArray.add("筛选");
		expandTabView.setValue(mTextArray, mViewArray);
		expandTabView.setTitle(viewLeft3.getShowText(), 0);
		expandTabView.setTitle(viewMiddle.getShowText(), 1);
		expandTabView.setTitle(viewRight.getShowText(), 2);
		expandTabView.setTitle(viewFilter.getShowText(), 3);

	}

	private void initListener() {

		viewLeft3.setOnSelectListener(new ViewLeft3.OnSelectListener() {

			@Override
			public void getValue(String distance, String showText) {
				onRefresh(viewLeft3, showText);
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

		Toast.makeText(JiudianActivity.this, showText, Toast.LENGTH_SHORT).show();

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
