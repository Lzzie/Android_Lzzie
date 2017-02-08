package com.saijie.youka.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.saijie.youka.R;
import com.saijie.youka.bean.MyApplication;
import com.saijie.youka.bean.SquareInfoBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by qiancheng on 2017/1/14.
 */

public class SquareInfoAdapter extends BaseAdapter {
	private Context context;
	private List<SquareInfoBean> data;

	public SquareInfoAdapter(Context context, List<SquareInfoBean> data) {
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
	public View getView(int position, View view, ViewGroup viewGroup) {
		SquareInfoBean squareInfoBean = data.get(position);
		ViewHolder viewHolder=null;
//		if (view==null){
			view = LayoutInflater.from(MyApplication.getContext()).inflate(R.layout.square_item, null);
			viewHolder= new ViewHolder(view);

//		}else{
//			viewHolder= (ViewHolder) view.getTag();
//		}
		viewHolder.squareMsg.setText(squareInfoBean.getMessage());
		viewHolder.organization.setText(squareInfoBean.getOrganization());
		viewHolder.auditMan.setText(squareInfoBean.getAduit_man());
		viewHolder.admires.setText(squareInfoBean.getAdmires()+"");
		viewHolder.comments.setText(squareInfoBean.getComments()+"");
		return view;
	}

	static class ViewHolder {
		@BindView(R.id.square_msg)
		TextView squareMsg;
		@BindView(R.id.organization)
		TextView organization;
		@BindView(R.id.img1)
		ImageView img1;
		@BindView(R.id.img2)
		ImageView img2;
		@BindView(R.id.img3)
		ImageView img3;
		@BindView(R.id.headpic)
		ImageView headpic;
		@BindView(R.id.audit_man)
		TextView auditMan;
		@BindView(R.id.square_type)
		TextView squareType;
		@BindView(R.id.admires)
		TextView admires;
		@BindView(R.id.comments)
		TextView comments;

		ViewHolder(View view) {
			ButterKnife.bind(this, view);
		}
	}
}
