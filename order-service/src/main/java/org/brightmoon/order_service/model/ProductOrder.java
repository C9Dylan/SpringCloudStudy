package org.brightmoon.order_service.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品订单实体类
 */
public class ProductOrder implements Serializable {

	private static final long serialVersionUID = -6840265919200667627L;

	/**
	 * 订单ID
	 */
	private int id;

	/**
	 * 订单号
	 */
	private String tradeNo;

	/**
	 * 价格,分
	 */
	private int price;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 下单用户ID
	 */
	private int userId;

	/**
	 * 下单用户姓名
	 */
	private String userName;

	/**
	 * 商品
	 */
	private Product product;

	
	public ProductOrder() {
		super();
	}


	public ProductOrder(int id, String tradeNo, int price, Date createTime, int userId, String userName,
			Product product) {
		super();
		this.id = id;
		this.tradeNo = tradeNo;
		this.price = price;
		this.createTime = createTime;
		this.userId = userId;
		this.userName = userName;
		this.product = product;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTradeNo() {
		return tradeNo;
	}


	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public Date getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}