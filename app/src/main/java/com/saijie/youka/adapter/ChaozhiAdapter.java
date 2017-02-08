package com.saijie.youka.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.saijie.youka.R;
import com.saijie.youka.bean.GoodsInfoChaozhi;

import java.util.List;

//import com.squareup.picasso.Picasso;

//import butterknife.BindView;
//import butterknife.ButterKnife;

/**
 * 2017-01-19
 *
 */

public class ChaozhiAdapter extends BaseAdapter {
	private Context myContextr;
	private List<GoodsInfoChaozhi> data;
	public ChaozhiAdapter(Context context, List<GoodsInfoChaozhi> list) {
		myContextr = context;
		data=list;
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int i) {
		return data.get(i);
	}

	@Override
	public long getItemId(int i) {
		return i;
	}

	@Override
	public View getView(int position, View view, ViewGroup viewGroup) {
		GoodsInfoChaozhi goodsInfoChaozhi = data.get(position);
		ViewHolder viewHolder;
		if (view==null){
			view = LayoutInflater.from(myContextr).inflate(R.layout.chaozhi_item_layout, null);
			viewHolder = new ViewHolder();
			viewHolder.chaozhisellerName= (TextView) view.findViewById(R.id.chaozhi_seller_name);
			viewHolder.chaozhisellerAddress= (TextView) view.findViewById(R.id.chaozhi_seller_address);
			viewHolder.chaozhigoodsName= (TextView) view.findViewById(R.id.chaozhi_goods_name);
			viewHolder.chaozhigoodsJg= (TextView) view.findViewById(R.id.chaozhi_goods_jg);
			viewHolder.chaozhigoodsZk= (TextView) view.findViewById(R.id.chaozhi_goods_zk);
			viewHolder.chaozhigoodsRs= (TextView) view.findViewById(R.id.chaozhi_goods_rs);
			viewHolder.jg2 = (TextView) view.findViewById(R.id.chaozhi_goods_jg2);

			view.setTag(viewHolder);

		}else {
			viewHolder= (ViewHolder) view.getTag();
		}
		viewHolder.chaozhisellerName.setText(goodsInfoChaozhi.getChaozhi_seller_name()+"");
		viewHolder.chaozhisellerAddress.setText(goodsInfoChaozhi.getChaozhi_seller_address()+"");
		viewHolder.chaozhigoodsName.setText(goodsInfoChaozhi.getChaozhi_goods_name()+"");
		viewHolder.chaozhigoodsJg.setText(goodsInfoChaozhi.getChaozhi_goods_jg()+"");
		viewHolder.chaozhigoodsZk.setText(goodsInfoChaozhi.getChaozhi_goods_zk()+"");
		viewHolder.chaozhigoodsRs.setText(goodsInfoChaozhi.getChaozhi_goods_rs()+"");
		viewHolder.jg2.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);

		return view;
	}

	 class ViewHolder {
		 ImageView chaozhisellerImg;
		 TextView chaozhisellerName;
		 TextView chaozhisellerAddress;
		 TextView chaozhigoodsName;
		 TextView chaozhigoodsJg;
		 TextView chaozhigoodsZk;
		 TextView chaozhigoodsRs;
		 TextView jg2;


	}

}
