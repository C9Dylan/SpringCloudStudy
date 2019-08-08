package org.brightmoon.order_service.service.ribbon;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import org.brightmoon.order_service.model.Product;
import org.brightmoon.order_service.model.ProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("ribbonService")
public class ProductOrderServiceImpl implements ProductOrderService {

	/**
	 * 商品生产者在eureka中注册名称
	 */
	private static final String SHOP_PRODUCER_APPLICATION_NAME = "product-service";

	private static final AtomicInteger ID = new AtomicInteger(0);

	private static final AtomicInteger PRICE = new AtomicInteger(100);

	@Autowired // 注入Ribbon包裹的RestTmplate
	private RestTemplate restTemplate;

	@Override
	public ProductOrder save(Integer userId, Integer productId) {

		ResponseEntity<Product> response = restTemplate
				.getForEntity("http://" + SHOP_PRODUCER_APPLICATION_NAME + "/api/v1/product/" + productId, Product.class);

		ProductOrder productOrder = new ProductOrder();
		productOrder.setId(ID.incrementAndGet());
		productOrder.setPrice(PRICE.addAndGet(10));
		productOrder.setCreateTime(new Date());
		productOrder.setUserId(userId);
		productOrder.setTradeNo(UUID.randomUUID().toString());
		productOrder.setUserName("张三" + ID.get());
		productOrder.setProduct(response.getBody());
		return productOrder;
	}
}
