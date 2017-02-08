package com.saijie.youka.fn;

import android.os.Bundle;
import android.widget.ListView;

import com.saijie.youka.R;
import com.saijie.youka.adapter.TiantianAdapter;
import com.saijie.youka.base.BaseActivity;
import com.saijie.youka.bean.GoodsInfoTiantian;

import java.util.ArrayList;
import java.util.List;

public class TiantianActivity extends BaseActivity {


	ListView goodsLv;
	private List<GoodsInfoTiantian> list;
	private TiantianAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tiantian);

		goodsLv =(ListView)findViewById(R.id.tiantian_goods_lv);//初始化
		initData();//goodsLv


	}

	private void initData() {

		list = new ArrayList<>();
		adapter = new TiantianAdapter(this,list);
		goodsLv.setAdapter(adapter);
		for(int i =0;i<8;i++){
			GoodsInfoTiantian goodsInfoTiantian = new GoodsInfoTiantian();
			goodsInfoTiantian.setTiantian_seller_name("欧叶蛋糕"+i+"店");
			goodsInfoTiantian.setTiantian_seller_address("兰山区"+i*2);
			goodsInfoTiantian.setTiantian_goods_name("仅首1.5元！价值3元的葡式蛋挞1个，提供免费.."+i);
			goodsInfoTiantian.setTiantian_goods_jg("1.5");
			goodsInfoTiantian.setTiantian_goods_zk("五折购买");
			goodsInfoTiantian.setTiantian_goods_rs("18"+i+"人抢");

			list.add(goodsInfoTiantian);
		}
		adapter.notifyDataSetChanged();
	}
}
