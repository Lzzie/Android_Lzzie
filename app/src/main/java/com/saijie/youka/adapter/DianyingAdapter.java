package com.saijie.youka.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.saijie.youka.R;
import com.saijie.youka.bean.GoodsInfoDianying;

import java.util.List;

//import com.squareup.picasso.Picasso;

//import butterknife.BindView;
//import butterknife.ButterKnife;

/**
 * 2017-01-19
 *
 */

public class DianyingAdapter extends BaseAdapter {
	private Context myContextr;
	private List<GoodsInfoDianying> data;
	public DianyingAdapter(Context context, List<GoodsInfoDianying> list) {
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
		GoodsInfoDianying goodsInfoDianying = data.get(position);
		ViewHolder viewHolder;
		if (view==null){
			view = LayoutInflater.from(myContextr).inflate(R.layout.dianying_item_layout, null);
			viewHolder = new ViewHolder();
			viewHolder.moviesellerName= (TextView) view.findViewById(R.id.movie_seller_name);
			viewHolder.moviesellerJg= (TextView) view.findViewById(R.id.movie_seller_jg);
			viewHolder.moviesellerJl= (TextView) view.findViewById(R.id.movie_seller_jl);


			view.setTag(viewHolder);

		}else {
			viewHolder= (ViewHolder) view.getTag();
		}
		viewHolder.moviesellerName.setText(goodsInfoDianying.getMovie_seller_name()+"");
		viewHolder.moviesellerJg.setText(goodsInfoDianying.getMovie_seller_jg()+"");
		viewHolder.moviesellerJl.setText(goodsInfoDianying.getMovie_seller_jl()+"");

		return view;
	}

	 class ViewHolder {
		 TextView moviesellerName;
		 TextView moviesellerJg;
		 TextView moviesellerJl;

	}

}
