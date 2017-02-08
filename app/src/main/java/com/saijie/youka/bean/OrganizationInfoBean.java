package com.saijie.youka.bean;

/**
 * Created by qiancheng on 2017/1/14.
 */

public class OrganizationInfoBean {
	private int id;
	private String org_name;
	private int org_follow;
	private int org_topic;
	private String org_pic;
	private int new_topc;

	public int getNew_topc() {
		return new_topc;
	}

	public void setNew_topc(int new_topc) {
		this.new_topc = new_topc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public int getOrg_follow() {
		return org_follow;
	}

	public void setOrg_follow(int org_follow) {
		this.org_follow = org_follow;
	}

	public String getOrg_name() {
		return org_name;
	}

	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}

	public String getOrg_pic() {
		return org_pic;
	}

	public void setOrg_pic(String org_pic) {
		this.org_pic = org_pic;
	}

	public int getOrg_topic() {
		return org_topic;
	}

	public void setOrg_topic(int org_topic) {
		this.org_topic = org_topic;
	}
}
