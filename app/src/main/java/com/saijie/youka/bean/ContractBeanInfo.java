package com.saijie.youka.bean;

/**
 * Created by qiancheng on 2017/1/14.
 */

public class ContractBeanInfo {
	private int id;
	private String friend_hp;
	private String friend_name;
	private int intimacy_num;
	private Boolean quan_flag;

	public String getFriend_hp() {
		return friend_hp;
	}

	public void setFriend_hp(String friend_hp) {
		this.friend_hp = friend_hp;
	}

	public String getFriend_name() {
		return friend_name;
	}

	public void setFriend_name(String friend_name) {
		this.friend_name = friend_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIntimacy_num() {
		return intimacy_num;
	}

	public void setIntimacy_num(int intimacy_num) {
		this.intimacy_num = intimacy_num;
	}

	public Boolean getQuan_flag() {
		return quan_flag;
	}

	public void setQuan_flag(Boolean quan_flag) {
		this.quan_flag = quan_flag;
	}
}
