package com.saijie.youka.fn;

import android.os.Bundle;
import android.widget.ListView;

import com.saijie.youka.R;
import com.saijie.youka.adapter.ChaozhiAdapter;
import com.saijie.youka.base.BaseActivity;
import com.saijie.youka.bean.GoodsInfoChaozhi;

import java.util.ArrayList;
import java.util.List;

public class ChaozhiActivity extends BaseActivity {


	ListView goodsLv;
	private List<GoodsInfoChaozhi> list;
	private ChaozhiAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chaozhi);

		goodsLv =(ListView)findViewById(R.id.chaozhi_goods_lv);//初始化
		initData();//goodsLv
	}
	private void initData() {
		list = new ArrayList<>();
		adapter = new ChaozhiAdapter(this,list);
		goodsLv.setAdapter(adapter);
		for(int i =0;i<8;i++){
			GoodsInfoChaozhi goodsInfoChaozhi = new GoodsInfoChaozhi();
			goodsInfoChaozhi.setChaozhi_seller_name("优各尔鲜奶吧(汉堡)"+i+"店");
			goodsInfoChaozhi.setChaozhi_seller_address("兰山区"+i*2);
			goodsInfoChaozhi.setChaozhi_goods_name("一个鸡腿堡+一份薯条+两串骨肉相连+中可.."+i);
			goodsInfoChaozhi.setChaozhi_goods_jg("1"+i);
			goodsInfoChaozhi.setChaozhi_goods_zk("五折购买");
			goodsInfoChaozhi.setChaozhi_goods_rs("18"+i+"人抢");

			list.add(goodsInfoChaozhi);
		}
		adapter.notifyDataSetChanged();
	}

}
