package org.brightmoon.order_service.service.feign;

import org.brightmoon.order_service.model.Product;
import org.brightmoon.order_service.response.Response;
import org.springframework.stereotype.Component;

@Component
public class ProductOrderFallback implements ProductOrderClient {

	@Override
	public Product queryProductById(Integer pid) {

		System.out.println("productOrder service fallback");

		return null;
	}

	@Override
	public Response<Object> feginTimeOutTest() {

		System.out.println("feginTimeOutTest fallback");

		return null;
	}
}