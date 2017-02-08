package com.saijie.youka.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by qiancheng on 2017/1/16.
 */

public class MyLinearLayout extends LinearLayout {
	private int lastX;
	private int lastY;


	public MyLinearLayout(Context context) {
		super(context);
	}

	public MyLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}


	@Override
	public boolean onInterceptTouchEvent(MotionEvent e) {
		boolean isIntercept = false;
		int action = e.getAction();
		int currentX = (int) e.getX();
		int currentY = (int) e.getY();
		switch (action){
			case MotionEvent.ACTION_DOWN:
				isIntercept = false;//点击事件分发给子控件
				break;
			case MotionEvent.ACTION_MOVE:
				int deltaX = currentX - lastX;
				int deltaY = currentY - lastY;
				if(Math.abs(deltaX) > Math.abs(deltaY)){//父容器拦截
					Log.i("Mylayout","拦截成功");
					isIntercept = true;
				}else {//点击事件分发给子控件
					Log.i("Mylayout","拦截失败");
					isIntercept = false;
				}
				break;
			case MotionEvent.ACTION_UP:
				isIntercept = false;//点击事件分发给子控件
				break;
		}
		//记录上次滑动的位置
		lastX = currentX;
		lastY = currentY;
		return isIntercept;
	}


}

