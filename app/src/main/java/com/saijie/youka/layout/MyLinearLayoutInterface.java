package com.saijie.youka.layout;

import android.view.View;

/**
 * Created by qiancheng on 2017/1/16.
 */

public interface MyLinearLayoutInterface {
	int getCount();

	Object getItem(int position);

	View getView(int position);
}
