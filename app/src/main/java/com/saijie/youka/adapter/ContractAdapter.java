package com.saijie.youka.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.saijie.youka.R;
import com.saijie.youka.bean.ContractBeanInfo;
import com.saijie.youka.bean.MyApplication;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by qiancheng on 2017/1/14.
 */

public class ContractAdapter extends BaseAdapter {
	private Context context;
	private List<ContractBeanInfo> data;

	public ContractAdapter(Context context, List<ContractBeanInfo> data) {
		this.context = context;
		this.data = data;
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
	public View getView(int i, View view, ViewGroup viewGroup) {
		ContractBeanInfo beanInfo = data.get(i);
		ViewHolder viewHolder = null;
		if (view == null) {
			view = LayoutInflater.from(MyApplication.getContext()).inflate(R.layout.contract_item, null);
			viewHolder = new ViewHolder(view);
			view.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) view.getTag();
		}
		viewHolder.orderNum.setText(i + 1 + "");
		viewHolder.friendName.setText(beanInfo.getFriend_name());
		viewHolder.intimacyNum.setText(beanInfo.getIntimacy_num() + "");
		if (beanInfo.getQuan_flag()) {
			viewHolder.quan.setVisibility(View.VISIBLE);
		} else {
			viewHolder.quan.setVisibility(View.INVISIBLE);
		}
		return view;
	}

	static class ViewHolder {
		@BindView(R.id.order_num)
		TextView orderNum;
		@BindView(R.id.friend_hp)
		ImageView friendHp;
		@BindView(R.id.friend_name)
		TextView friendName;
		@BindView(R.id.quan)
		ImageView quan;
		@BindView(R.id.intimacy_num)
		TextView intimacyNum;

		ViewHolder(View view) {
			ButterKnife.bind(this, view);
		}
	}
}
