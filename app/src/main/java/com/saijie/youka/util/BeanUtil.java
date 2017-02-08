package com.saijie.youka.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.saijie.youka.R;
import com.saijie.youka.fn.AboutActivity;
import com.saijie.youka.fn.FqjcActivity;
import com.saijie.youka.fn.FriendActivity;
import com.saijie.youka.pop.ActionItem;
import com.saijie.youka.pop.TitlePopup;
import com.saijie.youka.pop.TitlePopup2;
import com.saijie.youka.qr.CaptureActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by qiancheng on 2016/11/24.
 */
public class BeanUtil {
	private ProgressDialog progressDialog;
	private Context mContext;
	private  static TitlePopup titlePopup;
	private  static TitlePopup2 titlePopup2;


	/**
	 * 显示 ProgressDialog
	 *
	 * @param context
	 * @param title
	 * @param content
	 */
	public void showProgressDialog(Context context, String title, String content) {
		progressDialog = new ProgressDialog(context);
		progressDialog.setTitle(title);
		progressDialog.setMessage(content);
		progressDialog.show();
	}

	/**
	 * 关闭 ProgressDialog
	 */
	public void dismissProgressDialog() {
		if (progressDialog != null) {
			progressDialog.dismiss();
		}
	}

	/**
	 * 动态测量listview的高度，解决ScrollView和ListView嵌套的出现的问题
	 *
	 * @param listView
	 */
	public static void setListViewHeightBasedOnChildren(ListView listView) {
		if (listView == null) return;
		ListAdapter listAdapter = listView.getAdapter();
		if (listAdapter == null) {
			// pre-condition
			return;
		}
		if (listAdapter.getCount() == 0) {
			return;
		}
		int totalHeight = 0;
		for (int i = 0; i < listAdapter.getCount(); i++) {
			View listItem = listAdapter.getView(i, null, listView);
			listItem.measure(0, 0);
			totalHeight += listItem.getMeasuredHeight();
		}
		ViewGroup.LayoutParams params = listView.getLayoutParams();
		params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
		listView.setLayoutParams(params);
	}

	public static int dp2px(Context context, float dp) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dp * scale + 0.5f);
	}

	public static int px2dp(Context context, float px) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (px / scale + 0.5f);
	}

	/**
	 * 判断是否为手机号
	 *
	 * @param mobiles
	 * @return
	 */

	public static boolean isMobileNO(String mobiles) {

		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");

		Matcher m = p.matcher(mobiles);

		return m.matches();

	}
	public  void showPop(View v,Context context) {
		mContext=context;
		if (titlePopup==null){
			init();
		}
		titlePopup.show(v);
	}

	public  void showPop2(View v,Context context) {
		mContext=context;
		if (titlePopup2==null){
			init2();
		}
		titlePopup2.show(v);

	}

	private  void init() {

		// 实例化标题栏弹窗
		titlePopup = new TitlePopup(mContext, ViewGroup.LayoutParams.WRAP_CONTENT,
				ViewGroup.LayoutParams.WRAP_CONTENT);
		titlePopup.setItemOnClickListener(onitemClick);
		// 给标题栏弹窗添加子类
		titlePopup.addAction(new ActionItem(mContext, R.string.groupchat,
				R.mipmap.icon_menu_group));
		titlePopup.addAction(new ActionItem(mContext, R.string.addfriend,
				R.mipmap.icon_menu_addfriend));
		titlePopup.addAction(new ActionItem(mContext, R.string.qrcode,
				R.mipmap.icon_menu_sao));
		titlePopup.addAction(new ActionItem(mContext, R.string.money,
				R.mipmap.abv));
	}

	private TitlePopup.OnItemOnClickListener onitemClick = new TitlePopup.OnItemOnClickListener() {
		@Override
		public void onItemClick(ActionItem item, int position) {
			// mLoadingDialog.show();
			// Toast.makeText(context, "发起聚餐",1).show();
			switch (position) {
				case 0:// 发起聚餐
					Toast.makeText(mContext, "发起聚餐", Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(mContext, FqjcActivity.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
					mContext.startActivity(intent);
					break;
				case 1:// 收付款
					Toast.makeText(mContext, " 收付款", Toast.LENGTH_SHORT).show();
					intent = new Intent(mContext, FriendActivity.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
					mContext.startActivity(intent);
					break;
				case 2:// 扫一扫
					Toast.makeText(mContext, "扫一扫", Toast.LENGTH_SHORT).show();
					intent = new Intent(mContext, CaptureActivity.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
					mContext.startActivity(intent);
					break;
				case 3:// 关于与帮助
					Toast.makeText(mContext, "关于与帮助", Toast.LENGTH_SHORT).show();
					intent = new Intent(mContext, AboutActivity.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
					mContext.startActivity(intent);
					break;
			}
		}

	};

	private  void init2() {

		// 实例化标题栏弹窗
		titlePopup2 = new TitlePopup2(mContext, ViewGroup.LayoutParams.WRAP_CONTENT,
				ViewGroup.LayoutParams.WRAP_CONTENT);
		titlePopup2.setItemOnClickListener(onitemClick2);
		// 给标题栏弹窗添加子类
		titlePopup2.addAction(new ActionItem(mContext, "瑜伽",
				R.mipmap.icon_menu_yujia));
		titlePopup2.addAction(new ActionItem(mContext, "箭艺",
				R.mipmap.icon_menu_jianyi));
		titlePopup2.addAction(new ActionItem(mContext, "代驾",
				R.mipmap.icon_menu_daijia));
	}

	private TitlePopup2.OnItemOnClickListener onitemClick2 = new TitlePopup2.OnItemOnClickListener() {
		@Override
		public void onItemClick(ActionItem item, int position) {
			// mLoadingDialog.show();
			// Toast.makeText(context, "发起聚餐",1).show();
			switch (position) {
				case 0:// 发起聚餐
					Toast.makeText(mContext, "瑜伽", Toast.LENGTH_SHORT).show();
//					Intent intent = new Intent(mContext, FqjcActivity.class);
//					intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
//					mContext.startActivity(intent);
					break;
				case 1:// 收付款
					Toast.makeText(mContext, "箭艺", Toast.LENGTH_SHORT).show();
//					intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
//					mContext.startActivity(intent);
					break;
				case 2:// 收付款
					Toast.makeText(mContext, "代驾", Toast.LENGTH_SHORT).show();
//					intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
//					mContext.startActivity(intent);
					break;

			}
		}

	};



}
