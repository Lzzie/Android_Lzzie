package com.saijie.youka.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.saijie.youka.R;
import com.saijie.youka.bean.GoodsInfoYule;

import java.util.List;

//import com.squareup.picasso.Picasso;

//import butterknife.BindView;
//import butterknife.ButterKnife;

/**
 * 2017-01-18
 *
 */

public class YuleAdapter extends BaseAdapter {
	private Context myContextr;
	private List<GoodsInfoYule> data;
	public YuleAdapter(Context context, List<GoodsInfoYule> list) {
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
		GoodsInfoYule goodsInfoYule = data.get(position);
		ViewHolder viewHolder;
		if (view==null){
			view = LayoutInflater.from(myContextr).inflate(R.layout.yule_item_layout, null);
			viewHolder = new ViewHolder();
			viewHolder.yulesellerName= (TextView) view.findViewById(R.id.yule_seller_name);
			viewHolder.yulesellerPf= (TextView) view.findViewById(R.id.yule_seller_pf);
			viewHolder.yulesellerJg= (TextView) view.findViewById(R.id.yule_seller_jg);
			viewHolder.yulesellerJl= (TextView) view.findViewById(R.id.yule_seller_jl);
			viewHolder.yulesellerHuodong= (TextView) view.findViewById(R.id.yule_seller_huodong);

			view.setTag(viewHolder);

		}else {
			viewHolder= (ViewHolder) view.getTag();
		}
			viewHolder.yulesellerName.setText(goodsInfoYule.getYule_seller_name()+"");
			viewHolder.yulesellerPf.setText(goodsInfoYule.getYule_seller_pf()+"");
			viewHolder.yulesellerJg.setText(goodsInfoYule.getYule_seller_jg()+"");
			viewHolder.yulesellerJl.setText(goodsInfoYule.getYule_seller_jl()+"");
			viewHolder.yulesellerHuodong.setText(goodsInfoYule.getYule_seller_huodong()+"");

		return view;
	}

	 class ViewHolder {
		 ImageView yulesellerImg;
		 TextView yulesellerName;
		 TextView yulesellerPf;
		 TextView yulesellerJg;
		 TextView yulesellerJl;
		 TextView yulesellerHuodong;
	}

}
