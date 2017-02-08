package com.saijie.youka.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.saijie.youka.R;
import com.saijie.youka.adapter.ContractAdapter;
import com.saijie.youka.adapter.ListViewForScrollView;
import com.saijie.youka.bean.ContractBeanInfo;
import com.saijie.youka.bean.MyApplication;
import com.saijie.youka.layout.LinearLayoutForListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 圈子——亲密度
 * Created by qiancheng on 2017/1/13.
 */

public class QZ_IntimacyFragment extends Fragment {
	@BindView(R.id.intimacy_lv)
	LinearLayoutForListView intimacyLv;
	private List<ContractBeanInfo> list;
	private ContractAdapter adapter;
	private Context context;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.qz_intimacy, container, false);
		ButterKnife.bind(this, view);
		init();
		//模拟
		moni();
		return view;
	}


	private void moni() {
		for (int i = 0; i < 10; i++) {
			ContractBeanInfo beanInfo = new ContractBeanInfo();
			beanInfo.setFriend_name("张 "+i);
			beanInfo.setIntimacy_num(i*5);
			if (i%2==0){
				beanInfo.setQuan_flag(true);
			}else{
				beanInfo.setQuan_flag(false);
			}
			list.add(beanInfo);
		}
		intimacyLv.setAdapter(adapter);

	}

	void init(){
		list = new ArrayList<>();
		adapter= new ContractAdapter(context,list);
		intimacyLv.setAdapter(adapter);
		intimacyLv.setOnItemClickListener(new LinearLayoutForListView.OnItemClickListener() {
			@Override
			public void onItemClicked(View v, Object obj, int position) {
				Toast.makeText(MyApplication.getContext(), position+"", Toast.LENGTH_SHORT).show();
			}
		});

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		context= getActivity();
	}
}
