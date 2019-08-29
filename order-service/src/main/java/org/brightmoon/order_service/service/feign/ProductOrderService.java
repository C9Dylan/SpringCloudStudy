package org.brightmoon.order_service.service.feign;

import org.brightmoon.order_service.model.ProductOrder;
import org.brightmoon.order_service.response.Response;

public interface ProductOrderService {
	/**
	 * 下单接口(feign调用)
	 */
	ProductOrder feignSava(Integer userId, Integer productId);

	/**
	 * feign timeout test
	 */
	Response<Object> feignTimeoutTest();
}
