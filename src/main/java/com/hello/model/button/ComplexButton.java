package com.hello.model.button;

/**
 * 复合按钮
 * Created by zane on 2016/10/27.
 */
public class ComplexButton extends Button{
	private Button[] sub_button;

	public Button[] getSub_button() {
		return sub_button;
	}

	public void setSub_button(Button[] sub_button) {
		this.sub_button = sub_button;
	}
}
