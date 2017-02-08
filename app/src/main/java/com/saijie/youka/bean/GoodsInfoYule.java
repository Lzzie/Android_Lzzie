package com.saijie.youka.bean;

import android.widget.ImageView;

/**
 * 2017-01-12 Reservation
 * 娱乐
 */
public class GoodsInfoYule {
	private ImageView yule_seller_img; //商家图片
	private String yule_seller_name;//商家名称
	private String yule_seller_pf;  //商家评分
	private String yule_seller_jg;  //价格
	private String yule_seller_jl;  //用户与商户的距离
	private String yule_seller_huodong;//活动

	public ImageView getYule_seller_img() {
		return yule_seller_img;
	}

	public void setYule_seller_img(ImageView yule_seller_img) {
		this.yule_seller_img = yule_seller_img;
	}

	public String getYule_seller_name() {
		return yule_seller_name;
	}

	public void setYule_seller_name(String yule_seller_name) {
		this.yule_seller_name = yule_seller_name;
	}

	public String getYule_seller_pf() {
		return yule_seller_pf;
	}

	public void setYule_seller_pf(String yule_seller_pf) {
		this.yule_seller_pf = yule_seller_pf;
	}

	public String getYule_seller_jg() {
		return yule_seller_jg;
	}

	public void setYule_seller_jg(String yule_seller_jg) {
		this.yule_seller_jg = yule_seller_jg;
	}

	public String getYule_seller_jl() {
		return yule_seller_jl;
	}

	public void setYule_seller_jl(String yule_seller_jl) {
		this.yule_seller_jl = yule_seller_jl;
	}

	public String getYule_seller_huodong() {
		return yule_seller_huodong;
	}

	public void setYule_seller_huodong(String yule_seller_huodong) {
		this.yule_seller_huodong = yule_seller_huodong;
	}
}
