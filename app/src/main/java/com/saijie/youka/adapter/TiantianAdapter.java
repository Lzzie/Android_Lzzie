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
import com.saijie.youka.bean.GoodsInfoTiantian;

import java.util.List;

//import com.squareup.picasso.Picasso;

//import butterknife.BindView;
//import butterknife.ButterKnife;

/**
 * 2017-01-19
 *
 */

public class TiantianAdapter extends BaseAdapter {
	private Context myContextr;
	private List<GoodsInfoTiantian> data;
	public TiantianAdapter(Context context, List<GoodsInfoTiantian> list) {
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



		GoodsInfoTiantian goodsInfoTiantian = data.get(position);
		ViewHolder viewHolder;
		if (view==null){
			view = LayoutInflater.from(myContextr).inflate(R.layout.tiantian_item_layout, null);
			viewHolder = new ViewHolder();
			viewHolder.tiantiansellerName= (TextView) view.findViewById(R.id.tiantian_seller_name);
			viewHolder.tiantiansellerAddress= (TextView) view.findViewById(R.id.tiantian_seller_address);
			viewHolder.tiantiangoodsName= (TextView) view.findViewById(R.id.tiantian_goods_name);
			viewHolder.tiantiangoodsJg= (TextView) view.findViewById(R.id.tiantian_goods_jg);
			viewHolder.tiantiangoodsZk= (TextView) view.findViewById(R.id.tiantian_goods_zk);
			viewHolder.tiantiangoodsRs= (TextView) view.findViewById(R.id.tiantian_goods_rs);
			viewHolder.jg2= (TextView) view.findViewById(R.id.tiantian_goods_jg2);

			view.setTag(viewHolder);

		}else {
			viewHolder= (ViewHolder) view.getTag();
		}
		viewHolder.tiantiansellerName.setText(goodsInfoTiantian.getTiantian_seller_name()+"");
		viewHolder.tiantiansellerAddress.setText(goodsInfoTiantian.getTiantian_seller_address()+"");
		viewHolder.tiantiangoodsName.setText(goodsInfoTiantian.getTiantian_goods_name()+"");
		viewHolder.tiantiangoodsJg.setText(goodsInfoTiantian.getTiantian_goods_jg()+"");
		viewHolder.tiantiangoodsZk.setText(goodsInfoTiantian.getTiantian_goods_zk()+"");
		viewHolder.tiantiangoodsRs.setText(goodsInfoTiantian.getTiantian_goods_rs()+"");
		viewHolder.jg2.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);

		return view;
	}

	 class ViewHolder {
		 ImageView tiantiansellerImg;
		 TextView tiantiansellerName;
		 TextView tiantiansellerAddress;
		 TextView tiantiangoodsName;
		 TextView tiantiangoodsJg;
		 TextView tiantiangoodsZk;
		 TextView tiantiangoodsRs;
		 TextView jg2;


	}

}
