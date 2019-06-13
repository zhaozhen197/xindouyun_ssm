package com.hello.model.button;

/**
 * click类型的按钮
 * Created by zane on 2016/10/27.
 */
public class ClickButton extends Button {
	//	类型
	private String type;

	private  String key;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
