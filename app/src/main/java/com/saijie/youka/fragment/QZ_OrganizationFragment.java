package com.saijie.youka.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saijie.youka.R;
import com.saijie.youka.adapter.ListViewForScrollView;
import com.saijie.youka.adapter.OrganizationAdapter;
import com.saijie.youka.bean.OrganizationInfoBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 圈子——帮派
 * Created by qiancheng on 2017/1/13.
 */

public class QZ_OrganizationFragment extends Fragment {
	@BindView(R.id.orginzation_lv)
	ListViewForScrollView orginzationLv;
	private List<OrganizationInfoBean> list;
	private OrganizationAdapter adapter;
	private Context context;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.qz_orginzation, container, false);
		ButterKnife.bind(this, view);
		init();
		//模拟
		moni();
		return view;
	}

	private void moni() {
		String[] topics ={"火锅","甜食","冷饮","麻辣烫","烧烤"};
		for (int i = 0; i <5 ; i++) {
			OrganizationInfoBean infoBean = new OrganizationInfoBean();
			infoBean.setNew_topc(66);
			infoBean.setOrg_follow(16);
			infoBean.setOrg_topic(25);
			infoBean.setOrg_name(topics[i]);
			list.add(infoBean);
		}
		adapter.notifyDataSetChanged();
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		context= getActivity();
	}
	private void init(){
		list= new ArrayList<>();
		adapter= new OrganizationAdapter(context,list);
		orginzationLv.setAdapter(adapter);
	}
}
