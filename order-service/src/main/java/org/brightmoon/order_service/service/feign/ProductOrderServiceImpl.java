package org.brightmoon.order_service.service.feign;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import org.brightmoon.order_service.model.Product;
import org.brightmoon.order_service.model.ProductOrder;
import org.brightmoon.order_service.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("feignService")
public class ProductOrderServiceImpl implements ProductOrderService {

	private static final AtomicInteger ID = new AtomicInteger(0);

	private static final AtomicInteger PRICE = new AtomicInteger(100);

	@Autowired
	private ProductOrderClient feignClient;

	@Override
	public ProductOrder feignSava(Integer userId, Integer pid) {

		Product product = feignClient.queryProductById(pid);

		ProductOrder productOrder = new ProductOrder();
		productOrder.setId(ID.incrementAndGet());
		productOrder.setPrice(PRICE.addAndGet(10));
		productOrder.setCreateTime(new Date());
		productOrder.setUserId(userId);
		productOrder.setTradeNo(UUID.randomUUID().toString());
		productOrder.setUserName("张三" + ID.get());
		productOrder.setProduct(product);

		return productOrder;
	}

	@Override
	public Response<Object> feignTimeoutTest() {
		return feignClient.feginTimeOutTest();
	}
}
