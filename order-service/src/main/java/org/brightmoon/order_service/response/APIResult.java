package org.brightmoon.order_service.response;

/**
 * Created by 明月   on 2018-11-16 / 22:28
 *
 * @Description: API接口的响应结果
 */
public class APIResult<T> extends ResultSupport {

	private static final long serialVersionUID = -3940839161100610892L;

	protected T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	/**
	 * 接口调用失败,有错误字符串码和描述,有返回对象
	 * @param code
	 * @param message
	 * @param data
	 * @param <U>
	 * @return
	 */
	public static <U> APIResult<U> newFailResult(int code, String message, U data) {
		APIResult<U> apiResult = new APIResult<U>();
		apiResult.setCode(code);
		apiResult.setMessage(message);
		apiResult.setData(data);
		return apiResult;
	}

	/**
	 * 接口调用失败,有错误字符串码和描述,没有返回对象
	 * @param code
	 * @param message
	 * @param <U>
	 * @return
	 */
	public static <U> APIResult<U> newFailResult(int code, String message) {
		APIResult<U> apiResult = new APIResult<U>();
		apiResult.setCode(code);
		apiResult.setMessage(message);
		return apiResult;
	}

	public static <U> APIResult<U> newSuccessResult(U data){
        APIResult<U> apiResult = new APIResult<U>();
        apiResult.setData(data);
        return apiResult;
    }
}