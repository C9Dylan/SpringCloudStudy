package org.brightmoon.producer.service.impl;

import java.util.List;

import org.brightmoon.producer.model.Product;

public interface ProducerService {
	
	/**
	 * 查询所有商品
	 */
	List<Product> queryAllProduct();

	/**
	 * 根据商品ID查询商品
	 */
	Product queryProductById(Integer id);
}
