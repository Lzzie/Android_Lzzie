package com.saijie.youka.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.saijie.youka.R;
import com.saijie.youka.bean.GoodsInfoJiudian;

import java.util.List;

//import com.squareup.picasso.Picasso;

//import butterknife.BindView;
//import butterknife.ButterKnife;

/**
 * 2017-01-18
 *
 */

public class JiudianAdapter extends BaseAdapter {
	private Context myContextr;
	private List<GoodsInfoJiudian> data;
	public JiudianAdapter(Context context, List<GoodsInfoJiudian> list) {
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
		GoodsInfoJiudian goodsInfoJiudian = data.get(position);
		ViewHolder viewHolder;
		if (view==null){
			view = LayoutInflater.from(myContextr).inflate(R.layout.jiudian_item_layout, null);
			viewHolder = new ViewHolder();
			viewHolder.jiudiansellerName= (TextView) view.findViewById(R.id.jiudian_seller_name);
			viewHolder.jiudiansellerType= (TextView) view.findViewById(R.id.jiudian_seller_type);
			viewHolder.jiudiansellerPf= (TextView) view.findViewById(R.id.jiudian_seller_pf);
			viewHolder.jiudiansellerJg= (TextView) view.findViewById(R.id.jiudian_seller_jg);
			viewHolder.jiudiansellerJl= (TextView) view.findViewById(R.id.jiudian_seller_jl);

			view.setTag(viewHolder);

		}else {
			viewHolder= (ViewHolder) view.getTag();
		}
		viewHolder.jiudiansellerName.setText(goodsInfoJiudian.getJiudian_seller_name()+"");
		viewHolder.jiudiansellerType.setText(goodsInfoJiudian.getJiudian_seller_type()+"");
		viewHolder.jiudiansellerPf.setText(goodsInfoJiudian.getJiudian_seller_pf()+"");
		viewHolder.jiudiansellerJg.setText(goodsInfoJiudian.getJiudian_seller_jg()+"");
		viewHolder.jiudiansellerJl.setText(goodsInfoJiudian.getJiudian_seller_jl()+"");

		return view;
	}

	 class ViewHolder {
		 ImageView jiudiansellerImg;
		 TextView jiudiansellerName;
		 TextView jiudiansellerType;
		 TextView jiudiansellerPf;
		 TextView jiudiansellerJg;
		 TextView jiudiansellerJl;

	}

}
