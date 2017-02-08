package com.saijie.youka.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.saijie.youka.R;
import com.saijie.youka.bean.GoodsInfoChongzhi;

import java.util.List;


//import com.squareup.picasso.Picasso;

//import butterknife.BindView;
//import butterknife.ButterKnife;

/**
 * 2017-01-20
 *
 */

public class ChongzhiAdapter extends BaseAdapter {
	private Context myContextr;
	private List<GoodsInfoChongzhi> data;
	public ChongzhiAdapter(Context context, List<GoodsInfoChongzhi> list) {
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
	public View getView(final int position, View view, ViewGroup viewGroup) {
		GoodsInfoChongzhi goodsInfoChongzhi = data.get(position);
		ViewHolder viewHolder;
		if (view==null){
			view = LayoutInflater.from(myContextr).inflate(R.layout.chongzhi_item_layout, null);
			viewHolder = new ViewHolder();
			viewHolder.chongzhigoodsName= (TextView) view.findViewById(R.id.chongzhi_goods_name);
			viewHolder.chongzhigoodsJg= (TextView) view.findViewById(R.id.chongzhi_goods_jg);
			viewHolder.chongzhi= (LinearLayout) view.findViewById(R.id.chongzhi_ly);

			view.setTag(viewHolder);

		}else {
			viewHolder= (ViewHolder) view.getTag();
		}
		viewHolder.chongzhigoodsName.setText(goodsInfoChongzhi.getChongzhi_goods_name()+"");
		viewHolder.chongzhigoodsJg.setText(goodsInfoChongzhi.getChongzhi_goods_jg()+"");
		if (goodsInfoChongzhi.getChecked()){
			viewHolder.chongzhi.setSelected(true);
			viewHolder.chongzhigoodsName.setPressed(true);
			viewHolder.chongzhigoodsJg.setPressed(true);

		}else{
			viewHolder.chongzhi.setSelected(false);
			viewHolder.chongzhigoodsName.setPressed(false);
			viewHolder.chongzhigoodsJg.setPressed(false);
		}
		viewHolder.chongzhi.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				for (int i = 0; i < data.size(); i++) {
					data.get(i).setChecked(false);
				}
				data.get(position).setChecked(true);
				notifyDataSetChanged();
			}

		});


		return view;
	}

	 class ViewHolder {

		 private TextView chongzhigoodsName;
		 private TextView chongzhigoodsJg;
		 private LinearLayout chongzhi;

	}

}
