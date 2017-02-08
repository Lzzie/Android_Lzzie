package com.saijie.youka.bean;

import java.util.List;

/**
 * Created by qiancheng on 2017/1/14.
 */

public class SquareInfoBean {
	private String id;
	private String message;
	private List<PictureInfo> pics;
	private String organization;
	private String aduit_man;
	private String type;
	private int admires;
	private int comments;

	public int getAdmires() {
		return admires;
	}

	public void setAdmires(int admires) {
		this.admires = admires;
	}

	public String getAduit_man() {
		return aduit_man;
	}

	public void setAduit_man(String aduit_man) {
		this.aduit_man = aduit_man;
	}

	public int getComments() {
		return comments;
	}

	public void setComments(int comments) {
		this.comments = comments;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public List<PictureInfo> getPics() {
		return pics;
	}

	public void setPics(List<PictureInfo> pics) {
		this.pics = pics;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
