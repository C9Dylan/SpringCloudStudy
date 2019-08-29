package org.brightmoon.producer.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.brightmoon.producer.model.Product;
import org.brightmoon.producer.service.impl.ProducerService;
import org.springframework.stereotype.Service;

@Service
public class ProducerServiceImpl implements ProducerService {

	/**
	 * 模拟数据源
	 */
	private static final Map<Integer, Product> DATA_SOURCE = new HashMap<>();

	static {
		Product p1 = new Product(1, "iphoneXS Max", 12000, 153);
		Product p2 = new Product(2, "iPad", 5060, 123);
		Product p3 = new Product(3, "液晶电视", 15000, 100);
		Product p4 = new Product(4, "高档冰箱", 12040, 406);
		Product p5 = new Product(5, "Java编程思想", 100, 452);

		DATA_SOURCE.put(p1.getId(), p1);
		DATA_SOURCE.put(p2.getId(), p2);
		DATA_SOURCE.put(p3.getId(), p3);
		DATA_SOURCE.put(p4.getId(), p4);
		DATA_SOURCE.put(p5.getId(), p5);
	}

	/**
	 * 商品列表
	 */
	public List<Product> queryAllProduct() {
		return new ArrayList<Product>(DATA_SOURCE.values());
	}

	/**
	 * 根据ID查询商品
	 */
	public Product queryProductById(Integer id) {
		return DATA_SOURCE.get(id);
	}
}