package com.saijie.youka.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.saijie.youka.R;
import com.saijie.youka.fn.AddressActivity;
import com.saijie.youka.fn.SearchActivity;
import com.saijie.youka.util.BeanUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by qiancheng on 2017/1/12.
 */

public class FindFragment extends Fragment {
	@BindView(R.id.dizhi)
	TextView dizhi;
	@BindView(R.id.sousuo)
	ImageView sousuo;
	@BindView(R.id.iv_show_Pop)
	ImageView ivShowPop;
	private Context context;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.page_03, container, false);
		ButterKnife.bind(this, view);
		return view;
	}


	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		context = getActivity();
	}

	@OnClick({R.id.dizhi, R.id.sousuo, R.id.iv_show_Pop})
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.dizhi:
				showAddress();
				break;
			case R.id.sousuo:
				showSearch();
				break;
			case R.id.iv_show_Pop:
				new BeanUtil().showPop(ivShowPop, context);
				break;
		}
	}

	//搜索
	public void showSearch() {
		Intent intent = new Intent(context, SearchActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
		startActivity(intent);

	}

	//地址
	public void showAddress() {
		Intent intent = new Intent(context, AddressActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
		startActivity(intent);

	}

}
