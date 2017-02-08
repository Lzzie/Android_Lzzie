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
import com.saijie.youka.adapter.SquareInfoAdapter;
import com.saijie.youka.bean.SquareInfoBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 圈子——广场
 * Created by qiancheng on 2017/1/13.
 */

public class QZ_SquareFragment extends Fragment {
	@BindView(R.id.square_lv)
	 ListViewForScrollView squareLv;
	private SquareInfoAdapter squareInfoAdapter;
	private List<SquareInfoBean> list;
	private Context context;


	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.qz_square, container, false);
		ButterKnife.bind(this, view);
		initData();
		//模拟数据
		moni();
		return view;
	}

	private void moni() {
		for (int i = 0; i <5 ; i++) {
			SquareInfoBean sib= new SquareInfoBean();
			sib.setAdmires(i*30);
			sib.setComments(i*20);
			sib.setAduit_man("测试人"+(i+1));
			sib.setMessage("入选本帮派人气榜第"+(i+1)+"名");
			sib.setOrganization("火锅帮"+i);
			list.add(sib);
		}
		squareInfoAdapter.notifyDataSetChanged();
	}

	private void initData() {
		list = new ArrayList<>();
		squareInfoAdapter = new SquareInfoAdapter(context,list);
		squareLv.setAdapter(squareInfoAdapter);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		context=getActivity();
	}
}
