package com.saijie.youka.fn;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;

import com.saijie.youka.R;
import com.saijie.youka.adapter.ChongzhiAdapter;
import com.saijie.youka.base.BaseActivity;
import com.saijie.youka.bean.GoodsInfoChongzhi;

import java.util.ArrayList;
import java.util.List;

public class ChongzhiActivity extends BaseActivity {

	//获得通讯录联系人
	EditText text;
	String username,usernumber;


	GridView goodsgv;
	private List<GoodsInfoChongzhi> list;
	private ChongzhiAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chongzhi);

		goodsgv =(GridView)findViewById(R.id.chongzhi_goods_gv);//初始化

		initData();//goodsLv

		text = (EditText)findViewById(R.id.number);	//获得通讯录联系人

	}
	private void initData() {
		list = new ArrayList<>();
		adapter = new ChongzhiAdapter(this,list);
		goodsgv.setAdapter(adapter);
		for(int i =0;i<8;i++){
			GoodsInfoChongzhi goodsInfoChongzhi = new GoodsInfoChongzhi();
			goodsInfoChongzhi.setChongzhi_goods_name("￥"+(i*20+10));
			goodsInfoChongzhi.setChongzhi_goods_jg("售价:"+(9.8+i*19));
			goodsInfoChongzhi.setChecked(false);

			list.add(goodsInfoChongzhi);
		}
		adapter.notifyDataSetChanged();
	}


	//获得通讯录联系人
	public void click(View v){
		startActivityForResult(new Intent(
				Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI), 0);
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == Activity.RESULT_OK) {
			ContentResolver reContentResolverol = getContentResolver();
			Uri contactData = data.getData();
			@SuppressWarnings("deprecation")
			Cursor cursor = managedQuery(contactData, null, null, null, null);
			cursor.moveToFirst();
			username = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
			String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
			Cursor phone = reContentResolverol.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
					null,
					ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + contactId,
					null,
					null);
			while (phone.moveToNext()) {
				usernumber = phone.getString(phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
				text.setText(usernumber+" ("+username+")");
			}

		}
	}



}
