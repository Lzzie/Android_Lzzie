package com.saijie.youka.fn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.saijie.youka.R;
import com.saijie.youka.adapter.ReservationAdapter;
import com.saijie.youka.base.BaseActivity;
import com.saijie.youka.bean.GoodsInfoReser;
import com.saijie.youka.details.SellerActivity;

import java.util.ArrayList;
import java.util.List;

public class RemaiActivity extends BaseActivity {


	ListView goodsLv;
	private List<GoodsInfoReser> list;
	private ReservationAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_remai);

		initView();

		initData();//goodsLv

	}
	private void initView() {
		goodsLv = (ListView) findViewById(R.id.reservation_goods_lv);//初始化
	}

	private void initData() {
		list = new ArrayList<>();
		adapter = new ReservationAdapter(this,list);
		goodsLv.setAdapter(adapter);
		for(int i =0;i<8;i++){
			GoodsInfoReser goodsInfoReser = new GoodsInfoReser();
			goodsInfoReser.setReser_seller_name("金谷大酒店兰亭序主题餐厅"+i);
			goodsInfoReser.setReser_seller_type("鲁菜");
			goodsInfoReser.setReser_seller_addres("[涑河街]188元 超值4-6人..");
			goodsInfoReser.setReser_seller_jl("71m");
			list.add(goodsInfoReser);
		}
		adapter.notifyDataSetChanged();
	}


	public void showJingu(View view){
		Intent intent = new Intent(RemaiActivity.this, SellerActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
		startActivity(intent);

	}

}
