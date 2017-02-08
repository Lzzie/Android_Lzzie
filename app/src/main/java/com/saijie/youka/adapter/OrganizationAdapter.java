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
import com.saijie.youka.bean.OrganizationInfoBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by qiancheng on 2017/1/14.
 */

public class OrganizationAdapter extends BaseAdapter {
	private List<OrganizationInfoBean> data;
	private Context context;

	public OrganizationAdapter(Context context, List<OrganizationInfoBean> data) {
		this.data = data;
		this.context = context;
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
		OrganizationInfoBean infoBean = data.get(position);
		ViewHolder viewHolder=null;
		if (view==null){
			view = LayoutInflater.from(MyApplication.getContext()).inflate(R.layout.organization_item, null);
			viewHolder = new ViewHolder(view);
			view.setTag(viewHolder);
		}else{
			viewHolder= (ViewHolder) view.getTag();
		}
		viewHolder.orgName.setText(infoBean.getOrg_name());
		viewHolder.orgFollow.setText("关注 "+infoBean.getOrg_follow()+"");
		viewHolder.topic.setText("话题 "+infoBean.getOrg_topic()+"");
		viewHolder.newTopic.setText(infoBean.getNew_topc()+"+");
		return view;
	}

	static class ViewHolder {
		@BindView(R.id.org_pic)
		ImageView orgPic;
		@BindView(R.id.org_name)
		TextView orgName;
		@BindView(R.id.org_follow)
		TextView orgFollow;
		@BindView(R.id.topic)
		TextView topic;
		@BindView(R.id.new_topic)
		TextView newTopic;

		ViewHolder(View view) {
			ButterKnife.bind(this, view);
		}
	}
}
