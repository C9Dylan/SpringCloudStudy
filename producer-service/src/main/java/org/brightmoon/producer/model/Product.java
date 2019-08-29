package org.brightmoon.producer.model;

public class Product {
	/**
	 * 商品ID
	 */
	private Integer id;
	/**
	 * 商品姓名
	 */
	private String name;
	/**
	 * 商品价格
	 */
	private Integer price;
	/**
	 * 商品库存
	 */
	private Integer store;

	public Product() {
		super();
	}

	public Product(Integer id, String name, Integer price, Integer store) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.store = store;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getStore() {
		return store;
	}

	public void setStore(Integer store) {
		this.store = store;
	}
}