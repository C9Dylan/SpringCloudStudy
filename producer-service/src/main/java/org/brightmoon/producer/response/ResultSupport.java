package org.brightmoon.producer.response;

import java.io.Serializable;

/**
 * Created by 明月   on 2018-11-16 / 22:28
 *
 * @Description: 响应结果的基类
 */
public class ResultSupport implements Serializable {

	private static final long serialVersionUID = -2235152751651905167L;

	private String message;
	
	private int code;

	public boolean isSuccess() {
		return code == 200;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}