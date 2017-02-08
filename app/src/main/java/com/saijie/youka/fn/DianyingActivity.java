package com.saijie.youka.fn;

import android.os.Bundle;
import android.widget.ListView;

import com.saijie.youka.R;
import com.saijie.youka.adapter.DianyingAdapter;
import com.saijie.youka.base.BaseActivity;
import com.saijie.youka.bean.GoodsInfoDianying;

import java.util.ArrayList;
import java.util.List;

public class DianyingActivity extends BaseActivity {


	ListView goodsLv;
	private List<GoodsInfoDianying> list;
	private DianyingAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dianying);

		initView();

		initData();//goodsLv

	}
	private void initView() {
		goodsLv = (ListView) findViewById(R.id.dianying_goods_lv);//初始化
	}
	private void initData() {
		list = new ArrayList<>();
		adapter = new DianyingAdapter(this,list);
		goodsLv.setAdapter(adapter);
		for(int i =0;i<8;i++){
			GoodsInfoDianying goodsInfoDianying = new GoodsInfoDianying();
			goodsInfoDianying.setMovie_seller_name("星美国际影院"+"万阅城"+(i+1)+"店");
			goodsInfoDianying.setMovie_seller_jg("￥3"+i);
			goodsInfoDianying.setMovie_seller_jl("人民广场 > "+(100+i*i)+" m");


			list.add(goodsInfoDianying);
		}
		adapter.notifyDataSetChanged();
	}

}
